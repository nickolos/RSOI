package micro.service.taxi.service;

public class ContactExistsException extends RuntimeException {
    public ContactExistsException(int id) {
        super("Contact {" + id + "} already exists");
    }
}
