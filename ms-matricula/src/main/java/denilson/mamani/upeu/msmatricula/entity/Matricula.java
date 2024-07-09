package denilson.mamani.upeu.msmatricula.entity;



import denilson.mamani.upeu.msmatricula.dto.AlumnoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigo_matricula;
    private Integer alumnoId;
    @Transient
    private AlumnoDto alumnoDto;
}