package com.liuxing.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 加密秘钥
     */
    private static final String secret="aHR0cHM6Ly9teS5vc2NoaW5hLm5ldC91LzM2ODE4Njg=";
    /**
     * 有效时间
     */
    private static final long expire=600;
    /**
     * 用户凭证
     */
    public static final String header="token";

    /**
     * 生成Token签名
     * @param userId 用户ID
     * @return 签名字符串
     * @author geYang
     * @date 2018-05-18 16:35
     */
    public String generateToken(String userId) {
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder().setHeaderParam("typ", "JWT").setSubject(userId).setIssuedAt(nowDate)
                .setExpiration(expireDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 获取签名信息
     * @param token
     * @author geYang
     * @date 2018-05-18 16:47
     */
    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            logger.debug("validate is token error ", e);
            return null;
        }
    }

    /**
     * 判断Token是否过期
     * @param expiration
     * @return true 过期
     * @author geYang
     * @date 2018-05-18 16:41
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

}
