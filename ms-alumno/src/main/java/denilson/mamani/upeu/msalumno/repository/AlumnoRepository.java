package denilson.mamani.upeu.msalumno.repository;


import denilson.mamani.upeu.msalumno.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
}
