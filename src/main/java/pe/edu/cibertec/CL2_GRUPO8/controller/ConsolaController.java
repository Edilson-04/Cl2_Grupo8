package pe.edu.cibertec.CL2_GRUPO8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.CL2_GRUPO8.model.bd.Consola;
import pe.edu.cibertec.CL2_GRUPO8.model.request.ConsolaRequest;
import pe.edu.cibertec.CL2_GRUPO8.service.ConsolaService;
import pe.edu.cibertec.cl2grupo8.model.request.ConsoleRequest;
import pe.edu.cibertec.cl2grupo8.model.response.ResultadoResponse;

@Controller
@RequestMapping("/consola")
public class ConsolaController {

	
	@Autowired
	private ConsolaService consolaService;
	
	@GetMapping("/frmconsola")
	public String frmconsola(Model model) {
		model.addAttribute("lstConsolas", consolaService.listarConsola());
		return "consola/frmconsola";
	}
	
	
	@PostMapping("/registrarConsola")
	@ResponseBody
	public ResultadoResponse registrarCategoria(@RequestBody ConsolaRequest consolaRequest) 
	{
		String mensaje ="Consola registrada correctamente";
		Boolean respuesta = true;
		try 
		{
			Consola objconsola = new Consola();
			if(consolaRequest.getId_console() > 0) {objconsola.setId_console(consolaRequest.getId_console());}
			//Se registrar el id porque no es autogenerado
			objconsola.setId_console(consolaRequest.getId_console());
			objconsola.setName_console(consolaRequest.getName_console());
			objconsola.setDescription(consolaRequest.getDescription());
			consolaService.registrarConsola(objconsola);
		}
		catch(Exception ex)
		{
			mensaje = "No se pudo registrar la Consola";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	
	@DeleteMapping("/eliminarConsola")
	@ResponseBody
	public ResultadoResponse eliminarCategoria(@RequestBody ConsolaRequest consolaRequest)
	{
		String mensaje = "Consola eliminada correctamente";
		Boolean respuesta = true;
		try 
		{
			consolaService.eliminarConsola(consolaRequest.getId_console());
		}
		catch(Exception e) 
		{
			mensaje = "Consola no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarConsolas")
	@ResponseBody
	public List<Consola>listarConsolas(){
		return consolaService.listarConsola();
	}
	
	
	
	
	
	
	
	
}
