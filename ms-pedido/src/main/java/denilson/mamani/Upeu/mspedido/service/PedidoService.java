package denilson.mamani.Upeu.mspedido.service;

import denilson.mamani.Upeu.mspedido.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    public List<Pedido> listar();

    public Pedido guardar(Pedido pedido);

    public Optional<Pedido> buscarPorId(Integer id);

    public Pedido actualizar(Pedido pedido);

    public void eliminar(Integer id);
}
