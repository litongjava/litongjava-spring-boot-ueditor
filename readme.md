### 简介
spring-boot整合ueditor,包含了文章管理和用户协议管理

http://127.0.0.1/litongjava-spring-boot-ueditor/html/articelList.html  
http://127.0.0.1/litongjava-spring-boot-ueditor/html/userAgreementlList.html

### 演示视频
https://www.bilibili.com/video/bv1EA41177hw

### 数据库文件
src/main/resources/doc 下面

### 导入eclisp
下面代码导入eclipse即可  
配置nginx代理 方便开发静态文件
```
  location /litongjava-spring-boot-ueditor {
    proxy_pass http://127.0.0.1:11025;
    proxy_pass_header Set-Cookie;
    proxy_set_header Host $http_host;
    proxy_set_header X-Real-IP $remote_addr;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    proxy_set_header X-Forwarded-Proto $scheme;
  }

  location ^~ /litongjava-spring-boot-ueditor/druid {
    proxy_pass http://127.0.0.1:11025;
  }
  
  location  ~ ^/litongjava-spring-boot-ueditor.*\.(html|css|js|jpg|jpeg|gif|png|ico|pdf|txt)$ {
    root D:\dev_workspace\java\litong-project\litongjava-spring-boot-ueditor\src\main\\resources;
  }
```
