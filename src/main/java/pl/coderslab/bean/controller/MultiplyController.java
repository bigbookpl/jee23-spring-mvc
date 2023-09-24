package pl.coderslab.bean.controller;

import javax.servlet.http.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {

  @GetMapping("/multiply")
  String multiply(Model model, @RequestParam(defaultValue = "10") int size) {
    model.addAttribute("size", size);
    return "multiply";
  }

  @GetMapping("/paramMultiply/{rows}/{cols}")
  String paramMultiply(Model model, @PathVariable int rows, @PathVariable int cols, @CookieValue Cookie cookie) {
    model.addAttribute("rows", rows);
    model.addAttribute("cols", cols);
    return "paramMultiply";
  }

}