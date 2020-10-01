package br.com.kiev.maonafrota.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kiev.maonafrota.domain.veiculo.Veiculo;
import br.com.kiev.maonafrota.domain.veiculo.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public void saveVeiculo(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}
	
}
