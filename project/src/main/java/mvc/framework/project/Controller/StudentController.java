package mvc.framework.project.Controller;

import mvc.framework.project.Dao.StudentDAO;
import mvc.framework.project.Domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {
    @Autowired(required = false)
    StudentDAO studentDAO;
    //It's return all students with full properties as we can see.
    @GetMapping("/studentsWithFullProperties")
    public Iterable<Student>getAllStudents(){
      return studentDAO.findAll();
    }

    // It's return all students with just name and ıd.
    @GetMapping("/students")
    public Iterable<Student.StudentListItem>findAllId(){
        return studentDAO.findAllId();
    }
   // It's return a student who found by ID.
    @GetMapping("/students/{id}")
    public Iterable<Student.StudentDetailItem>findById(@PathVariable Long id){
 //Even the object null or empty ıt was returning sometings like [].So in order to understand object is empty so ı did a empty object myself and compared them.
         Long nullFounder = Long.MIN_VALUE;
             if(studentDAO.findById(id).equals(studentDAO.findById(nullFounder)))
                 throw new RuntimeException(id+" numaralı ögrenciye dair kayıt bulunamadı.");

        return studentDAO.findById(id);
    }
    // It's creating a students and save database.
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student){
        if (student.getName()==null||student.getName().equals(""))
       throw new RuntimeException("İsim kısmı boş bırakılamaz");
        return studentDAO.saveStudent(student);
    }

}
