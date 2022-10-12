package idat.edu.pe.c6.sw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.c6.sw2.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	Boolean existsByIdAlumno(Long idAlumno);
}
