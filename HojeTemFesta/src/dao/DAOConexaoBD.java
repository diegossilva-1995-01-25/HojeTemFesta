package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/*
 * Autor: Diego Souza Silva
 * Data: 28/06/2017
 */

public class DAOConexaoBD {
	
	private static Connection conexao;
	private static DAOConexaoBD instanciaConexao;
	
	private DAOConexaoBD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/hojetemfesta",
					"root", "pastorluizbiro14"); //senha);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro interno no programa!\n" +
					e.getMessage());
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no Banco de Dados!\n" +
					e.getMessage());
		}
		
	}
	
	public synchronized static DAOConexaoBD instanciarDAO() {
		
		if(instanciaConexao == null) {
			instanciaConexao = new DAOConexaoBD();
		}
		
		return instanciaConexao;
	}
	
	public Connection obterConexao() {		
		return conexao;
	}
	
}
