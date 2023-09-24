package pl.coderslab.bean.controller;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String helloView(Model model){

    Clock fixed = Clock.fixed(
        Instant.parse("2018-08-22T00:00:00Z"),
        ZoneOffset.UTC);

    if (LocalTime.now(fixed).getHour() >= 8 && LocalTime.now(fixed).getHour() < 20){
      model.addAttribute("fontColor","black");
      model.addAttribute("backgroundColor","white");
    }else {
      model.addAttribute("fontColor","white");
      model.addAttribute("backgroundColor","black");
    }

    return "home";
  }

}
