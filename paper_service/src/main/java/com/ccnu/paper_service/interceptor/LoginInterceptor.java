package com.ccnu.paper_service.interceptor;

import com.ccnu.paper_service.utils.JsonData;
import com.ccnu.paper_service.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: ck
 * @Description: 登陆拦截器
 * @Date: Create in 15:51 2020/7/8
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }
            if (StringUtils.isNotBlank(accessToken)) {
                Claims claims = JwtUtils.checkJWT(accessToken);  //jwt校验，解析jwt内容
                if (claims == null) {
                    sendJsonMessage(response, JsonData.buildError("登陆失败"));
                    System.out.println("登陆失败0");
                    return false;
                    //登陆过期
                }
                Integer id = (Integer) claims.get("id");

                String name = (String) claims.get("name");

                request.setAttribute("id", id);
                request.setAttribute("name", name);
                return true;


            }
        }catch (Exception e)
        {
            //登陆异常
            e.printStackTrace();
        }
        sendJsonMessage(response, JsonData.buildError("登陆失败"));
        System.out.println("登陆失败1");
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

  /*
   自定义响应json数据给前端
   */
    public static void sendJsonMessage(HttpServletResponse  response,Object object)
    {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8"); //设置http响应类型
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(object)); //以字符串形式写出
            writer.close();  //关闭输出流
            response.flushBuffer(); //刷新缓存

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
