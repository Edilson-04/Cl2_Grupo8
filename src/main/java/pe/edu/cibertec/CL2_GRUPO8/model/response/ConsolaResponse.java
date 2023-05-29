package pe.edu.cibertec.CL2_GRUPO8.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsolaResponse {

	private Boolean respuesta;
	private String mensaje; 

	
}
