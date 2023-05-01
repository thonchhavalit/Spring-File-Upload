package com.istad.istadresfulapi.model.request;



import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
    @NotBlank(message = "username can't auto fill !!")
    private String username;
    private String name;
    private String address;
    @NotBlank(message = "gender can't auto fill !")
    private String gender;
}
