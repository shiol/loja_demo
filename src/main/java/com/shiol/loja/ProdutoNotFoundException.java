package com.shiol.loja;

class ProdutoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	ProdutoNotFoundException(Long id) {
		super("Não pode achar produto " + id);
	}
}