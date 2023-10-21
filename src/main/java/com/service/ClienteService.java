package com.service;

import java.util.List;

import com.model.Cliente;

public interface ClienteService {

	void create(Cliente cliente);
	List<Cliente> findAll();
	void findById(Integer id);
	void update(Integer id);
	void delete(Cliente cliente);
}
