package gov.smartagro.api.payload;

import lombok.Data;

@Data
public class PasswordResetDto {

    private String password;
    private String confirmPassword;
    private String token;

}