package com.model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	
	
	String driver ="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cadatrodeclientes?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "@Heavengeo7789*";
	
	//metodo de conexao 
	public Connection conectar() {
		
		Connection conectar = null;
		
		try {
			Class.forName(driver);
			conectar = DriverManager.getConnection(url,user,password);
			
			return conectar;
		}catch(Exception e) {
			e.getStackTrace();
			System.out.println(e);
			return null;
		}
	
	}
	
	public void create(Cliente cliente) {
		
		String create = "INSERT INTO cadastro_cliente ( nome, endereco, valor_contrato, ativo)"+
		" VALUES(?,?,?,?)";
		
		try {
			
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			
			
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEndereco());
			pst.setBigDecimal(3, cliente.getValorContrato());
			pst.setBoolean(4, true);
			
			pst.executeUpdate();
			pst.close();
			
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
	
	public List<Cliente> read(){
		
		List<Cliente> listClientes = new ArrayList<Cliente>();
		
		String read = "select *from cadastro_cliente order by id";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String endereco = rs.getString(3);
				BigDecimal valorContrato = rs.getBigDecimal(4);
				boolean ativo = rs.getBoolean(5);
				
				
				listClientes.add(new Cliente(id, nome, endereco, valorContrato, ativo));
				
			}
			
			con.close();
			return listClientes;
			
		}catch(Exception e) {
			e.getStackTrace();
			return null;
		}
		
		
	}
	

}
