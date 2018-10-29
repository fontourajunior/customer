package br.com.una.customer.customer.config;

import br.com.una.customer.customer.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.status;


@ControllerAdvice
class ExceptionHandlers {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorInfo> handlerBusinessException(HttpServletRequest req, Throwable ex) {
        ErrorInfo error = new ErrorInfo();
        error.setMessage(ex.getMessage());
        return status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfo> handlerNotFoundException(HttpServletRequest req, Throwable ex) {
        ErrorInfo error = new ErrorInfo();
        error.setMessage(ex.getMessage());
        return status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerBusinessException(MethodArgumentNotValidException error) {
        return status(HttpStatus.BAD_REQUEST).body(error.getBindingResult());
    }

}