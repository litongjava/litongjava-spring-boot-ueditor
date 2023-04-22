package com.litongjava.spring.boot.ueditor;

import com.litongjava.utils.ip.IpUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import com.litongjava.spring.boot.ueditor.servlet.UEditorServlet;

@SpringBootApplication
@MapperScan("com.litongjava.spring.boot.ueditor.dao")
public class Application {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    SpringApplication app = new SpringApplication(Application.class);
    app.setBannerMode(Banner.Mode.OFF);
    ApplicationContext context = app.run(args);
    info(start, context);
  }

  private static void info(long start, ApplicationContext ctx) {
    // 获取tomcat server 属性
    TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) ctx
      .getBean("tomcatServletWebServerFactory");
    int port = tomcatServletWebServerFactory.getPort();
    String contextPath = tomcatServletWebServerFactory.getContextPath();
    Environment environment = ctx.getBean(Environment.class);
    String projectName = environment.getProperty("spring.application.name");
    if (StringUtils.isEmpty(projectName))
      projectName = "file-server";
    IpUtils.getThisUrl(port, contextPath);
    long end = System.currentTimeMillis();
    // 输出地址和端口
    System.out.println(projectName + "完成启动共使用了:" + (end - start) + "ms");
  }

  @Bean
  public ServletRegistrationBean servletRegistrationBean() {
    return new ServletRegistrationBean(new UEditorServlet(), "/ueditor-1.4/UEditor");
  }
}