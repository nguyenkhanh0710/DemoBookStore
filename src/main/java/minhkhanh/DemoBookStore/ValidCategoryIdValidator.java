package minhkhanh.DemoBookStore;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import minhkhanh.DemoBookStore.enitity.Category;
import minhkhanh.DemoBookStore.validator.annotation.ValidCategoryId;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {

    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext ) {
        return category !=null && category.getId() !=null;
    }
}
