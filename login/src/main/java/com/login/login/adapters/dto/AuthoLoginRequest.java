package com.login.login.adapters.dto;

import jakarta.validation.constraints.NotBlank;


public record AuthoLoginRequest (@NotBlank String username,
        @NotBlank String password){
    
}
