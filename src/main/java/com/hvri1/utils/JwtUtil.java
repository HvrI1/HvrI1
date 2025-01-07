package com.hvri1.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    //KEY常量：这个常量用于签名JWT。签名用于确保JWT的完整性和安全性。
    private static final String KEY = "wsnwsn";
	//接收业务数据,生成token并返回
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                //使用withClaim方法添加业务数据到JWT。claims是一个包含业务数据的Map。
                .withClaim("claims", claims)
                //使用withExpiresAt方法设置JWT的过期时间。这里设置为12*5=60分钟后过期。
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12*5))
                //使用sign方法对JWT进行签名。Algorithm.HMAC256(KEY)表示使用HMAC-SHA256算法进行签名。
                .sign(Algorithm.HMAC256(KEY));
    }
	//接收token,验证token,并返回业务数据
    public static Map<String, Object> parseToken(String token) {
        //使用JWT.require(Algorithm.HMAC256(KEY))创建一个JWT对象，并设置签名算法为HMAC-SHA256，密钥为KEY。
        return JWT.require(Algorithm.HMAC256(KEY))
                //使用build()方法构建JWT对象。
                .build()
                //使用verify方法验证JWT的签名是否正确。
                .verify(token)
                //使用getClaim方法获取JWT中的claims部分，并将其转换为Map。
                .getClaim("claims")
                .asMap();
    }
}
