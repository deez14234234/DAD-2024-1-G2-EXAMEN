package denilson.mamani.upeu.msmatricula.dto;

import lombok.Data;

@Data
public class AlumnoDto {
    private Integer id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correoElectronico;
    private String direccion;
}
