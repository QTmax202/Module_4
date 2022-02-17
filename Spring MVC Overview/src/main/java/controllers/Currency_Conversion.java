package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/currency")
public class Currency_Conversion {

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @PostMapping("/conversion")
    public ModelAndView getCurrency_Conversion(@RequestParam("exchange_rate") int exchange_rate, @RequestParam("usd") double usd){
        ModelAndView modelAndView = new ModelAndView("index");
        int result = (int) (exchange_rate * usd);
        modelAndView.addObject("vnd", result);
        return modelAndView;
    }
}
