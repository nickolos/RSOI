package micro.service.taxi.controllers;

import org.osergey.contact.model.ContactErrorResponse;
import org.osergey.contact.service.ContactExistsException;
import org.osergey.contact.service.ContactNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
@ConditionalOnProperty("taxi.micro.service")
public class ContactExceptionController {
    private static final Logger log = LoggerFactory.getLogger(ContactExceptionController.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ContactExistsException.class)
    public ContactErrorResponse exists(ContactExistsException exception) {
        log.error(exception.getMessage(), exception);
        return new ContactErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ContactNotFoundException.class)
    public ContactErrorResponse notFound(ContactNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return new ContactErrorResponse(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ContactErrorResponse exception(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ContactErrorResponse(exception.getMessage());
    }
}
