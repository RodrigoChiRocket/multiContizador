package com.qualitas.portal.fraudes.account.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;


public class JwtUtil {

    public static final long JWT_TIEMPO_LIMITE = getTimeout(); //= 36000000;
    public static final String JWT_SEMILLA = getSecret();//"qwertyuiopasdfghjklzxcvbnm123456";


    public static String generarSemilla(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] semilla = new byte[256];
        secureRandom.nextBytes(semilla);
        return Base64.getEncoder().encodeToString(semilla);
    }

    public static String generarToken(String vEmail, long iUsuaID, List<String> roles, String semilla){
        return Jwts.builder().
                setSubject(vEmail).
                setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(new Date(System.currentTimeMillis() + JWT_TIEMPO_LIMITE)).
                claim("iUsuaID", iUsuaID).
                claim("roles", roles).
                signWith(SignatureAlgorithm.HS256, semilla).compact();
    }

    public static String obtenerEmail(String token, String semilla){
        return Jwts.parser().setSigningKey(semilla).
                parseClaimsJws(token).getBody().getSubject();
    }

    public static long obteneriUsuaClav(String token, String semilla){
        return Jwts.parser().setSigningKey(semilla).
                parseClaimsJws(token).getBody().get("iUsuaID",Long.class);
    }

    public static List<String> obtenerRoles(String token, String semilla){
        List<?> roles = Jwts.parser().setSigningKey(semilla).
                parseClaimsJws(token).getBody().get("roles",List.class);

        return roles.stream().map(item -> (String) item).collect(Collectors.toList());
    }

    public static JWTPayload getPayload(String token, String semilla){
        Claims claims = Jwts.parser().setSigningKey(semilla).parseClaimsJws(token).getBody();
        return new JWTPayload(claims.get("iUsuaID", Long.class), claims.getSubject(), claims.get("roles",List.class));
    }

    private static String getProperty(String key){
        Properties properties = new Properties();

        try{
            InputStream jwtData = JwtUtil.class.getClassLoader().getResourceAsStream("config/jwt.properties");

            if(jwtData == null)
                throw new RuntimeException("Ocurrio un problema con la conexion");

            properties.load(jwtData);

            return properties.getProperty(String.format("auth.jwt.%s", key));

        }catch(IOException ignore){
            throw new RuntimeException("Ocurrio un problema con la conexion");
        }
    }

    private static Long getTimeout(){
        return Long.parseLong(getProperty("timeout"));
    }

    private static String getSecret(){
        return getProperty("secret");
    }

}
