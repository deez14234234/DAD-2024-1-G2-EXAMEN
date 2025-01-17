package denilson.mamani.upeu.msmatricula.service;


import denilson.mamani.upeu.msmatricula.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {

    public List<Matricula> listar();

    public Matricula guardar(Matricula matricula);

    public Optional<Matricula> buscarPorId(Integer id);

    public Matricula actualizar(Matricula matricula);

    public void eliminar(Integer id);
}
