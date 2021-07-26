# 项目简介
《Spring实战-第四版》的书，书中spitter项目的实现。与原书不同的地方是，本项目的领域类做了调整：    
1) spittr-> hottr  
2) spitter -> hotter  
3) spittle -> hottle  

# 项目环境的配置
## 0, 配置Java
省略

## 1, 配置maven
省略

## 2, 配置Tomcat8
### step1, download tomcat8.5.69
 wget https://mirror-hk.koddos.net/apache/tomcat/tomcat-8/v8.5.69/bin/apache-tomcat-8.5.69.tar.gz \
 && mv apache-tomcat-8.5.69.tar.gz ~/soft \
 && cd ~/soft \
 && tar -zxvf apache-tomcat-8.5.69.tar.gz \
 && ln -s apache-tomcat-8.5.69 tomcat8

### step2, intellij idea 配置tomcat  
 右上角 Edit Configurations | 弹出窗口, 左上角"+" | Tomcat Server - Local |   
 a) Server选项, 按照step1中的tomcat路径进行配置  
 b) Deployment选项, 选择"+" | artifact | 选择 ××.war_exploded , 注意修改下方的Application Context为"/"  
 c) 点击确定, 配置完成.  

### step3, run起来 当前项目spring-hammer  
 1) idea界面, 右上角 "绿色三角", 会自动弹出浏览器.   
 2) 在浏览器输入 http://localhost:8080/homepage, 可以看到效果了.  

