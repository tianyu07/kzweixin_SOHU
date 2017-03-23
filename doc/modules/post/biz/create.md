# 新建微信图文业务流程

## 流程图


## 流程说明

1. 生成 `weixin_post` 表中ID，将基础数据存到 `weixin_post`
2. 使用正则 匹配内容中的图片链接
3. 调用微信资源上传接口 所有图片上传至微信服务器
4. 替换图文内容中图片的链接
5. 将微信图文内容存到 MongoDB的 `page_json` 集合
...

## 外部接口
1. 微信图片资源上传接口