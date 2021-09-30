package com.shiol.loja;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
class Produto {
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private BigDecimal preco;

	Produto() {
	}

	Produto(String descricao, BigDecimal preco, Carrinho carrinho) {
		super();
		this.descricao = descricao;
		this.preco = preco;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}