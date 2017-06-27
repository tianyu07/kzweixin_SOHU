package com.kuaizhan.kzweixin.service;

import com.kuaizhan.kzweixin.dao.po.auto.ActionPO;

/**
 * Created by zixiong on 2017/6/26.
 */
public interface ActionService {
    /**
     * 新增Action
     */
    int addAction(long weixinAppid, ActionPO action, Object responseObj);

    /**
     * 修改Action
     * @param action action对象
     */
    void updateAction(long weixinAppid, ActionPO action, Object responseObj);
}