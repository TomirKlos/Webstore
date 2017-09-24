package com.klaster.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Created by MSI DRAGON on 2017-09-24.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Brak produktów we wskazanej kategorii")
        public class NoProductsFoundUnderCategoryException extends RuntimeException implements Serializable{
        private static final long serialVersionUID = 4895240733962369447L;
}
