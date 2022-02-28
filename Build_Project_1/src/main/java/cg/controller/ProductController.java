package cg.controller;

import cg.model.Classes;
import cg.model.Student;
import cg.service.IClassService;
import cg.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(value ="/student")
public class ProductController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassService iCategoryService;

    @ModelAttribute(name = "classes")
    private Iterable<Classes> classes(){
        return iCategoryService.findAll();
    }

    @GetMapping
    public ModelAndView showStudent(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Student> students = iStudentService.findAll();
        modelAndView.addObject("students",students);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showDetailStudent(@PathVariable("id")Long id) {
        ModelAndView modelAndView = new ModelAndView("index");
        Optional<Student> student = iStudentService.findStudentById(id);
        modelAndView.addObject("student",student);
        return modelAndView;
    }
}
