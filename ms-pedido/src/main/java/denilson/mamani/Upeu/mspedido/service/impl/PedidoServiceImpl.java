package denilson.mamani.Upeu.mspedido.service.impl;

import denilson.mamani.Upeu.mspedido.dto.ClienteDto;
import denilson.mamani.Upeu.mspedido.entity.Pedido;
import denilson.mamani.Upeu.mspedido.entity.PedidoDetalle;
import denilson.mamani.Upeu.mspedido.feign.CatalogoFeign;
import denilson.mamani.Upeu.mspedido.feign.ClienteFeign;
import denilson.mamani.Upeu.mspedido.repository.PedidoRespository;
import denilson.mamani.Upeu.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRespository pedidoRespository;
    @Autowired
    private ClienteFeign clienteFeign;
    @Autowired
    private CatalogoFeign catalogoFeign;

    @Override
    public List<Pedido> listar() {
        return pedidoRespository.findAll();
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        return pedidoRespository.save(pedido);
    }

    @Override
    public Optional<Pedido> buscarPorId(Integer id) {
        Optional<Pedido> pedido = pedidoRespository.findById(id);
        ClienteDto clienteDto = clienteFeign.buscarPorId(pedido.get().getClienteId()).getBody();
       /* for (PedidoDetalle pedidoDetalle : pedido.get().getDetalle()) {
            pedidoDetalle.setProductoDto(catalogoFeign.productoBuscarPorId(pedidoDetalle.getProductoId()).getBody());
        }*/

        List<PedidoDetalle> pedidoDetalles = pedido.get().getDetalle().stream().map(pedidoDetalle -> {
            pedidoDetalle.setProductoDto(catalogoFeign.productoBuscarPorId(pedidoDetalle.getProductoId()).getBody());
            return pedidoDetalle;
        }).toList();
        pedido.get().setClienteDto(clienteDto);
        pedido.get().setDetalle(pedidoDetalles);
        return pedidoRespository.findById(id);
    }

    @Override
    public Pedido actualizar(Pedido pedido) {
        return pedidoRespository.save(pedido);
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRespository.deleteById(id);

    }
}
