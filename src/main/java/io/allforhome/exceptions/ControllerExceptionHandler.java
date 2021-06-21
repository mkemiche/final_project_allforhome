package io.allforhome.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mkemiche
 * @created 21/06/2021
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(FileStorageException.class)
    public ModelAndView handleException(FileStorageException exception, RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMsg());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ModelAndView handleException(UserNotFoundException exception, RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMsg());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    public ModelAndView handleException(PropertyNotFoundException exception, RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMsg());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ModelAndView handleException(CompanyNotFoundException exception, RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMsg());
        mav.setViewName("error");
        return mav;
    }
}
