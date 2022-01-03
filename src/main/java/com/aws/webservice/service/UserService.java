package com.aws.webservice.service;

import com.aws.webservice.domain.user.UserRepository;
import com.aws.webservice.web.dto.UserListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserListResponseDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserListResponseDto::new)
                .collect(Collectors.toList());
    }

}
