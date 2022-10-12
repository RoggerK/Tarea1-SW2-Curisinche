package idat.edu.pe.c6.sw2.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.c6.sw2.model.Alumno;
import idat.edu.pe.c6.sw2.response.Mensaje;
import idat.edu.pe.c6.sw2.service.AlumnoService;

@RestController
@RequestMapping("/alumno/v1")
public class AlumnoRestController {
	@Autowired
	private AlumnoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Alumno>> listar() {
		return new ResponseEntity<List<Alumno>>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Alumno> porId(@PathVariable Long id) {
		Alumno alumno = service.porId(id);
		if(alumno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Alumno>(service.porId(id), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Mensaje> guardar(@RequestBody Alumno alumno) {
		alumno.setIdAlumno(0L);
		service.guardar(alumno);
		return new ResponseEntity<Mensaje>(new Mensaje("Alumno creado con exito"), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Mensaje> actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
		Boolean existeAlumno = service.exitePorId(id);
		if(existeAlumno) {
			service.actualizar(id, alumno);
			return new ResponseEntity<Mensaje>(new Mensaje("Alumno actualizado con exito"), HttpStatus.OK);
		}else {
			return new ResponseEntity<Mensaje>(new Mensaje("Alumno no fue encontrado o no existe"), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Mensaje> eliminar(@PathVariable Long id) {
		Boolean existeAlumno = service.exitePorId(id);
		if(existeAlumno) {
			service.eliminar(id);
			return new ResponseEntity<Mensaje>(new Mensaje("Alumno eliminado con exito"), HttpStatus.OK);
		} else {
			return new ResponseEntity<Mensaje>(new Mensaje("Alumno no fue encontrado o no existe"), HttpStatus.NOT_FOUND);
		}
	}
	
}
