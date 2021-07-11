package web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import web.model.Customer;
import web.repository.CustomerRepository;

@Component
public class UserValidator implements Validator {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ApplicationContext context;

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmptyyy");
        if (customer.getUserName().length() < 6 || customer.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.userName");
        }
        if (customerRepository.findByUserName(customer.getUserName()).size() > 0) {
            errors.rejectValue("userName", "Duplicate.customer.userName");
        }
    }

    public String getMessageSource(ObjectError objectError) {
        try {
            return context.getBean(MessageSource.class).getMessage(objectError.getCode(), new Object[]{}, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            return objectError.getDefaultMessage();
        }
    }
}
