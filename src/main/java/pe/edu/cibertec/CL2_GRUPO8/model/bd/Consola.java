package pe.edu.cibertec.CL2_GRUPO8.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_console")
public class Consola {
	
	@Id
	private Integer id_console;
	@Column(name = "name_console")
	private String name_console;
	@Column(name = "description")
	private String description;
	

}
