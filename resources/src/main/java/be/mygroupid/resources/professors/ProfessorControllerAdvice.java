package be.mygroupid.resources.professors;

import be.mygroupid.services.exceptions.IllegalFieldFoundException;
import be.mygroupid.services.exceptions.UnknownResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// copied from example exercise
@ControllerAdvice(basePackages = {"be.mygroupid"})
public class ProfessorControllerAdvice {

    @ExceptionHandler(UnknownResourceException.class)
    public ResponseEntity<String> convertUnknownIdException(final UnknownResourceException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalFieldFoundException.class)
    public ResponseEntity<String> convertIllegalFieldFoundException(final IllegalFieldFoundException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

}
