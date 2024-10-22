package com.highway.tunnelMonitoring.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.highway.tunnelMonitoring.config.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Component
/**
 * 사용자의 인증이 안될때 처리방법(401)
 */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        ErrorResponse errorResponse = new ErrorResponse("FORBIDDEN", "잘못된 접근입니다.");

        // 응답 설정
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 상태 코드 설정
        response.setContentType("application/json"); // JSON 형식으로 응답 설정
        response.setCharacterEncoding("UTF-8"); // 인코딩 설정

        // ErrorResponse 객체를 JSON으로 변환하여 응답 본문에 작성
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), errorResponse);
    }

}
