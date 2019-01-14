package micro.service.taxi.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
//@ConditionalOnProperty("taxi.micro.service")
@RequestMapping("/contact")
public class ContactController {
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    @Qualifier("localContactService")
    ContactService contactService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ContactResponse findOne(@PathVariable int id) {
        log.info("GET /taxi/" + id);
        return contactService.findOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public void create(@PathVariable int id, @RequestBody ContactRequest contact, HttpServletResponse response) {
        log.info("POST /taxi/" + id + " taxi " + contact);
        contactService.create(id, contact);
        response.addHeader(HttpHeaders.LOCATION, "/taxi/" + id);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public ContactResponse update(@PathVariable int id, @RequestBody ContactRequest contact) {
        log.info("PATH /taxi/" + id + " taxi " + contact);
        return contactService.update(id, contact);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable int id) {
        log.info("DELETE /taxi/" + id);
        contactService.delete(id);
    }
}
