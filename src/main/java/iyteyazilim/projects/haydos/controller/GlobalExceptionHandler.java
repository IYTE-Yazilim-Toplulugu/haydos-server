package iyteyazilim.projects.haydos.controller;
import iyteyazilim.projects.haydos.exeception.NotFoundResourceUnApproved;
import iyteyazilim.projects.haydos.exeception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundResourceUnApproved.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 404 yerine farklı bir hata kodu döndürüyoruz
    public ResponseEntity<Map<String, String>> handleNotFoundResourceUnApproved(NotFoundResourceUnApproved ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("status", "error");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception){
        Map<String , String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }
}
