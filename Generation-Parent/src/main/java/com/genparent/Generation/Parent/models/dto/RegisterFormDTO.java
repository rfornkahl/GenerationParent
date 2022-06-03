package com.genparent.Generation.Parent.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {

    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 35, message = "Invalid username. Must be between 2 and 35 characters.")
    private String firstname;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 35, message = "Invalid username. Must be between 2 and 35 characters.")
    private String lastname;



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}
