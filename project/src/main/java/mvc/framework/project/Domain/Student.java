package mvc.framework.project.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Data //It's generate getters,setters,const.. I have used for clear and less code.
@Entity

public class Student{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private  long universities_id;

    @Column(name ="startedat")
    private Date startedat; //Actually ıt was started_at but oddly this variable's name occurs problem so ı had to change to startedat.

    //It makes reference between universities_id and id.I use JsonIgnore because without this response was being a infinitive loop.
   @ManyToOne(optional = false)
   @JoinColumn(name="universities_id",referencedColumnName = "id", insertable=false, updatable=false)
   @JsonIgnore
   public Universities universities;

   //Those interface to get a specifıc variables from diffent entity classes.
   public interface StudentListItem {
       int getId();
       String getName();
       Universities.justName getUniversities();
   }
   public interface StudentDetailItem {
       int getId();
       String getName();
       java.sql.Date getStartedat();
       Universities.detailOfUniversity getUniversities();
       interface detailOfUniversity{
           int getId();
           String getName();
           String getFounded_at();
           String getType();
       }
   }

}
