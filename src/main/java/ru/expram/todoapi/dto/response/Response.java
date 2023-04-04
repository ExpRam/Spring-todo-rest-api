package ru.expram.todoapi.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.expram.todoapi.dto.model.TodoDto;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private Date date;
    private HttpStatus status;
    private T data;
    private Object error;

    public Response() {
        this.date = new Date();
        this.status = HttpStatus.OK;
    }

    public ResponseEntity<T> build() {
        return new ResponseEntity(this, this.status);
    }

}