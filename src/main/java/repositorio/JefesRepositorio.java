package repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import persistencia.entidad.JefeInmediatoEntidad;

@Repository
public interface JefesRepositorio extends JpaRepository<JefeInmediatoEntidad, Integer> {

}
