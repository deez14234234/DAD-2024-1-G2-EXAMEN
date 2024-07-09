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
    private String serie;
    private String numero;
    private String descripcion;
    private Integer clienteId;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<PedidoDetalle> detalle;

    @Transient
    private ClienteDto clienteDto;


}
