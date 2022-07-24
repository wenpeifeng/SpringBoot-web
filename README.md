# SpringBoot-web
SpringBoot-web整合Thymeleaf搭建的简易员工管理demo
 ■ 附带说明文档：https://mp.weixin.qq.com/mp/homepage?__biz=Mzg2NTAzMTExNg==&hid=1&sn=3247dca1433a891523d9e4176c90c499
 ■ 前端涉及到的样式和页面组件：Boostrap，Layui，semantic-ui，x-admin（后台模板）
 ■ SpringBoot相关导入的starter库：https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/#using-boot-starter


★ 404页面配置：
   当访问一个不存在的url时，一般会做统一的404配置页面处理，springboot在这方面已经很完善了，不需要我们配置过多的东西
   只需要在templates文件夹下，定义一个名叫“error”文件夹，存放错误码的html，如：404.html、500.html
 ——假设正确的url是：http://localhost:8080/wpf/dashboard.do，我们在url后面随意打几个字符，使其是错误的url：http://localhost:8080/wpf/dashboard.do4444555
   此时会自动跳转到我们配置好的404.html页面

★ 注销登录：
   将session置为失效即可：session.invalidate();
