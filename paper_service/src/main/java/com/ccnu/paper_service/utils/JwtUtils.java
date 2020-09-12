package com.ccnu.paper_service.utils;

import com.ccnu.paper_service.model.entity.Lawyer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: ck
 * @Description: jwts工具类
 * @Date: Create in 14:48 2020/7/8
 */
public class JwtUtils {
    /*
    设置过期时间
     */
    private static final long EXPIRE = 6000*60*24*7;

    /*
    设置jwt主题
     */
    private static final String SUBJECT ="ccnu";
    /*
    设置密码
     */
    private static final  String SECRET = "ccnu.cn";
    /*
    设置jwt前缀
     */
    private static final String TOKEN_PREFIX ="ccnu";
   /*
    根据用户信息，生成令牌
    */
   public static String JsonWebToken(Lawyer lawyer)
   {
       String token = Jwts.builder().setSubject(SUBJECT)  //设置主题
               .claim("name",lawyer.getName())  //设置加密字段
               .claim("id",lawyer.getId())
               .setIssuedAt(new Date())   //设置授权时间
               .setExpiration(new Date(System.currentTimeMillis()+EXPIRE)) //设置截止时间
               .signWith(SignatureAlgorithm.HS256,SECRET).compact(); //设置加密规则
       token += TOKEN_PREFIX;
       return token;
   }

   /*
   校验方法
    */
   public static Claims checkJWT(String token)
   {
       try {
           final Claims claims =Jwts.parser().setSigningKey(SECRET)
                   .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
           return claims;

   }
   catch (Exception e)
   {
       return  null;
   }

   }

}
