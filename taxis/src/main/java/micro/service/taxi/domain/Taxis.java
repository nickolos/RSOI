package micro.service.taxi.domain;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "taxi", schema = "taxis")
public class Taxis {

    @Id
    @GeneratedValue
    private Long pk;


    private String firstName;

    private String email;
    private String gender;
    private String country;
    private String ipAddress;


    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;
}
