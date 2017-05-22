package com.kuaizhan.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuaizhan.constant.ErrorCode;
import com.kuaizhan.dao.mapper.TplDao;
import com.kuaizhan.exception.BusinessException;
import com.kuaizhan.exception.weixin.WxInvalidTemplateException;
import com.kuaizhan.exception.weixin.WxTemplateIndustryConflictException;
import com.kuaizhan.exception.weixin.WxTemplateNumExceedException;
import com.kuaizhan.manager.WxTplManager;
import com.kuaizhan.pojo.po.AccountPO;
import com.kuaizhan.service.AccountService;
import com.kuaizhan.service.TplService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by zixiong on 2017/5/13.
 */
@Service("tplService")
public class TplServiceImpl implements TplService {
    @Resource
    private TplDao tplDao;
    @Resource
    private AccountService accountService;

    private Map<String, Object> sysTplMap;

    private static final Logger logger = Logger.getLogger(TplServiceImpl.class);

    /**
     * 初始化系统模板templates
     */
    @PostConstruct
    public void init() {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = TplServiceImpl.class.getResourceAsStream("/json/wx-sys-templates.json");
        try {
            sysTplMap = objectMapper.readValue(is, Map.class);
        } catch (IOException e) {
            logger.error("[TplServiceImpl:init] init sysTplMap failed, inputStream:" + is, e);
        }
    }

    @Override
    public void addTpl(long weixinAppid, String tplIdShort) {
        // 检查模板id是否合法
        if (!sysTplMap.containsKey(tplIdShort)) {
            throw new BusinessException(ErrorCode.INVALID_SYS_TEMPLATE_ID_ERROR);
        }
        // 检查公众号是否是认证服务号
        AccountPO accountPO = accountService.getAccountByWeixinAppId(weixinAppid);
        if (accountPO.getServiceType() != 2 || accountPO.getVerifyType() == -1) {
            throw new BusinessException(ErrorCode.ACCOUNT_NOT_VERIFIED_SERVICE_TYPE);
        }

        // 数据库配置中已经添加
        String tplId = tplDao.getTplId(weixinAppid, tplIdShort);
        if (tplId != null && !"".equals(tplId.trim())) {
            return;
        }
        // TODO: 从用户已有的模板中寻找此模板
        String accessToken = accountService.getAccessToken(weixinAppid);
        try {
            tplId = WxTplManager.addTplId(accessToken, tplIdShort);
        } catch (WxTemplateNumExceedException e) {
            throw new BusinessException(ErrorCode.TEMPLATE_NUM_EXCEED_ERROR);
        } catch (WxTemplateIndustryConflictException e) {
            throw new BusinessException(ErrorCode.TEMPLATE_INDUSTRY_CONFLICT_ERROR);
        }
        tplDao.addTplId(weixinAppid, tplIdShort, tplId);
    }

    @Override
    public void sendSysTplMsg(long weixinAppid, String tplIdShort, String openId, String url, Map dataMap) {
        // 数据校验
        isTplDataValid(tplIdShort, dataMap);

        String tplId = tplDao.getTplId(weixinAppid, tplIdShort);
        if (tplId == null || "".equals(tplId.trim())) {
            // 抛异常
            throw new BusinessException(ErrorCode.HAS_NOT_ADD_TEMPLATE_ERROR);
        }

        try {
            sendTplMsg(weixinAppid, tplId, openId, url, dataMap);
        } catch (WxInvalidTemplateException e) {
            // 模板id已经不可用，删除之
            boolean deleted = tplDao.deleteTpl(weixinAppid, tplIdShort);
            if (deleted) {
                logger.info("[deleteTpl] weixinAppid:" + weixinAppid + " tplIdShort:" + tplIdShort);
            }
            throw new BusinessException(ErrorCode.HAS_NOT_ADD_TEMPLATE_ERROR);
        }
    }

    @Override
    public void sendTplMsg(long weixinAppid, String tplId, String openId, String url, Map dataMap) {
        String accessToken = accountService.getAccessToken(weixinAppid);
        WxTplManager.sendTplMsg(accessToken, tplId, openId, url, dataMap);
    }

    @Override
    public boolean isTplAdded(long weixinAppid, String tplIdShort) {
        String tplId = tplDao.getTplId(weixinAppid, tplIdShort);
        return tplId != null && "".equals(tplId.trim());
    }

    /**
     * 发送系统模板消息需要先检查参数格式
     */
    private void isTplDataValid(String tplIdShort, Map dataMap) {
        if (!sysTplMap.containsKey(tplIdShort)) {
            throw new BusinessException(ErrorCode.INVALID_SYS_TEMPLATE_ID_ERROR);
        }
        Map tplMap = (Map) sysTplMap.get(tplIdShort);
        List<String> keywords = (List) tplMap.get("keywords");
        for(String keyword: keywords) {
            if (!dataMap.containsKey(keyword)){
                throw new BusinessException(ErrorCode.TPL_DATA_FORMAT_ERROR);
            }
        }
    }
}
