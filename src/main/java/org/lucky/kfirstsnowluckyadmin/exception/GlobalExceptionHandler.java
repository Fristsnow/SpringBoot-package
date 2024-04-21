package org.lucky.kfirstsnowluckyadmin.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.lucky.kfirstsnowluckyadmin.utils.snow.AjaxResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public AjaxResult handleAppException(BaseException e, HttpServletResponse response) {
        log.info("自定义的异常处理:{},{}", e.getCode(), e.getDefaultMessage());
        response.setStatus(e.getCode());
        return AjaxResult.error(e.getCode(),e.getDefaultMessage());
    }

    /**
     * 全局异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handlerException(Exception e) {
        e.printStackTrace();
        return AjaxResult.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "系统错误");
    }
}
