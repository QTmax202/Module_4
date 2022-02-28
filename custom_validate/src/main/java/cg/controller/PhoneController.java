package cg.controller;

import cg.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/phone")
public class PhoneController {
    @GetMapping
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phoneNumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView checkForm(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        new PhoneNumber().validate(phoneNumber, result);
        if (result.hasFieldErrors()) {
            return new ModelAndView("index");
        }
        modelAndView.addObject("phoneNumber", phoneNumber);
        return new ModelAndView("result");
    }
}
