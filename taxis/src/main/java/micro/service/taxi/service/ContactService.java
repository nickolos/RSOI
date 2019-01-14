package micro.service.taxi.service;

import org.osergey.contact.model.ContactRequest;
import org.osergey.contact.model.ContactResponse;

public interface ContactService {
    ContactResponse findOne(int id);
    ContactResponse create(int id, ContactRequest contact);
    ContactResponse update(int id, ContactRequest contact);
    void delete(int id);
}
