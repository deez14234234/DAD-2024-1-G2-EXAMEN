package denilson.mamani.upeu.msmatricula.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import denilson.mamani.Upeu.mspedido.dto.ClienteDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codigomatricula;


}
