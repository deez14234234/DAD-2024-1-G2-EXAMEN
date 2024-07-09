package denilson.mamani.upeu.msmatricula.repository;


import denilson.mamani.upeu.msmatricula.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRespository extends JpaRepository<Matricula, Integer> {
}
