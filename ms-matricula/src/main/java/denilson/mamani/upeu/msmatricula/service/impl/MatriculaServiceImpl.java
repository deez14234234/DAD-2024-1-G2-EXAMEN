package denilson.mamani.upeu.msmatricula.service.impl;


import denilson.mamani.upeu.msmatricula.entity.Matricula;
import denilson.mamani.upeu.msmatricula.repository.MatriculaRespository;
import denilson.mamani.upeu.msmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    @Autowired
    private MatriculaRespository matriculaRespository;
//    @Autowired
//    private AlumnoFeign alumnoFeign;

    @Override
    public List<Matricula> listar() {
        return matriculaRespository.findAll();
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return matriculaRespository.save(matricula);
    }

    @Override
    public Optional<Matricula> buscarPorId(Integer id) {
        return matriculaRespository.findById(id);
    }
//    public Optional<Matricula> buscarPorId(Integer id) {
//        Optional<Matricula> pedido = matriculaRespository.findById(id);
//        AlumnoDto clienteDto = AlumnoFeign.buscarPorId(pedido.get().getClienteId()).getBody();
//       /* for (PedidoDetalle pedidoDetalle : pedido.get().getDetalle()) {
//            pedidoDetalle.setProductoDto(catalogoFeign.productoBuscarPorId(pedidoDetalle.getProductoId()).getBody());
//        }*/
//
//        List<PedidoDetalle> pedidoDetalles = pedido.get().getDetalle().stream().map(pedidoDetalle -> {
//            pedidoDetalle.setProductoDto(catalogoFeign.productoBuscarPorId(pedidoDetalle.getProductoId()).getBody());
//            return pedidoDetalle;
//        }).toList();
//        pedido.get().setClienteDto(clienteDto);
//        pedido.get().setDetalle(pedidoDetalles);
//        return pedidoRespository.findById(id);
//    }

    @Override
    public Matricula actualizar(Matricula matricula) {
        return matriculaRespository.save(matricula);
    }

    @Override
    public void eliminar(Integer id) {
        matriculaRespository.deleteById(id);

    }
}
