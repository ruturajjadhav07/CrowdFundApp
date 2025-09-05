package com.crowdfunding.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileRequest {

    @NotBlank(message = "username cannot be empty")
    private String username;
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Enter a valid email")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
