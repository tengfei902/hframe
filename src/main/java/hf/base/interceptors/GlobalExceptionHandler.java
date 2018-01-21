package hf.base.interceptors;

import hf.base.contants.CodeManager;
import hf.base.utils.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseResult handleException(Exception e) {
        e.printStackTrace();
        return ResponseResult.failed(CodeManager.BIZ_FAIELD,e.getMessage(),null);
    }
}
