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
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Component
/**
 * 인증은 되었지만 접근 권한이 없을때(403)
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {

        ErrorResponse errorResponse = new ErrorResponse("FORBIDDEN", accessDeniedException.getMessage());

        // 응답 설정
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // 403 상태 코드 설정
        response.setContentType("application/json"); // JSON 형식으로 응답 설정
        response.setCharacterEncoding("UTF-8"); // 인코딩 설정

        // ErrorResponse 객체를 JSON으로 변환하여 응답 본문에 작성
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), errorResponse);
    }

}