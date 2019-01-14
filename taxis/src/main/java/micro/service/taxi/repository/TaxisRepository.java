package micro.service.taxi.repository;

import micro.service.taxi.entities.Taxis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//@ConditionalOnProperty("taxi.micro.service")
public interface TaxisRepository extends CrudRepository<Taxis, Long> {
}
