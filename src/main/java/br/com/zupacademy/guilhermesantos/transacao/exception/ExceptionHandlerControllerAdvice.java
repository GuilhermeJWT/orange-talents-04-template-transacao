package br.com.zupacademy.guilhermesantos.transacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(GenerationExceptionClass.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestApiErrorsException tratamentoException(GenerationExceptionClass generationExceptionClass){
        String msgErro = generationExceptionClass.getLocalizedMessage();

        return new RestApiErrorsException(msgErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestApiErrorsException exibeErrosParaCliente(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> errors = methodArgumentNotValidException.getBindingResult().getAllErrors().stream()
                .map(erro -> erro.getDefaultMessage()).collect(Collectors.toList());

        return new RestApiErrorsException(errors);

    }



}
