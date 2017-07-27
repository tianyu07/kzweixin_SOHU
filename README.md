# 快站微信公众号后端文档

## 接口文档
* [公众号接口约定](doc/api/common-rule.md)
* [通用接口](doc/api/common-api.md)
* [账号模块](doc/api/account-api.md)
* [粉丝模块](doc/api/fan-api.md)
* [消息模块](doc/api/msg-api.md)
* [模板消息模块](doc/api/tpl-msg-api.md)
* [图文模块](doc/api/post-api.md)
* [微信Action](doc/api/action-api.md)
* [授权登录](doc/api/authlogin-api.md)
* [微信回调](weixin/wx-push-api.md)

## 数据库文档
* [数据库文档](doc/mysql)

## 部署

部署web端，以开发环境为例：
*  `sh deploy/web/build.sh dev`
* 使用DomeOS重启服务   
    
部署消息队列，以开发环境为例：
*  `sh deploy/worker/build.sh dev`
* 使用DomeOS重启消息队列
