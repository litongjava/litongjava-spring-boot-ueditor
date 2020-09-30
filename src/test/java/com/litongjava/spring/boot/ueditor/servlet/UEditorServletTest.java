package com.litongjava.spring.boot.ueditor.servlet;

import org.junit.Test;

import java.net.URL;

/**
 * Created by litongjava@qq.com on 2020/6/15 0015_下午 17:25
 */
public class UEditorServletTest {

  @Test
  public void getPath(){
    URL systemResource = ClassLoader.getSystemResource("");
    System.out.println(systemResource);
  }
}