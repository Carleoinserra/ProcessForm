package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * Mappiamo la classe MyController con l'annotazione Controller
 */
@Controller
public class MyController {
	
	
	// creiamo un arrayList di persona
	ArrayList <person> lista = new ArrayList<>();
	
	
	
	
	/*
	 * L'applicazione alla chiamata get verso localhost:8080
	 * risponderà con il file index
	 */
	@GetMapping("/")
	public String getIndex(Model m1) {
		
		lista.removeAll(lista);
		
		
		// creiamo una stringa
		String nome = "Carlo";
		lista.add(new person("Mario", "Bianchi", "dip1.jpeg"));
		lista.add(new person("Franco", "Gialli", "dip2.jpeg"));
		
		/*
		 * La passiamo al model con la dicitura nome
		 * assegniamo alla variabile nome il suo valore
		 */
		m1.addAttribute("nome", nome);
		
		return "index";
	}
	/*
	 * L'applicazione alla chiamata get verso localhost:8080/contact
	 * risponderà con il file contact
	 */
	@GetMapping("/contact")
	public String getContact(Model m1) {
		
		String giorno = "Martedì";
		
		m1.addAttribute("giorno", giorno);
		return "contact";
	}
	/*
	 * L'applicazione alla chiamata get verso localhost:8080/blog
	 * risponderà con il file blog
	 */
	@GetMapping("/blog")
	public String getBlog(Model m1) {
		
		ArrayList <String> colori = new ArrayList <>();
		colori.add("Rosso");
		colori.add("Verde");
		colori.add("bianco");
		
		
		//passiamo la lista al file blog.html
		m1.addAttribute("lista", colori);
		
 		
		
		return "blog";
	}
	
	@GetMapping("/risp")
	@ResponseBody
	public String getRirsp() {
		
		return ("Response body");
	}
	/*
	 * Creimao una rotta che ritorna un form html
	 */
	@GetMapping("/form")
	public String getForm() {
		
		return("form");
	}
	/*
	 * andiamo a recuperare i dati dal form e con requestParam recuperiamo gli input di tipe text
	 * questo metodo va a recuperare i dati dal form con requestParam (in questo caso recuperiamo i dati dal name)
	 * Creimao una nuova persona
	 * la passiamo al model
	 */
	@PostMapping("/submit")
	public String getDati(@RequestParam("nome") String nome, 
			@RequestParam("cognome") String cognome,
			@RequestParam("url") String url,
			
			Model m1) {
		
		//System.out.println(nome);
		//System.out.println(cognome);
		
		person p1 = new person(nome, cognome, url);
		
		lista.add(p1);
		
		m1.addAttribute("persona", p1);
		
		return("stampa");
		
		
	}
	
	@GetMapping("/lista")
	public String getLista(Model m1) {
		
		m1.addAttribute("lista", lista);
		
		return ("stampaL");
	}
	/*
	 * 
	 * Siamo andati a processare il form che abbiamo creato ne stampaL
	 * da quel form selezioniamo tutti i nomi dei dipedenti che ci vengono trasferiti nell'arraylist nomi
	 * selezioniamo il numero dei dipedenti che sono stati scelti che ci vengono trasferiti nell'array numeri
	 */
	@PostMapping("/process")
	public String getDipendenti(@RequestParam("nome") ArrayList<String> nomi, 
			@RequestParam("num") ArrayList<Integer> numeri,
			//@RequestParam("url") String url,
			
			Model m1) {
		
		//System.out.println(nome);
		//System.out.println(cognome);
		
	
/*
 * Andiamo a iterare l'array nomi che ha lo stesso indice di numeri
 * se il numero è diverso da zero (cioè se sono stati selezionati più dipendenti)
 * Stampiamo il nome del dipedente selezionato
 * il numero di dipedenti ad esso associato
 */
for (int i = 0; i < nomi.size(); i++) {
	
	if (numeri.get(i) != 0) {
		
		System.out.println("Hai selezionato: " + nomi.get(i));
		System.out.println(numeri.get(i) + " volte");
		
	}
}
		
		
		
		
		
		return("stampaL");
		
		
	}
	
	
	
	

}
