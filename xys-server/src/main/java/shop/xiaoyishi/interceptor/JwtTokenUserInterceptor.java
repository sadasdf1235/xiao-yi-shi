package shop.xiaoyishi.interceptor;

import shop.xiaoyishi.constant.JwtClaimsConstant;
import shop.xiaoyishi.context.BaseContext;
import shop.xiaoyishi.properties.JwtProperties;
import shop.xiaoyishi.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Enumeration;

/**
 * jwt令牌校验的拦截器
 */
@Component
@Slf4j
public class JwtTokenUserInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        log.info("---{}",jwtProperties.getUserTokenName());
        String token = request.getHeader(jwtProperties.getUserTokenName());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info(headerName + ": " + request.getHeader(headerName));
        }

        if (token == null || token.isEmpty()) {
            log.warn("Token is missing or empty");
            response.setStatus(401);
            return false;
        }

        try {
            log.info("jwt校验:{}", token);
            Jws<Claims> jwsClaims = JwtUtil.parseJWT(token, jwtProperties.getUserSecretKey());
            Claims claims = jwsClaims.getBody();

            if (claims == null) {
                log.warn("Failed to parse JWT claims");
                response.setStatus(401);
                return false;
            }

            String userIdStr = claims.get(JwtClaimsConstant.USER_ID).toString();
            if (userIdStr == null || userIdStr.isEmpty()) {
                log.warn("User ID claim is missing or empty");
                response.setStatus(401);
                return false;
            }

            Long userId = Long.valueOf(userIdStr);
            log.info("当前用户id：{}", userId);
            BaseContext.setCurrentId(userId);
            return true;
        } catch (Exception ex) {
            log.error("JWT 校验失败", ex);
            response.setStatus(401);
            return false;
        }
    }
}
