package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClienteDAO {
	
	
	String driver ="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cadatrodeclientes?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "root";
	
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
	

}
