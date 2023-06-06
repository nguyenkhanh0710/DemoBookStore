package minhkhanh.DemoBookStore.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import minhkhanh.DemoBookStore.repository.IUserRepository;
import minhkhanh.DemoBookStore.validator.annotation1.ValidUserId;
import minhkhanh.DemoBookStore.validator.annotation1.ValidUsername;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
