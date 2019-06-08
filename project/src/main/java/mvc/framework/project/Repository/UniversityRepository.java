package mvc.framework.project.Repository;

import mvc.framework.project.Domain.Universities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<Universities,Long> {

    Iterable<Universities.UniversityListItem>findAllBy();

}
