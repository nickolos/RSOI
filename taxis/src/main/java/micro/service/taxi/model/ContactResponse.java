package micro.service.taxi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.osergey.contact.domain.Contact;

@Data
@NoArgsConstructor
public class ContactResponse {
    private String name;
    private String phone;

    public ContactResponse(Contact contact) {
        name = contact.getName();
        phone = contact.getPhone();
    }
}
