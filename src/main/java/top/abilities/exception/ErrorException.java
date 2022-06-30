package top.abilities.exception;


import top.abilities.enuma.ErrorEnum;

/**
 * Author: zhaohaoxin
 * Date: 2022-06-28-15:45
 */
public class ErrorException extends Exception{
    private ErrorEnum errorEnum;
    public ErrorException(ErrorEnum errorEnum){
        this.errorEnum = errorEnum;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}
