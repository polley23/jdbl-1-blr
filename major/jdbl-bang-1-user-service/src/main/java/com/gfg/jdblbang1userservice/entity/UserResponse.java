package com.gfg.jdblbang1userservice.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private String email;
    private String username;
}
