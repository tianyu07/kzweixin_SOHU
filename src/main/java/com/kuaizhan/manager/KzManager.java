package com.kuaizhan.manager;

import com.google.common.collect.ImmutableMap;
import com.kuaizhan.config.ApplicationConfig;
import com.kuaizhan.config.KzApiConfig;
import com.kuaizhan.exception.kuaizhan.Export2KzException;
import com.kuaizhan.exception.kuaizhan.GetKzArticleException;
import com.kuaizhan.exception.kuaizhan.KZPicUploadException;
import com.kuaizhan.exception.kuaizhan.KzApiException;
import com.kuaizhan.pojo.dto.ArticleDTO;
import com.kuaizhan.pojo.po.PostPO;
import com.kuaizhan.utils.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mongodb.util.JSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

/**
 * 对主站Api的封装和异常转换
 * Created by zixiong on 2017/5/10.
 */
public class KzManager {

    /**
     * 获取根据pageId获取快文
     */
    public static ArticleDTO getKzArticle(long pageId) throws GetKzArticleException{

        Map<String, String> headers = new HashMap<>();
        headers.put("Host", ApplicationConfig.KZ_SERVICE_HOST);
        String result = HttpClientUtil.get(KzApiConfig.getKzArticleUrl(pageId), headers);

        if (result == null) {
            throw new GetKzArticleException("[Kz:getKzArticle] result is null, pageId:" + pageId);
        }
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(result);
        } catch (JSONException e) {
            throw new GetKzArticleException("[Kz:getKzArticle] json parse failed, pageId:" + pageId, e);
        }
        ArticleDTO articleDTO = null;
        if (jsonObject.getInt("ret") == 0) {
            articleDTO = JsonUtil.string2Bean(jsonObject.get("data").toString(), ArticleDTO.class);
        }
        return articleDTO;
    }

    /**
     * 把外部图片上传到主站，转换为快站链接
     */
    public static String uploadPicToKz(String url) throws KZPicUploadException {

        String fileName = HttpClientUtil.downloadFile(url);
        File file = new File(fileName);

        HttpResponse<JsonNode> jsonResponse;
        try {
             jsonResponse = Unirest.post(KzApiConfig.KZ_UPLOAD_PIC_V2)
                    .field("file", file)
                    .asJson();
        } catch (UnirestException e) {
            throw new KZPicUploadException("[uploadPicToKz] upload failed");
        } finally {
            file.delete();
        }

        if (jsonResponse.getStatus() == 200) {
            JSONObject jsonResult = jsonResponse.getBody().getObject();
            return KzApiConfig.KZ_PIC_DOMAIN + jsonResult.getJSONObject("data").getString("url");
        } else {
            throw new KZPicUploadException("[uploadPicToKz] status code not 200, jsonResponse:" + jsonResponse);
        }
    }

    /**
     * 导出图文到快站文章
     * @throws Export2KzException 快站返回的不是预期结果
     */
    public static void export2KzArticle(long siteId, long categoryId, PostPO postPO, String content) throws Export2KzException {
        Map<String, Object> param = new HashMap<>();
        param.put("site_id", siteId);
        param.put("post_category_id", categoryId);
        param.put("post_title", postPO.getTitle());
        param.put("post_desc", postPO.getDigest());
        param.put("pic_url", UrlUtil.fixProtocol(postPO.getThumbUrl()));
        param.put("post_content", content);

        String result = HttpClientUtil.post(KzApiConfig.KZ_POST_ARTICLE_URL, param);
        if (result == null) {
            throw new Export2KzException("[Kz:export2KzArticle] result is null, pageId:" + postPO.getPageId());
        }
        JSONObject returnJson;
        try {
            returnJson = new JSONObject(result);
        } catch (JSONException e) {
            throw new Export2KzException("[Kz:export2KzArticle] JsonParse error, pageId:" + postPO.getPageId() + " result:" + result, e);
        }
        if (returnJson.getInt("ret") != 0) {
            throw new Export2KzException("[Kz:export2KzArticle] return code error, pageId:" + postPO.getPageId() + " result:" + result);
        }
    }

    /**
     * 申请快站推送token
     * @return clientId和token组成的map
     */
    public static Map<String, String> applyPushToken() {
        int timestamp = DateUtil.curSeconds();
        String sign = EncryptUtil.md5(ApplicationConfig.KZ_PUSH_ACCESS_ID + ApplicationConfig.KZ_PUSH_ACCESS_KEY + timestamp);

        Map<String, Object> param = new HashMap<>();
        param.put("accessId", ApplicationConfig.KZ_PUSH_ACCESS_ID);
        param.put("timestamp", timestamp);
        param.put("sign", sign);
        param.put("ttl", 30 * 60);

        String result = HttpClientUtil.postJson(KzApiConfig.KZ_APPLY_PUSH_TOKEN, JsonUtil.bean2String(param));
        if (result == null) {
            throw new KzApiException("[Kz:applyPushToken] result is null");
        }
        JSONObject returnJson;
        try {
            returnJson = new JSONObject(result);
        } catch (JSONException e) {
            throw new KzApiException("[Kz:applyPushToken] Json Parse Error, result:" + result);
        }
        int code = returnJson.optInt("code");
        if (code != 0) {
            throw new KzApiException("[Kz:applyPushToken] apply token failed, result:" + result);
        }

        JSONObject data = returnJson.getJSONObject("data");
        String clientId = data.getString("clientId");
        String token = data.getString("token");

        return ImmutableMap.of("clientId", clientId, "token", token);
    }
}
