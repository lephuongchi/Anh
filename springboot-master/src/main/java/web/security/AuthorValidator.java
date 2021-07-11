package web.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class AuthorValidator implements ConstraintValidator<Author, String> {

    List<String> authors = Arrays.asList("Santideva", "Marie Kondo", "Martin Fowler", "mkyong");
    Predicate <String> userNameCondition = s -> s.startsWith("Chi") || s.contains("a");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Collections.sort(authors, Comparator.comparingInt(String::length));
        return value.startsWith("Chi") || value.contains("a");

    }
}