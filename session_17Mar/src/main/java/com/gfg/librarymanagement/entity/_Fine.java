package com.gfg.librarymanagement.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Builder
@Data
public class _Fine {
    @Id
    private String email;
    private Double fine;
}
