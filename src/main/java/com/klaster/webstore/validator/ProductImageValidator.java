package com.klaster.webstore.validator;

import com.klaster.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by MSI DRAGON on 2017-09-27.
 */
@Component
public class ProductImageValidator implements Validator {
    private long allowedSize=1500;
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;


        if(product.getProductImage()!= null && (product.getProductImage().getSize()/1024)>=allowedSize) {
            errors.rejectValue("productImage","com.klaster.webstore.validator.ProductImageValidator.message");
        }
    }
}
