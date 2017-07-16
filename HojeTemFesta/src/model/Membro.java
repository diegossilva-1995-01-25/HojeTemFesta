package model;

/*
 * Autor: Diego Souza Silva
 * Data: 28/06/2017
 */

public class Membro {
	
	private int idMembro;
	private String nome;
	private String apelido;
	private String sobrenomes;
	private String cargo;
	private int dia;
	private int mes;
	private int ano;
	
	public int getIdMembro() {
		return idMembro;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public String getSobrenomes() {
		return sobrenomes;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setIdMembro(int idMembro) {
		this.idMembro = idMembro;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public void setSobrenomes(String sobrenomes) {
		this.sobrenomes = sobrenomes;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
