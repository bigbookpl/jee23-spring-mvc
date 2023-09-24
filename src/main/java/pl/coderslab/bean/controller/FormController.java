package pl.coderslab.bean.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/first")
public class FormController {

  @GetMapping("/form")
  public String showForm() {
    return "/form.jsp";
  }

  @PostMapping("/form")
  @ResponseBody
  public String getForm(@RequestParam String paramName, @RequestParam String paramDate) {

    try {
      LocalDate date = LocalDate.parse(paramDate, java.time.format.DateTimeFormatter.ISO_DATE);
      return "ParamName - " + paramName + " ParamDate - " + date;

    } catch (DateTimeParseException e) {
      return "Wrong date format";
    }

  }


}
