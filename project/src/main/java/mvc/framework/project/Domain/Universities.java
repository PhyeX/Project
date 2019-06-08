package mvc.framework.project.Domain;

import lombok.Data;
import javax.persistence.*;
import java.util.Collection;


@Data // It's generate Getters,Setters,Cons.. I have used that because of ı wanted clear and less code.
@Entity
public class Universities{
    @Id
    @Column(name = "id")
    private Long id;
  // Columns show that what are they column names of in the MySQL.
    @Column(name = "api_id")
    private Long api_id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "founded_at")
    private int founded_at; //I declare as a integer because the variable consists of 4 integers.

    @Column(name = "web_page")
    private String web_page;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "universities" )
    private Collection<Student> students;

    // We use that interface to get just name and ID and the others for to get specific variables.
    public interface UniversityListItem{
        String getName();
        int getId();
    }
   public interface justName{
        String getName();
   }
   public interface detailOfUniversity{
        int getId();
        String getName();
        String getFounded_at();
        String getType();
   }
}

