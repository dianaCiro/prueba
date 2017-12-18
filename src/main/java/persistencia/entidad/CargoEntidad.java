package persistencia.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Cargo")
public class CargoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	@Column
	private String nombre;	
	
	@JsonIgnore
	@ManyToMany(mappedBy="cargo")
	private Set<JefeInmediatoEntidad> jefes=new HashSet<>();

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Set<JefeInmediatoEntidad> getJefes() {
		return jefes;
	}
	
	
	

}
