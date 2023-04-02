package ru.expram.todoapi.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private T result;
    private Object errors;

    public static <T> ResponseEntity<T> ok(T result) {
        Response<T> response = new Response<>();
        response.setResult(result);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> notFound(Object errors) {
        Response<T> response = new Response<>();
        response.setErrors(errors);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

}