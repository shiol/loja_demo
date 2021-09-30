package com.shiol.loja;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProdutoRepository extends JpaRepository<Produto, Long> {
}