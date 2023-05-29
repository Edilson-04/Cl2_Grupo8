package pe.edu.cibertec.CL2_GRUPO8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.CL2_GRUPO8.model.bd.Consola;
import pe.edu.cibertec.CL2_GRUPO8.repository.ConsolaRepository;


@Service
public class ConsolaService {
	
	@Autowired
	private ConsolaRepository consolaRepository;
	
	public List<Consola> listarConsola(){
		return consolaRepository.findAll();
	}
	
	
	public void registrarConsola(Consola consola) {
		consolaRepository.save(consola);
	}
	
	public void eliminarConsola(Integer idconsole) {
		consolaRepository.deleteById(idconsole);
	}
	

}
