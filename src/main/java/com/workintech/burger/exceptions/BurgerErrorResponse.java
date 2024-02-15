package com.workintech.burger.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class BurgerErrorResponse {
    private int status;
    private String message;
    private LocalDateTime createdAt;
}
