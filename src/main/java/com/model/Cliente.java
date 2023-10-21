package com.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String endereco;
	private BigDecimal valorContrato;
	private boolean ativo;
	
	
	public Cliente() {
		
	}


	public Cliente(Integer id, String nome, String endereco, BigDecimal valorContrato, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.valorContrato = valorContrato;
		this.ativo = ativo;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public BigDecimal getValorContrato() {
		return valorContrato;
	}


	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
