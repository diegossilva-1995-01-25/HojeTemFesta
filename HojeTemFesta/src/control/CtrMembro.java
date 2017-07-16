package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.DAOConexaoBD;
import interfaces.Buscavel;
import model.Membro;

/*
 * Autor: Diego Souza Silva
 * Data: 28/06/2017
 */

public class CtrMembro implements Buscavel, TableModel {
	private Membro membro;
	private List<Membro> listaDeMembros;
	private Connection conex;
	
	public CtrMembro() {
		listaDeMembros = new ArrayList<>();
		conex = DAOConexaoBD.instanciarDAO().obterConexao();
	}
	
	public void adicionarMembro(Membro m) {
		String sql = "INSERT INTO membro (nome, apelido, sobrenomes, cargo, dia, mes, ano)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparado = conex.prepareStatement(sql);
			//preparado.setInt(1, m.getIdMembro());
			preparado.setString(1, m.getNome());
			preparado.setString(2, m.getApelido());
			preparado.setString(3, m.getSobrenomes());
			preparado.setString(4, m.getCargo());
			preparado.setInt(5, m.getDia());
			preparado.setInt(6, m.getMes());
			preparado.setInt(7, m.getAno());
			preparado.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro de Banco de Dados:\n" + e.getMessage());
		}
		
		
	}
	
	public void alterarMembro(Membro m) {
		String sql = "UPDATE membro SET id = ?, nome = ?, apelido = ?, sobrenomes = ?, cargo = ?,"
				+ " dia = ?, mes = ?, ano = ? WHERE id = ?";
		
		try {
			PreparedStatement preparado = conex.prepareStatement(sql);
			preparado.setInt(1, m.getIdMembro());
			preparado.setString(2, m.getNome());
			preparado.setString(3, m.getApelido());
			preparado.setString(4, m.getSobrenomes());
			preparado.setString(5, m.getCargo());
			preparado.setInt(6, m.getDia());
			preparado.setInt(7, m.getMes());
			preparado.setInt(8, m.getAno());
			preparado.setInt(9, m.getIdMembro());
			preparado.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro de Banco de Dados:\n" + e.getMessage());
		}
	}
	
	// Modelo de consulta (por nome, ordenado por id)
	@Override
	public List<Membro> consultarMembro(String entrada) {
		// TODO Auto-generated method stub
		listaDeMembros = new ArrayList<>();
		String sql = "SELECT * FROM membro where nome LIKE ? ORDER BY id ASC";
		
		try {
			PreparedStatement preparado = conex.prepareStatement(sql);
			preparado.setString(1, "%" + entrada + "%");
			ResultSet todos = preparado.executeQuery();
			
			while(todos.next()) {
				
				membro = new Membro();
				
				membro.setIdMembro(todos.getInt("id"));
				membro.setNome(todos.getString("nome"));
				membro.setApelido(todos.getString("apelido"));
				membro.setSobrenomes(todos.getString("sobrenomes"));
				membro.setCargo(todos.getString("cargo"));
				membro.setDia(todos.getInt("dia"));
				membro.setMes(todos.getInt("mes"));
				membro.setAno(todos.getInt("ano"));
				listaDeMembros.add(membro);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro de Banco de Dados:\n" + e.getMessage());
		}
		
		
		return listaDeMembros;
		
	}

	public void excluirMembro(Membro m) {
		String sql = "DELETE FROM membro WHERE id = ?";
		
		try {
			PreparedStatement preparado = conex.prepareStatement(sql);
			preparado.setInt(1, m.getIdMembro());
			preparado.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro de Banco de Dados:\n" + e.getMessage());
		}
		
	}

	// Acionado diariamento, somente implemente o desta classe
	// Esta classe implementa o pop-up a ser visto na view.
	@Override
	public List<Membro> buscarAniversariantes(String entrada) {
		// TODO Auto-generated method stub
		String[] partesData = new String[3];
		partesData = entrada.split("/");
		listaDeMembros = new ArrayList<>();
		String sql = "SELECT * FROM membro where mes = ? AND dia = ?"
				+ " ORDER BY ano, mes, dia ASC";
		
		try {
			PreparedStatement preparado = conex.prepareStatement(sql);
			preparado.setInt(1, Integer.parseInt(partesData[1]));
			preparado.setInt(2, Integer.parseInt(partesData[0]));
			ResultSet todos = preparado.executeQuery();
			
			while(todos.next()) {
				
				membro = new Membro();
				
				membro.setIdMembro(todos.getInt("id"));
				membro.setNome(todos.getString("nome"));
				membro.setApelido(todos.getString("apelido"));
				membro.setSobrenomes(todos.getString("sobrenomes"));
				membro.setCargo(todos.getString("cargo"));
				membro.setDia(todos.getInt("dia"));
				membro.setMes(todos.getInt("mes"));
				membro.setAno(todos.getInt("ano"));
				listaDeMembros.add(membro);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro de Banco de Dados:\n" + e.getMessage());
		}
		
		
		return listaDeMembros;
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		
			case 0: return Integer.class;
			case 1: return String.class;
			case 2: return String.class;
			case 3: return String.class;
			case 4: return String.class;
			case 5: return Integer.class;
			case 6: return Integer.class;
			case 7: return Integer.class;
		}

		return String.class;
	
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
			
			case 0: return "id";
			case 1: return "nome";
			case 2: return "apelido";
			case 3: return "sobrenomes";
			case 4: return "cargo";
			case 5: return "dia";
			case 6: return "mes";
			case 7: return "ano";
		}
	
		return "";
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaDeMembros.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Membro m = listaDeMembros.get(rowIndex);
		
		switch (columnIndex) {
		
			case 0: return m.getIdMembro();
			case 1: return m.getNome();
			case 2: return m.getApelido();
			case 3: return m.getSobrenomes();
			case 4: return m.getCargo();
			case 5: return m.getDia();
			case 6: return m.getMes();
			case 7: return m.getAno();
		}
	
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	public Membro retornarLinhaEscolhida(int linha) {
		return listaDeMembros.get(linha);
	}
	
	public int ultimoInserido() {
		int ultimoId = 0;
		
		String sql =  "select max(id) from membro";
		
		try {
			Statement preparado = conex.createStatement();
			ResultSet resultado = preparado.executeQuery(sql);
			while(resultado.next()) {
				ultimoId = resultado.getInt("max(id)");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			ultimoId = 0;
		}
		
		return ultimoId;
		
	}
	
}
