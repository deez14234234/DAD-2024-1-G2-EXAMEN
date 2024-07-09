package denilson.mamani.upeu.msmatricula.feign;
import denilson.mamani.upeu.msmatricula.dto.AlumnoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-alumno-service", path = "/alumno")
public interface AlumnoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "alumnoListarPorIdCB", fallbackMethod = "fallbackAlumno")
    public ResponseEntity<AlumnoDto> buscarPorId(@PathVariable(required = true) Integer id);
    default ResponseEntity<AlumnoDto> fallbackAlumno(Integer id, Exception e) {

        return ResponseEntity.ok(new AlumnoDto());
    }
}
