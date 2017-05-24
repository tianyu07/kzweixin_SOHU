package com.kuaizhan.manager;

import com.kuaizhan.config.ApplicationConfig;
import com.kuaizhan.config.KzApiConfig;
import com.kuaizhan.exception.kuaizhan.Export2KzException;
import com.kuaizhan.exception.kuaizhan.GetKzArticleException;
import com.kuaizhan.exception.kuaizhan.KZPicUploadException;
import com.kuaizhan.pojo.dto.ArticleDTO;
import com.kuaizhan.pojo.po.PostPO;
import com.kuaizhan.utils.HttpClientUtil;
import com.kuaizhan.utils.JsonUtil;
import com.kuaizhan.utils.UrlUtil;
import org.json.JSONException;
import org.json.JSONObject;

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
        String result = HttpClientUtil.get(KzApiConfig.getKzArticleUrl(pageId));

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
    public static String uploadPicToKz(String url, long userId) throws KZPicUploadException {
        Map<String, Object> params = new HashMap<>();
        params.put("img_url", url);
        params.put("uid", userId);
        // 指定host
        Map<String, String> headers = new HashMap<>();
        headers.put("Host", ApplicationConfig.KZ_SERVICE_HOST);

        String result = HttpClientUtil.post(KzApiConfig.KZ_UPLOAD_PIC_URL, params, headers);
        if (result == null) {
            String msg = "[上传图片到快站] 上传失败，url: " +  KzApiConfig.KZ_UPLOAD_PIC_URL + " param: " + params + "headers: " + headers;
            throw new KZPicUploadException(msg);
        }

        JSONObject returnJson;
        try {
            returnJson = new JSONObject(result);
        }catch (JSONException e){
            String msg = "[上传图片到快站] 上传失败，url: " +  KzApiConfig.KZ_UPLOAD_PIC_URL + " param: " + params + "headers: " + headers + " result: " + result;
            throw new KZPicUploadException(msg, e);
        }

        if (returnJson.getInt("ret") == 0) {
            JSONObject data = returnJson.getJSONObject("data");
            return UrlUtil.fixProtocol(data.getString("url"));
        } else {
            String msg = "[上传图片到快站] 上传失败，url: " +  KzApiConfig.KZ_UPLOAD_PIC_URL + " param: " + params + "headers: " + headers + " result: " + result;
            throw new KZPicUploadException(msg);
        }
    }

    /**
     * 导出图文到快站文章
     * @throws Export2KzException 快站返回的不是预期结果
     */
    public static void export2KzArticle(long siteId, long categoryId, PostPO postPO, String content) throws Export2KzException {
        Map<String,Object> param=new HashMap<>();
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
        if (returnJson.getInt("result") != 0) {
            throw new Export2KzException("[Kz:export2KzArticle] return code error, pageId:" + postPO.getPageId() + " result:" + result);
        }


    }
}
