package com.litongjava.spring.boot.ueditor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.ueditor.ActionEnter;

import lombok.extern.slf4j.Slf4j;

//使用注解测试无效
//@WebServlet(name = "UEditorServlet", urlPatterns = "/UEditor")
@SuppressWarnings("serial")
@Slf4j
public class UEditorServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setHeader("Content-Type", "text/html");
    PrintWriter out = response.getWriter();
    URL systemResource = ClassLoader.getSystemResource("");
    String rootPath = systemResource.getFile();
    log.info("rootPath:{}", rootPath);
    // String rootPath = application.getRealPath("/");

    String action = request.getParameter("action");
    String result = new ActionEnter(request, rootPath).exec();
    if (action != null && (action.equals("listfile") || action.equals("listimage"))) {
      rootPath = rootPath.replace("\\", "/");
      result = result.replaceAll(rootPath, "/");
    }
    out.write(result);
  }
}