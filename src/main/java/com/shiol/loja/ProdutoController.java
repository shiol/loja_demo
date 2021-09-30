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
class ProdutoController {
	private final ProdutoRepository repository;

	ProdutoController(ProdutoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/produtos")
	List<Produto> all() {
		return repository.findAll();
	}

	@GetMapping("/produtos/{id}")
	Produto one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
	}

	@PostMapping("/produtos")
	Produto newProduto(@RequestBody Produto newProduto) {
		return repository.save(newProduto);
	}

	@PutMapping("/produtos/{id}")
	Produto replaceProduto(@RequestBody Produto newProduto, @PathVariable Long id) {

		return repository.findById(id).map(produto -> {
			produto.setDescricao(newProduto.getDescricao());
			produto.setPreco(newProduto.getPreco());
			return repository.save(produto);
		}).orElseGet(() -> {
			newProduto.setId(id);
			return repository.save(newProduto);
		});
	}

	@DeleteMapping("/produtos/{id}")
	void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}
}