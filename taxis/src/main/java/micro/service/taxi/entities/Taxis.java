package micro.service.taxi.entities;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "taxis", schema = "card")
public class Taxis {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "car_number")
    private String car_number;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "rating")
    private float rating;


    @Column(name = "status")
    private boolean status;

}
