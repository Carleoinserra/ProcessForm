package com.example.demo;


/*
 * Abbiamo creato una classe persona che ci serve all'interno dell'applicazione
 * questa persona ha due proprietà che sono nome e cognome
 */
public class persona {
	
	String nome;
	String cognome;
	String url;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "persona [nome=" + nome + ", cognome=" + cognome + "]";
	}
	public persona(String nome, String cognome, String url) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.url = url;
	}
	

}
