package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import web.model.Customer;
import web.security.UserValidator;
import web.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CustomerRegistry {
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/registry")
    public String registry(@Valid Customer customer, BindingResult bindingResult, HttpServletRequest request) {
        request.getSession().isNew();
        request.getSession().getId();
        userValidator.validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registryCustomer";
        }
        customerService.saveCustomer(customer);
        return "lol";
    }

    @PostMapping(value = "/registryBody")
    @ResponseBody
    public ResponseEntity<Object> registryBody(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        userValidator.validate(customer, bindingResult);
        if (!bindingResult.getAllErrors().isEmpty()) {
            //Get all errors
            List<String> errors = bindingResult.getAllErrors().stream().map(x -> userValidator.getMessageSource(x)).collect(Collectors.toList());
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", new Date());
            body.put("status", HttpStatus.BAD_REQUEST);
            body.put("errors", errors);
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
