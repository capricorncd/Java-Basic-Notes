package com.test.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMVCController {

  @RequestMapping("/mvc")
  // �÷�������Ӧ����host:8080/hello/mvc
  // ���ص�home.jsp
  public String helloMVC() {
    // ���ص�home.jsp
    return "home";
  }
  
}
