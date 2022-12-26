package com.saleem.demo.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus httpStatus;
    private String Message;
}
