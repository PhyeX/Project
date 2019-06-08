package mvc.framework.project.Dao;

import mvc.framework.project.Domain.Universities;
import mvc.framework.project.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityDAO {

    @Autowired
    UniversityRepository universityRepository;

    public Iterable<Universities> findAll() { return universityRepository.findAll(); }

     public Iterable<Universities.UniversityListItem> findAllId(){
        return universityRepository.findAllBy();
     }

    public Universities findUnivercitiesById(Long id){ return universityRepository.findOne(id);}



}
