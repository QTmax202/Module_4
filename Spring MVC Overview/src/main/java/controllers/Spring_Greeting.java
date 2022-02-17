package controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.time.LocalDateTime;

public class Spring_Greeting implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("name", LocalDateTime.now());
        return modelAndView;
    }
}
