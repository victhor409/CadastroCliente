package com.service;

import java.util.List;

import com.model.Cliente;
import com.model.ClienteDAO;

public class ClienteServiceImpl implements ClienteService{
	
	
	 ClienteDAO dao = new ClienteDAO();
	
	

	@Override
	public void create(Cliente cliente) {
		
		try {
			dao.create(cliente);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}

	@Override
	public List<Cliente> findAll() {
	
		return null;
	}

	@Override
	public void findById(Integer id) {
		
		
	}

	@Override
	public void update(Integer id) {
		
		
	}

	@Override
	public void delete(Cliente cliente) {
		
		
	}

}
