package com.kuaizhan.kzweixin.constant;

/**
 * MQ的相关常量
 * 定义发送到MQ的routing key常量，这个值也和queue name一致
 * Created by zixiong on 2017/3/23.
 */
public class MqConstant {
    //从快站文章导入
    public static final String IMPORT_KUAIZHAN_POST = "sys-kzweixin-import-kuaizhan-post";
    //从微信文章导入列表
    public static final String IMPORT_WEIXIN_POST_LIST = "sys-kzweixin-import-weixin-post-list";
    //从微信文章导入
    public static final String IMPORT_WEIXIN_POST = "sys-kzweixin-import-weixin-post";
    // 发送模板消息
    public static final String SEND_SYS_TPL_MSG = "sys-kzweixin-send-sys-tpl-msg";
}