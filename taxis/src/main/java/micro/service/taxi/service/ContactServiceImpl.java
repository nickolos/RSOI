package micro.service.taxi.service;

import org.osergey.contact.domain.Contact;
import org.osergey.contact.model.ContactRequest;
import org.osergey.contact.model.ContactResponse;
import org.osergey.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("localContactService")
@ConditionalOnProperty("taxi.micro.service")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    private Contact findChecked(int id) {
        Contact entity = contactRepository.findOne(id);
        if(entity == null) {
            throw new ContactNotFoundException(id);
        }
        return entity;
    }

    @Override
    @Transactional(readOnly = true)
    public ContactResponse findOne(int id) {
        return new ContactResponse(findChecked(id));
    }

    @Override
    @Transactional
    public ContactResponse create(int id, ContactRequest contact) {
        if(contactRepository.exists(id)) {
            throw new ContactExistsException(id);
        }
        Contact entity = new Contact();
        entity.setId(id);
        entity.setName(contact.getName());
        entity.setPhone(contact.getPhone());
        return new ContactResponse(contactRepository.save(entity));
    }

    @Override
    @Transactional
    public ContactResponse update(int id, ContactRequest contact) {
        Contact entity = findChecked(id);
        entity.setName(contact.getName() != null ? contact.getName() : entity.getName());
        entity.setPhone(contact.getPhone() != null ? contact.getPhone() : entity.getPhone());
        return new ContactResponse(contactRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(int id) {
        contactRepository.delete(findChecked(id));
    }
}
