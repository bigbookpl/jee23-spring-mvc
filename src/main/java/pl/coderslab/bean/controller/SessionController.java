package pl.coderslab.bean.controller;

import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loginStart")
public class SessionController {

  @GetMapping("/session/loginStart")
  @ResponseBody
  String loginStartView(HttpSession httpSession, Model model){
    LocalDateTime loginStart = (LocalDateTime) httpSession.getAttribute("loginStart"); //pobieram z sesji loginStart
    if (loginStart == null){ //jeśli nie ma loginStart w sesji
      loginStart = LocalDateTime.now(); //ustawiam loginStart na teraz
      model.addAttribute("loginStart", loginStart); //dodaję loginStart do modelu
    }
    return loginStart.toString(); //zwracam loginStart jako string
  }

}
