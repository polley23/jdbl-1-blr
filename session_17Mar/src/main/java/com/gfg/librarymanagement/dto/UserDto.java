package com.gfg.librarymanagement.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String role;
}
