package com.ccnu.paper_service.exception;


import com.ccnu.paper_service.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ck
 * @Description: 异常处理类
 * @Date: Create in 10:54 2020/7/8
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e)
    {
        if(e instanceof CkException)
        {
            CkException ckException =(CkException) e;
            return JsonData.buildError(ckException.getCode(),ckException.getMsg());
        }
        else
            return JsonData.buildError("全局异常，未知错误");
    }
}
