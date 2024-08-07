package shop.xiaoyishi.handler;

import shop.xiaoyishi.constant.MessageConstant;
import shop.xiaoyishi.exception.BaseException;
import shop.xiaoyishi.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 处理sql异常
     * @param ex
     * @return
     */
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String mes = ex.getMessage();
        if(mes.contains(("Deplicate entry"))){
            String[] split = mes.split(" ");
            return Result.error(split[2] + MessageConstant.ALREADY_EXISTS);
        }
        return Result.error(MessageConstant.UNKNOWN_ERROR);
    }
}
