package com.project.insert.domain.user.presentation;

import com.project.insert.domain.user.service.UserLoginService;
import com.project.insert.domain.user.service.UserLogoutService;
import com.project.insert.global.jwt.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Validated
@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping
public class AuthController {
    private final UserLoginService userLoginService;
    private final UserLogoutService userLogoutService;

    @GetMapping("/signup/bsm")
    public TokenResponseDto userSignup(@RequestParam String code) throws IOException {
        return userLoginService.execute(code);
    }
}
