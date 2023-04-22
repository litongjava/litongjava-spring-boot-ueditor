package com.litongjava.spring.boot.ueditor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.ActionEnter;
import com.litongjava.spring.boot.ueditor.service.ResourcesLocationComponent;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("ueditor-1.4")
@Slf4j
@PreAuthorize("isAuthenticated()")
public class UeditorController {
  @Autowired
  private ResourcesLocationComponent rlc;
  @RequestMapping("ueditor/controller")
  @ResponseBody
  public void getConfigInfo(HttpServletRequest request, HttpServletResponse response) {
    response.setContentType("application/json;charset=utf-8");
    List<String> locations = rlc.getLocations();
    log.info("locations {}",locations);
    String rootPath = locations.get(0);
    ActionEnter actionEnter = new ActionEnter(request, rootPath);
    try {
      String exec = actionEnter.exec();
      PrintWriter writer = response.getWriter();
      writer.write(exec);
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}