package com.shiol.loja;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

}

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

		return repository.findById(id).map(employee -> {
			employee.setDescricao(newProduto.getDescricao());
			employee.setPreco(newProduto.getPreco());
			return repository.save(employee);
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

class ProdutoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	ProdutoNotFoundException(Long id) {
		super("Não pode achar produto " + id);
	}
}

interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

@Entity
class Produto {
	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private BigDecimal preco;

	Produto() {
	}

	Produto(String descricao, BigDecimal preco) {

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