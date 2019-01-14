package micro.service.taxi.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import micro.service.taxi.entities.Taxis;
import micro.service.taxi.repository.TaxisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
//@ConditionalOnProperty("taxi.micro.service")
@RequestMapping("/taxis")
public class TaxisController {
    private static final Logger logger = LoggerFactory.getLogger(TaxisController.class);

    private TaxisRepository taxisRepository;

    @Autowired
    public TaxisController(TaxisRepository taxisRepository) {
        this.taxisRepository = taxisRepository;
    }


    @RequestMapping("json")
    public void json() {
        //get json data from file "people.json" in our resources

        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:taxis.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Taxis> people = objectMapper.readValue(jsonFile, new TypeReference<List<Taxis>>() {
            });

            taxisRepository.saveAll(people);

            logger.info("All records saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//

//    @Autowired
//    @Qualifier("localContactService")
//    ContactService contactService;
//
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
//    public ContactResponse findOne(@PathVariable int id) {
//        log.info("GET /taxi/" + id);
//        return contactService.findOne(id);
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
//    public void create(@PathVariable int id, @RequestBody ContactRequest contact, HttpServletResponse response) {
//        log.info("POST /taxi/" + id + " taxi " + contact);
//        contactService.create(id, contact);
//        response.addHeader(HttpHeaders.LOCATION, "/taxi/" + id);
//    }
//
//    @ResponseBody
//    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
//    public ContactResponse update(@PathVariable int id, @RequestBody ContactRequest contact) {
//        log.info("PATH /taxi/" + id + " taxi " + contact);
//        return contactService.update(id, contact);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
//    public void delete(@PathVariable int id) {
//        log.info("DELETE /taxi/" + id);
//        contactService.delete(id);
//    }
}
