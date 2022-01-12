package com.arrayProducts.arrayProductos.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MessageErrorHandle {
    @ResponseBody
    @ExceptionHandler(ProductError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage messageErrorHanlde(ProductError ex){
        return new ErrorMessage(ex.getMessage());
    }

}
