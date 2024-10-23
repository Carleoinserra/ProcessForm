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
		
		// creiamo una stringa
		String nome = "Carlo";
		
		
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
	
	
	
	

}
