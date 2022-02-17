package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/new")
public class Home_Controller {

    @GetMapping("/greeting")
    public ModelAndView getView(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/view")
    public String getName (@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }
}
