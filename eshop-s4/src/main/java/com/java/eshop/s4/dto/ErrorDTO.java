package com.java.eshop.s4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class ErrorDTO {

    private String code;
    private String message;
    private String details;

}
