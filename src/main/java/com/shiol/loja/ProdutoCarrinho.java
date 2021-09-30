package com.shiol.loja;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProdutoCarrinho {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Carrinho carrinho;
	@OneToOne
	private Produto produto;
	private int quantidade;
	private BigDecimal preco;

	ProdutoCarrinho() {
	}

	public ProdutoCarrinho(Long id, Carrinho carrinho, Produto produto, int quantidade, BigDecimal preco) {
		super();
		this.id = id;
		this.carrinho = carrinho;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
