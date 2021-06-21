package io.allforhome.exceptions;

/**
 * @author mkemiche
 * @created 05/06/2021
 */
public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String msg;
    public UserNotFoundException(String msg) {
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }
}
