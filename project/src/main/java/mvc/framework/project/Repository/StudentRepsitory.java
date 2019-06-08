package mvc.framework.project.Repository;

import mvc.framework.project.Domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepsitory extends CrudRepository<Student,Long>{

    Iterable<Student.StudentListItem>findAllBy();
    Iterable<Student.StudentDetailItem> findById(@Param("id")Long id);

}
