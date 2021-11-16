package com.example.javainterview.validators;

import com.example.javainterview.model.WordRequest;
import lombok.extern.log4j.Log4j2;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target( { METHOD, FIELD, PARAMETER, TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidWordRequest.WordRequestValidator.class)
public @interface ValidWordRequest {
    String message() default "Invalid word request";

    @Log4j2
    class WordRequestValidator implements ConstraintValidator<ValidWordRequest, WordRequest> {

        @Override
        public boolean isValid(WordRequest wordRequest, ConstraintValidatorContext constraintValidatorContext) {
            return wordRequest != null && !wordRequest.getWord().isEmpty();
        }
    }
}