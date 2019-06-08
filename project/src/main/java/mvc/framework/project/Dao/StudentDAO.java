package mvc.framework.project.Dao;

import mvc.framework.project.Domain.Student;
import mvc.framework.project.Repository.StudentRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentDAO {
    @Autowired
    StudentRepsitory studentRepsitory;

    public Iterable<Student>findAll(){
        return studentRepsitory.findAll();
    }
    public Iterable<Student.StudentListItem> findAllId(){
        return studentRepsitory.findAllBy();
    }
    public Iterable<Student.StudentDetailItem> findById(Long id){ return studentRepsitory.findById(id); }
    public Student saveStudent(Student student) { return studentRepsitory.save(student); }


}
