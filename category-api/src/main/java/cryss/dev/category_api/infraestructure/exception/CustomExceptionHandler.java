package cryss.dev.category_api.infraestructure.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    public static final String CONSTRAINT_VALIDATION_FAILED = "Constraint validation failed";
    public static final String ORIGIN = "ms_category_api";
    /**
     *
     * @param exMethod
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validationError(MethodArgumentNotValidException exMethod) {

        BindingResult bindingResult = exMethod.getBindingResult();

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<String> fieldErrorDtos = fieldErrors.stream()
                .map(f -> f.getField().concat(":").concat(f.getDefaultMessage())).map(String::new)
                .toList();

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .origin(ORIGIN)
                .description(fieldErrorDtos.toString())
                .build();

        return ResponseEntity.status(ex.getHttpStatusCode()).body(ex.getOnlyBody());
    }
}
