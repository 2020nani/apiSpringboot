package com.api.digitalbank.models;

import javax.persistence.*;


@Entity
@Table(name= "endereco")
public class Endereco {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long codigo;
@Column(length= 255, nullable = false)
 private String rua;

@Column(length= 6, nullable = false)
 private Integer numero;

@Column(length= 255, nullable = false)
 private String complemento;

@Column(length= 255, nullable = false)
 private String bairro;

@Column(length= 255, nullable = false)
 private String cidade;

@Column(length= 2, nullable = false)
 private String estado;
 
 @ManyToOne
 @JoinColumn(name = "codigo_pessoa")
private Pessoa pessoa;
  
 
public Pessoa getPessoa() {
	return pessoa;
}
public void setPessoa(Pessoa pessoa) {
	this.pessoa = pessoa;
}
public Long getCodigo() {
	return codigo;
}
public void setCodigo(Long codigo) {
	this.codigo = codigo;
}
public String getRua() {
	return rua;
}
public void setRua(String rua) {
	this.rua = rua;
}
public Integer getNumero() {
	return numero;
}
public void setNumero(Integer numero) {
	this.numero = numero;
}
public String getComplemento() {
	return complemento;
}
public void setComplemento(String complemento) {
	this.complemento = complemento;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public String getCidade() {
	return cidade;
}
public void setCidade(String cidade) {
	this.cidade = cidade;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Endereco other = (Endereco) obj;
	if (codigo == null) {
		if (other.codigo != null)
			return false;
	} else if (!codigo.equals(other.codigo))
		return false;
	return true;
}


 
}
