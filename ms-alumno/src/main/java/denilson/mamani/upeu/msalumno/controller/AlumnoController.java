package denilson.mamani.upeu.msalumno.controller;


import denilson.mamani.upeu.msalumno.entity.Alumno;
import denilson.mamani.upeu.msalumno.service.AlumnoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> listar() {
        return ResponseEntity.ok(alumnoService.listar());
    }

    @PostMapping
    public ResponseEntity<Alumno> guardar(@RequestBody Alumno categoria) {
        return ResponseEntity.ok(alumnoService.guardar(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscarPOrId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(alumnoService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Alumno> actualizar(@RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.actualizar(alumno));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Alumno>>  eliminar(@PathVariable(required = true) Integer id) {
        alumnoService.eliminar(id);
        return ResponseEntity.ok(alumnoService.listar());
    }


}
