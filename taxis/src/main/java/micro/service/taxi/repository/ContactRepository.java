package micro.service.taxi.repository;

import micro.service.taxi.domain.Taxis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//@ConditionalOnProperty("taxi.micro.service")
public interface ContactRepository extends CrudRepository<Taxis, Long> {
}
