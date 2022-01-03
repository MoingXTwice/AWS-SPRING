package com.aws.webservice.web.dto;

import com.aws.webservice.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserListResponseDto {

    private String name;
    private String email;
    private String role;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public UserListResponseDto(User entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.role = entity.getRole().getKey();
        this.createDate = entity.getCreateDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
