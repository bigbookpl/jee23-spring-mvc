package pl.coderslab.bean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    @RequestMapping(path = "/show-random", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String randomMax100() {
        Random random = new Random();
        return "Wylosowano liczbę: " + random.nextInt(100);
    }
}
