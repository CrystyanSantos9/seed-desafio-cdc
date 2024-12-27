package cryss.dev.category_api.infraestructure.exception;

import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
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
        List<ObjectError> objectErrors = bindingResult.getAllErrors ();

        if(ObjectUtils.isNotEmpty (fieldErrors)){
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

        }else {
            List<String> objectErrorsDtos = objectErrors.stream()
                    .map(f -> f.getObjectName ().concat(":").concat(f.getDefaultMessage())).map(String::new)
                    .toList();

            BusinessException ex = BusinessException.builder()
                    .httpStatusCode(HttpStatus.BAD_REQUEST)
                    .message(CONSTRAINT_VALIDATION_FAILED)
                    .origin(ORIGIN)
                    .description(objectErrorsDtos.toString())
                    .build();
            return ResponseEntity.status(ex.getHttpStatusCode()).body(ex.getOnlyBody());
        }

    }

    /**
     *
     * @param exMethod
     * @param request
     * @return
     */
    @ExceptionHandler({ org.hibernate.exception.ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exMethod, WebRequest request) {
        List<String> errors = new ArrayList<> ();
        for (Throwable violation : exMethod.getSQLException ()) {
            errors.add(violation.getMessage () + ":" + violation.getCause ());
        }

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.UNPROCESSABLE_ENTITY)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(errors.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler({ jakarta.validation.ConstraintViolationException.class })
    public ResponseEntity<Object> handleJakartaConstraintViolation(jakarta.validation.ConstraintViolationException exMethod, WebRequest request) {
        List<String> errors = new ArrayList<> ();
        for (ConstraintViolation<?> violation : exMethod.getConstraintViolations ()) {
            errors.add(violation.getPropertyPath () + ":" + violation.getMessage ());
        }

        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.UNPROCESSABLE_ENTITY)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(errors.toString())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler(value = { BusinessException.class})
    protected ResponseEntity<Object> handleConflict(BusinessException ex, WebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    /**
     *
     * @param exMethod
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> validationError(HttpMessageNotReadableException exMethod) {

        Throwable mostSpecificCause = exMethod.getMostSpecificCause();
        BusinessException ex = BusinessException.builder()
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .message(CONSTRAINT_VALIDATION_FAILED)
                .description(mostSpecificCause.getMessage())
                .build();
        HttpHeaders responseHeaders = new HttpHeaders();

        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

}
