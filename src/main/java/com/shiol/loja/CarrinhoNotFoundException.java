package com.shiol.loja;

public class CarrinhoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	CarrinhoNotFoundException(Long id) {
		super("Não pode achar carrinho " + id);
	}
}
