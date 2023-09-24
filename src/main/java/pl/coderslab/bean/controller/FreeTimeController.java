package pl.coderslab.bean.controller;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeTimeController {

  @RequestMapping("/freetime")
  @ResponseBody
  public String freeTime() {

   // LocalDateTime now = LocalDateTime.now(Clock.fixed(Instant.parse("2023-03-29T05:15:30.00Z"), Clock.systemDefaultZone().getZone()));
    LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone().getZone());
    if (now.getDayOfWeek().equals(DayOfWeek.SATURDAY) || now.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
      return "Wolne";
    }

    if (now.getHour() >= 9 && now.getHour() < 17){
      return "Pracuje, nie dzwoń.";
    }else {
      return "Po pracy";
    }
  }

}
