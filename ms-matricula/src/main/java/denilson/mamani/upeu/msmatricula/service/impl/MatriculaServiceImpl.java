package denilson.mamani.upeu.msmatricula.service.impl;


import denilson.mamani.upeu.msmatricula.dto.AlumnoDto;
import denilson.mamani.upeu.msmatricula.entity.Matricula;
import denilson.mamani.upeu.msmatricula.feign.AlumnoFeign;
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

    @Autowired
    private AlumnoFeign alumnoFeign;

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
        Optional<Matricula> matricula = matriculaRespository.findById(id);
        if (matricula.isPresent()) {
            Matricula m = matricula.get();
            AlumnoDto alumnoDto = alumnoFeign.buscarPorId(m.getAlumnoId()).getBody();
            m.setAlumnoDto(alumnoDto);
            return Optional.of(m);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Matricula actualizar(Matricula matricula) {
        return matriculaRespository.save(matricula);
    }

    @Override
    public void eliminar(Integer id) {
        matriculaRespository.deleteById(id);
    }
}