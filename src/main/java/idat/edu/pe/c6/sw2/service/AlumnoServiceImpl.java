package idat.edu.pe.c6.sw2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.c6.sw2.model.Alumno;
import idat.edu.pe.c6.sw2.repository.AlumnoRepository;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {
	@Autowired
	private AlumnoRepository repository;

	@Override
	public void guardar(Alumno alumno) {
		// TODO Auto-generated method stub
		repository.save(alumno);
	}

	@Override
	public void actualizar(Long id, Alumno alumno) {
		// TODO Auto-generated method stub
		alumno.setIdAlumno(id);
		repository.save(alumno);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Alumno porId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public Boolean exitePorId(Long id) {
		// TODO Auto-generated method stub
		return repository.existsByIdAlumno(id);
	}

}
