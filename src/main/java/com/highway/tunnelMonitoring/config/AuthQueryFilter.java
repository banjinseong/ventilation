package com.highway.tunnelMonitoring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthQueryFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authParam = request.getParameter("auth");
        System.out.println(authParam);
        if (authParam != null) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();

            // auth 값에 따라 하나의 권한만 설정
            switch (authParam) {
                case "SYS":
                    authorities = List.of(new SimpleGrantedAuthority("ROLE_SYS"));
                    break;
                case "FAC":
                    authorities = List.of(new SimpleGrantedAuthority("ROLE_FAC"));
                    break;
                case "TRF":
                    authorities = List.of(new SimpleGrantedAuthority("ROLE_TRF"));
                    break;
                default:
                    ErrorResponse errorResponse = new ErrorResponse("UNAUTHORIZED", "접근 권한이 없습니다.");
                    sendJsonErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, errorResponse);
                    return;
            }
            System.out.println(authorities);
            // 인증 정보를 SecurityContext에 저장
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(authParam, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } else {
            ErrorResponse errorResponse = new ErrorResponse("BAD_REQUEST", "잘못된 접근입니다.");
            sendJsonErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, errorResponse);
            return;// 필터 체인 중단
        }

        // 필터 체인 계속 진행
        filterChain.doFilter(request, response);
    }


    private void sendJsonErrorResponse(HttpServletResponse response, int status, ErrorResponse errorResponse) throws IOException {
        response.setStatus(status); // HTTP 상태 코드 설정
        response.setContentType("application/json"); // JSON 형식으로 응답 설정
        response.setCharacterEncoding("UTF-8"); // 인코딩 설정

        // ErrorResponse 객체를 JSON으로 변환하여 응답 본문에 작성
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), errorResponse);
    }


}
