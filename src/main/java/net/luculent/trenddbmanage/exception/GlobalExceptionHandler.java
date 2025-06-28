package net.luculent.trenddbmanage.exception;

import net.luculent.trenddbmanage.common.model.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 参数校验异常（@Valid）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result<Void>> handleValidationException(MethodArgumentNotValidException ex) {
        // 只取第一个错误信息（也可以遍历合并）
        String msg = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity.ok(Result.<Void>builder()
                .status(10001)
                .message(msg)
                .data(null)
                .build());
    }

    // 业务异常 / RuntimeException
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Result<Void>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok(Result.<Void>builder()
                .status(99999)
                .message(ex.getMessage())
                .data(null)
                .build());
    }
}


