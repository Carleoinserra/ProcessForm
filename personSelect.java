package com.example.demo;
/*
 * La classe persona Select ci serve per indicare quale e quante persone sono state selezionate
 * dall'utente nel form di stampaL.html
 * Rispetto alla classe person semplice ha infatti la prorpeità qnt che indica quante persone
 * sono state selezionate
 * 
 * 
 */
public class personSelect {
	
	public String cognome;
	public String url;
	public int stipendio;
	public int qnt;
	public personSelect(String cognome, String url, int stipendio, int qnt) {
		super();
		this.cognome = cognome;
		this.url = url;
		this.stipendio = stipendio;
		this.qnt = qnt;
	}
	
	
	

}
