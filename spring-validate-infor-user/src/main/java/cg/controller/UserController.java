package cg.controller;

import cg.model.user;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping
    public ModelAndView showFotm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user",new user());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView checkFotm(@Validated @ModelAttribute("user") user user, BindingResult result){
        if(result.hasFieldErrors()){
            return  new ModelAndView("index");
        }
        return  new ModelAndView("result");
    }
}
