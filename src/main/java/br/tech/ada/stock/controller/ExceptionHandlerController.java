package br.tech.ada.stock.controller;

import br.tech.ada.stock.exception.StockNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = StockNotFoundException.class)
    public ResponseEntity<?> handleStockNotFoundException(){
        return ResponseEntity.notFound().build();
    }
}
