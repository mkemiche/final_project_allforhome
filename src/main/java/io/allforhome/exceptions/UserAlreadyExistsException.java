package io.allforhome.exceptions;

/**
 * @author mkemiche
 * @created 21/06/2021
 */
public class UserAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;
    public UserAlreadyExistsException(String msg) {
        this.msg=msg;
    }

    public String getMsg(){
        return msg;
    }

}
