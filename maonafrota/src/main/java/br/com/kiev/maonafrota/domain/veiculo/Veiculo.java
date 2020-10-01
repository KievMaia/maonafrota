package br.com.kiev.maonafrota.domain.veiculo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "A placa não pode estar vazio!")
	@Size(max = 7)
	private String placa;
	
	@NotBlank(message = "O RENAVAN não pode estar vazio!")
	@Size(max = 20)
	private String renavam;
	
	@NotBlank(message = "O chassi não pode estar vazio!")
	private String chassi;
	
	private String combustivel;
		
	@NotNull(message = "A quilometragem não pode estar vazia!")
	private BigDecimal quilometragem;
	
	@NotBlank(message = "A marca/modelo não pode estar vazio!")
	private String marcaModelo;
	
	private String foto;
	
	@NotBlank(message = "O ano de fabricação não pode estar vazio!")
	private String anoFabricacao;
	
	@NotBlank(message = "O ano do modelo não pode estar vazio!")
	private String anoModelo;
	
	@NotBlank(message = "A cor não pode estar vazia!")
	private String cor;
}
