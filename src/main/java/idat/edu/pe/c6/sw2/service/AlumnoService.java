package idat.edu.pe.c6.sw2.service;

import java.util.List;

import idat.edu.pe.c6.sw2.model.Alumno;

public interface AlumnoService {
	void guardar(Alumno alumno);
	void actualizar(Long id, Alumno alumno);
	void eliminar(Long id);
	List<Alumno> listar();
	Alumno porId(Long id);
	Boolean exitePorId(Long id);
}
