package persistencia.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Jefe")
public class JefeInmediatoEntidad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name = "jefes_cargo",joinColumns = @JoinColumn(name = "jefe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cargo_id", referencedColumnName = "id"))
	private Set<CargoEntidad> cargo =new HashSet<>();

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Set<CargoEntidad> getCargo() {
		return cargo;
	}
	
	
	
}
	
