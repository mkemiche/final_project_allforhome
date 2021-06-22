package io.allforhome.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mkemiche
 * @created 21/06/2021
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(FileStorageException.class)
    public String handleException(FileStorageException exception){
        return exception.getMsg();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(UserNotFoundException exception){
        return exception.getMsg();
    }

    @ResponseBody
    @ExceptionHandler(PropertyNotFoundException.class)
    public String handleException(PropertyNotFoundException exception){
        return exception.getMsg();
    }

    @ResponseBody
    @ExceptionHandler(CompanyNotFoundException.class)
    public String handleException(CompanyNotFoundException exception){
        return exception.getMsg();
    }
}
