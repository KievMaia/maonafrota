package br.com.kiev.maonafrota.domain.condutor;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Condutor implements Serializable{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "A matrícula não pode estar vazia!")
	private String matricula;
	
	@NotBlank(message = "O nome não pode estar vazio!")
	@Size(max = 80, message = "O nome é muito grande!")
	private String nome;
	
	@NotBlank(message = "O e-mail não pode estar vazio!")
	@Size(max = 60, message = "O e-mail é muito grande!")
	@Email(message = "O e-mail é inválido!")
	private String email;
	
	@NotBlank(message = "O telefone não pode estar vazio!")
	@Pattern(regexp = "[0-9]{10,11}", message = "O telefone possui formato inválido")
	@Column(length = 11, nullable = false)
	private String telefone;
	
	@NotBlank(message = "O RG não pode estar vazio!")
	private String rg;
	
	@NotBlank(message = "O CPF não pode estar vazio!")
	@Pattern(regexp = "[0-9]{11}", message = "O CPF possui formato inválido")
	@Column(length = 11, nullable = false)
	private String cpf;
	
	@NotNull(message = "A data de nascimento não pode estar vazia!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNascimento;
	
	@NotBlank(message = "O CNH não pode estar vazio!")
	private String cnh;
	
	@NotNull(message = "A validade da CNH não pode estar vazia!")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate validadeCnh;
	
	@NotBlank(message = "A senha não pode estar vazia!")
	@Size(max = 80, message = "A senha é muito grande!")
	private String senha;
	
}