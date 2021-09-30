package com.shiol.loja;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrinho {
	@Id
	@GeneratedValue
	private Long id;
	private BigDecimal total;
	@OneToMany(fetch = FetchType.LAZY)
	private List<ProdutoCarrinho> produtos;

	Carrinho() {
	}

	public Carrinho(Long id, BigDecimal total, List<ProdutoCarrinho> produtos) {
		super();
		this.id = id;
		this.total = total;
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ProdutoCarrinho> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoCarrinho> produtos) {
		this.produtos = produtos;
	}

}
