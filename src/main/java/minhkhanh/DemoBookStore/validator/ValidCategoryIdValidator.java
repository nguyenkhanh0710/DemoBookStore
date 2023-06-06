package minhkhanh.DemoBookStore.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import minhkhanh.DemoBookStore.enitity.Category;
import minhkhanh.DemoBookStore.validator.annotation1.ValidCategoryId;


public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    public boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != null;
    }
}
