package denilson.mamani.upeu.msalumno.service.impl;


import denilson.mamani.upeu.msalumno.entity.Alumno;
import denilson.mamani.upeu.msalumno.repository.AlumnoRepository;
import denilson.mamani.upeu.msalumno.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Optional<Alumno> buscarPorId(Integer id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno actualizar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void eliminar(Integer id) {
        alumnoRepository.deleteById(id);
    }
}
