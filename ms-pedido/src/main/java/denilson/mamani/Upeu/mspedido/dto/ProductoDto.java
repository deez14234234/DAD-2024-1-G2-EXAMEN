package denilson.mamani.Upeu.mspedido.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private Integer id;
    private String nombre;
    private CategoriaDto categoria;
}
