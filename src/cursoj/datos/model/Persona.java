
package cursoj.datos.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "PERSONA")  //,schema="CURSOJ"
@Entity
public class Persona implements Serializable {	

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@Column(name = "name", nullable = false, unique=true, length=250)
	private String name;

	@Column(name = "grupo", nullable = false, unique=true, length=1)
	private String grupo;
	
	@Column(name="sueldo", updatable=false, precision=10, scale=3)
	private BigDecimal sueldo;
	
	
	//getters and setters
	//........................................................................
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
