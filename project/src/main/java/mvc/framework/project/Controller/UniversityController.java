package mvc.framework.project.Controller;


import mvc.framework.project.Dao.UniversityDAO;
import mvc.framework.project.Domain.Universities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UniversityController {
    @Autowired(required = false)
    UniversityDAO universityDAO;
    // It's return all universities with full properties.It's actually a extra.
    @GetMapping("/get")
    public  Iterable<Universities> getAllUniversities(){
        return universityDAO.findAll();
    }

    // It's return all Universities.
    @GetMapping("/universities")
    public Iterable<Universities.UniversityListItem> getAllId(){
        return universityDAO.findAllId();
    }
    // It's find university by id.
    @GetMapping("/universities/{id}")
    public Universities getUnivercityById(@PathVariable Long id){
        //In case of could'nt find id or being null of object ı have created a case like that.
            if(universityDAO.findUnivercitiesById(id)==null)
                throw new RuntimeException(id+" numaralı üniversitesine dair kayıt bulunamadı.");

        return universityDAO.findUnivercitiesById(id);
    }


}
