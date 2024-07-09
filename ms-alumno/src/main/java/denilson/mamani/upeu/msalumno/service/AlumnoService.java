package denilson.mamani.upeu.msalumno.service;


import denilson.mamani.upeu.msalumno.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    public List<Alumno> listar();

    public Alumno guardar(Alumno alumno);

    public Optional<Alumno> buscarPorId(Integer id);

    public Alumno actualizar(Alumno alumno);

    public void eliminar(Integer id);
}
