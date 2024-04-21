package org.lucky.kfirstsnowluckyadmin.interceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lucky.kfirstsnowluckyadmin.utils.JwtUtil;
import org.lucky.kfirstsnowluckyadmin.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Component
public class LoginInterceptions implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("Authorization");
//        try {
//            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
//            String redisToken = stringStringValueOperations.get(token);
//            // 如果redis中没有token，则抛出异常
//            if (redisToken == null) throw new RuntimeException();
//            Map<String, Object> map = JwtUtil.parseToken(token);
//            ThreadLocalUtil.set(map);
//            return true;
//        } catch (Exception e) {
//            response.setStatus(401);
//            throw new RuntimeException(e);
////            return false;
//        }
//        return HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        ThreadLocalUtil.remove();
    }
}
