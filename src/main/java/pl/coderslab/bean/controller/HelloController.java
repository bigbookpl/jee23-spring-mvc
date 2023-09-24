package pl.coderslab.bean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping("/hello")
  @ResponseBody
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/jajko")
  @ResponseBody
  public String marchew() {
    return "Marchewka";
  }
}
