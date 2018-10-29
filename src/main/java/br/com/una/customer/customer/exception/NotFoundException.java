package br.com.una.customer.customer.exception;

public class NotFoundException extends javassist.NotFoundException {

    public NotFoundException() {
        super(null);
    }

    public NotFoundException(String msg, Exception e) {
        super(msg, e);
    }



}
