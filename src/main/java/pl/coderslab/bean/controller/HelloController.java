package pl.coderslab.bean.controller;

import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    return "Marchewka 2";
  }

  @GetMapping(path = "/random/{min}/{max}", produces = "text/html; charset=UTF-8")
  @ResponseBody
  public String getMaxRandomNumber(@PathVariable int min, @PathVariable int max) {
    Random random = new Random();
    int i = random.nextInt((max - min) + 1) + min;

    return " Użytkownik podał wartości " + min + " "+max+". Wylosowano liczbę: " + i + ".";
  }

  @RequestMapping("/hello/{firstName}/{lastName}")
  @ResponseBody
  public String hello(@PathVariable String firstName, @PathVariable String lastName) {
    return "Witaj " + firstName + " " + lastName;
  }

  @RequestMapping("/helloView")
  public String helloView(){
    return "home";
  }

}
