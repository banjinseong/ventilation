package com.highway.tunnelMonitoring.config;

import com.highway.tunnelMonitoring.config.handler.CustomAccessDeniedHandler;
import com.highway.tunnelMonitoring.config.handler.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Collections;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    /**
     * 전체 메뉴 조회 접근 권한
     */
    private static final String[] AUTH_READ = {
            "ventilation/damper/config/list/**","ventilation/damper/monitor","ventilation/damper/runHistory",
            "ventilation/fire/monitor","ventilation/fire/alarmHistory","ventilation/fire/stat",
            "ventilation/cable/config/list/**","ventilation/cable/alarmHistory","ventilation/cable/runHistory","ventilation/cable/monitor",
            "ventilation/jetPan/config/list/**","ventilation/jetPan/monitor","ventilation/jetPan/runHistory","ventilation/jetPan/faultHistory","ventilation/jetPan/stat",
            "ventilation/pump/config/list/**","ventilation/pump/monitor","ventilation/pump/runHistory","ventilation/pump/faultHistory","ventilation/pump/stat",
            "ventilation/venAxFn/config/list/**","ventilation/venAxFn/monitor","ventilation/venAxFn/runHistory","ventilation/venAxFn/faultHistory","ventilation/venAxFn/stat",
            "ventilation/waterTank/config/list/**","ventilation/waterTank/monitor","ventilation/waterTank/alarmHistory",
            "power/eltgnr/config/list/**", "power/eltgnr/monitor","power/eltgnr/runHistory","power/eltgnr/alarmHistory",
            "power/entryEntrBar/config/list/**", "power/entryEntrBar/monitor","power/entryEntrBar/runHistory","power/entryEntrBar/faultHistory",
            "power/frplg/config/list/**", "power/frplg/monitor","power/frplg/alarmHistory",
            "power/lght/config/list/**", "power/lght/monitor",
            "power/rect/config/list/**", "power/rect/monitor","power/rect/alarmHistory","power/rect/stat",
            "power/swtbrd/config/list/**", "power/swtbrd/monitor","power/swtbrd/alarmHistory","power/swtbrd/runHistory","power/swtbrd/stat",
            "power/ups/config/list/**", "power/ups/monitor","power/ups/faultHistroy","power/ups/runHistory"

    };

    /**
     * 기초정보 등록 수정 접근 권한
     */
    private static final String[] AUTH_CREATE = {
            "ventilation/damper/config/create/**", "ventilation/damper/config/update/**",
            "ventilation/cable/config/create/**", "ventilation/cable/config/update/**",
            "ventilation/jetPan/config/create/**", "ventilation/jetPan/config/update/**",
            "ventilation/pump/config/create/**", "ventilation/pump/config/update/**",
            "ventilation/venAxFn/config/create/**", "ventilation/venAxFn/config/update/**",
            "ventilation/waterTank/config/create/**", "ventilation/waterTank/config/update/**",
            "power/eltgnr/config/create/**", "power/eltgnr/config/update/**",
            "power/entryEntrBar/config/create/**", "power/entryEntrBar/config/update/**",
            "power/frplg/config/create/**", "power/frplg/config/update/**",
            "power/lght/config/create/**", "power/lght/config/update/**",
            "power/rect/config/create/**", "power/rect/config/update/**",
            "power/swtbrd/config/create/**", "power/swtbrd/config/update/**",
            "power/ups/config/create/**", "power/ups/config/update/**"

    };

    /**
     * 기초정보 삭제 접근 권한
     */
    private static final String[] AUTH_DELETE = {
            "ventilation/damper/config/delete/**",
            "ventilation/cable/config/delete/**",
            "ventilation/jetPan/config/delete/**",
            "ventilation/pump/config/delete/**",
            "ventilation/venAxFn/config/delete/**",
            "ventilation/waterTank/config/delete/**",
            "power/eltgnr/config/delete/**",
            "power/entryEntrBar/config/delete/**",
            "power/frplg/config/delete/**",
            "power/lght/config/delete/**",
            "power/rect/config/delete/**",
            "power/swtbrd/config/delete/**",
            "power/ups/config/delete/**"
    };
    
    



    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        /**
         * 모든 접근 허용
         */
        CorsConfiguration configuration = new CorsConfiguration();

        // 모든 출처를 허용
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));

        // 모든 HTTP 메서드를 허용
        configuration.setAllowedMethods(Collections.singletonList("*"));

        // 모든 헤더를 허용
        configuration.setAllowedHeaders(Collections.singletonList("*"));

        // 인증 및 인가를 위한 credentials 를 TRUE로 설정 (필요한 경우)
        configuration.setAllowCredentials(true);

        // 모든 경로에 대해 설정 적용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;


        /**
         * 접근 관리.
         */
//        CorsConfiguration configuration = new CorsConfiguration();
//        //리소스를 허용할 URL 지정
//        ArrayList<String> allowedOriginPatterns = new ArrayList<>();
//        allowedOriginPatterns.add("http://localhost:3000");
//        allowedOriginPatterns.add("http://127.0.0.1:3000");
//        allowedOriginPatterns.add("http://localhost:5501");
//        allowedOriginPatterns.add("http://127.0.0.1:5501");
//        allowedOriginPatterns.add("http://localhost:5502");
//        allowedOriginPatterns.add("http://127.0.0.1:5502 ");
//        configuration.setAllowedOrigins(allowedOriginPatterns);
//
//        //허용하는 HTTP METHOD 지정
//        ArrayList<String> allowedHttpMethods = new ArrayList<>();
//        allowedHttpMethods.add("GET");
//        allowedHttpMethods.add("POST");
//        allowedHttpMethods.add("PUT");
//        allowedHttpMethods.add("DELETE");
//        configuration.setAllowedMethods(allowedHttpMethods);
//
//        configuration.setAllowedHeaders(Collections.singletonList("*"));
////        configuration.setAllowedHeaders(List.of(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE));
//
//        //인증, 인가를 위한 credentials 를 TRUE로 설정
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
    }

    /**
     * 권한(hasRole)을 사용할때는 자동으로 앞에 ROLE_를 붙여서 검사한다..
     */
    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception{

        //CSRF, CORS
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(cors -> cors.configurationSource(corsConfigurationSource())); // CORS 설정 추가

        //세션 관리 상태 없음으로 구성, Spring Security가 세션 생성 or 사용 X
        http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS));

        //FormLogin, BasicHttp 비활성화
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);


        // 권한 규칙 작성
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(AUTH_READ).hasAnyRole("SYS", "FAC", "TRF")
                        .requestMatchers(AUTH_CREATE).hasAnyRole("SYS", "FAC")
                        .requestMatchers(AUTH_DELETE).hasRole("SYS")
                        // 그 외의 요청은 인증된 사용자만 접근 가능
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new AuthQueryFilter(),  SecurityContextPersistenceFilter.class)
                .exceptionHandling((exceptionHandling) -> exceptionHandling
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler)
                );




        http.headers(headers -> headers
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin) // Clickjacking 공격 방지
                .httpStrictTransportSecurity(hsts -> hsts
                        .includeSubDomains(true)
                        .maxAgeInSeconds(31536000)
                ) // HSTS 설정
                .contentTypeOptions(Customizer.withDefaults()) // MIME 타입 스니핑 방지
                .referrerPolicy(referrer -> referrer.policy(ReferrerPolicyHeaderWriter.ReferrerPolicy.NO_REFERRER)) // Referrer 정책 설정
        );
        return http.build();
    }

}
