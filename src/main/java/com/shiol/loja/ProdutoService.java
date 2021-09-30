package com.shiol.loja;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoService {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Produto get(Long id) {
		String queryString = "SELECT p FROM Produto AS p WHERE p.id = :id";
		return (Produto) getSession().createQuery(queryString).setParameter("id", id).uniqueResult();
	}
}
