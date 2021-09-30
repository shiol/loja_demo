package com.shiol.loja;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarrinhoController {
	private final CarrinhoRepository repository;

	public CarrinhoController(CarrinhoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/carrinhos")
	List<Carrinho> all() {
		return repository.findAll();
	}

	@GetMapping("/carrinhos/{id}")
	Carrinho one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new CarrinhoNotFoundException(id));
	}

	@PostMapping("/carrinhos")
	Carrinho newCarrinho(@RequestBody Carrinho newCarrinho) {
		return repository.save(newCarrinho);
	}

	@PutMapping("/carrinhos/{id}")
	Carrinho replaceCarrinho(@RequestBody Carrinho newCarrinho, @PathVariable Long id) {

		return repository.findById(id).map(carrinho -> {
			carrinho.setProdutos(newCarrinho.getProdutos());
			carrinho.setTotal(newCarrinho.getTotal());
			return repository.save(carrinho);
		}).orElseGet(() -> {
			newCarrinho.setId(id);
			return repository.save(newCarrinho);
		});
	}

	@DeleteMapping("/carrinhos/{id}")
	void deleteCarrinho(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
