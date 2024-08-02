package shop.xiaoyishi.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName JwtUtil工具类
 * @project agriBlissMart_common
 * @Description
 * @Version 1.0
 */
@Slf4j
public class JwtUtil {

    /**
     * 生成jwt
     * 使用Hs256算法，私钥使用固定密钥
     * @param secretKey  jwt密钥
     * @param ttlMillis  jwt过期时间，单位毫秒
     * @param claims     设置的信息
     * @return
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims){
        //指定加密算法
        SecureDigestAlgorithm<SecretKey, SecretKey> algorithm = Jwts.SIG.HS256;
        //生成JWT的时间
        long expMillis = System.currentTimeMillis()+ttlMillis;
        Date exp = new Date(expMillis);
        //密钥实例
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(exp)
                .setExpiration(exp)
                .signWith(key)
                .compact();
    }


    /**
     * 解析jwt
     * @param token
     * @param secretKey
     * @return
     */
    public static Jws<Claims> parseJWT(String token, String secretKey){
        //密钥实例
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.parser()
                .verifyWith(key)  //设置签名的密钥
                .build()
                .parseSignedClaims(token); //设置要解析的jwt
    }

}