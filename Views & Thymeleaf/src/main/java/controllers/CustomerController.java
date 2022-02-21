package controllers;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CustomerService;
import service.ICustomerService;
import java.util.List;

//@Controller
//@RequestMapping("/customer")
//public class CustomerController {
//    @Autowired
//    private ICustomerService customerService;
//
//    @GetMapping
//    public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        List<Customer> customerList = customerService.findAll();
//        modelAndView.addObject("customers",customerList);
//        return modelAndView;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView create() {
//        ModelAndView modelAndView = new ModelAndView("create");
//        Customer customer = new Customer();
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/save")
//    public ModelAndView save(@ModelAttribute Customer customer) {
//        ModelAndView modelAndView = new ModelAndView("list");
//        List<Customer> customerList = customerService.findAll();
//        boolean check = false;
//        Customer cus = customerService.save(customer);
//        for (int i = 0; i < customerList.size(); i++) {
//            if (customerList.get(i).getId() == customer.getId()) {
//                customerService.update(i, customer);
//                check = true;
//            }
//        }
//        if (!check) {
//            customer.setId((int) (Math.random() * 10000));
//            customerService.save(customer);
//        }
//        modelAndView.addObject("customers",customerList);
//        return modelAndView;
//    }
//
//    @GetMapping("/{id}/view")
//    public ModelAndView view(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("view");
//        Customer customer = customerService.findById(id);
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @GetMapping("/{id}/delete")
//    public ModelAndView delete(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("delete");
//        Customer customer = customerService.findById(id);
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/delete")
//    public String delete(Customer customer, RedirectAttributes redirect) {
//        customerService.remove(customer.getId());
//        redirect.addFlashAttribute("success", "Removed customer successfully!");
//        return "redirect:/customer";
//    }
//
//    @GetMapping("/{id}/edit")
//    public ModelAndView editProduct(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("edit");
//        Customer customer = customerService.findById(id);
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/update")
//    public String update(Customer customer) {
//        customerService.update(customer.getId(), customer);
//        return "redirect:/customer";
//    }
//}

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
