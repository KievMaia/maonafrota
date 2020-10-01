package br.com.kiev.maonafrota.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kiev.maonafrota.domain.condutor.Condutor;
import br.com.kiev.maonafrota.domain.condutor.CondutorRepository;

@Service
public class CondutorService {

	@Autowired
	private CondutorRepository condutorRepository;
	
	public void saveCondutor(Condutor condutor) throws ValidationException{
		
		if (!validateMatricula(condutor.getMatricula(), condutor.getId())) {
			throw new ValidationException("A matrícula está duplicada!");
		}
		
		condutorRepository.save(condutor);
	}
	
	private boolean validateMatricula(String matricula, Integer id) {
		Condutor condutor = condutorRepository.findByMatricula(matricula);
		
		if (condutor != null) {
			if (id == null) {
				return false;
			}
			
			if (!condutor.getId().equals(id)) {
				return false;
			}
		}
		
		return true;
	}
}
