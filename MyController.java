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
		lista.add(new person("Mario", "Bianchi", "dip1.jpeg", 1100));
		lista.add(new person("Franco", "Gialli", "dip2.jpeg", 2050));
		lista.add(new person("Antonella", "Viola", "dip2.jpeg", 3000));
		
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
		
		person p1 = new person(nome, cognome, url, 2000);
		
		lista.add(p1);
		
		m1.addAttribute("persona", p1);
		
		return("stampa");
		
		
	}
	
	@GetMapping("/lista")
	public String getLista(Model m1) {
		
		m1.addAttribute("lista", lista);
		
		// azzerriamo listaS
		
				listaS.removeAll(listaS);
		
		return ("stampaL");
		
		
	}
	
	ArrayList <personSelect> listaS = new ArrayList <>();
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
 * Istanziamo il nuovo ArrayList di personSelect con un nuovo oggetto che ha come caratteristiche
 * il cognome, la url, lo stipendio, e il numero di volte che è stato selezionato
 * istanziamo una variabile somma con il valore dello stipendio per il numero di volte che è statp selezionato
 * 
 */
		
		
int somma = 0;
for (int i = 0; i < nomi.size(); i++) {
	// solo se l'utente ha selezionato quel dipendente un numero di volte maggiore di 0
	if (numeri.get(i) > 0) {
		
		System.out.println("Hai selezionato: " + nomi.get(i));
		System.out.println(numeri.get(i) + " volte");
		
		System.out.println("Il dipendente " + lista.get(i).nome
				+ " ha uno stipendio di "  + lista.get(i).stipendio);
		// la somma viene calcolata moltiplicando lo stipendio del dipendente selezionato con la quantità
		somma += numeri.get(i) * lista.get(i).stipendio;
		// creiamo una nuova personSelect con i dati e la aggiungiamo a listaS
		listaS.add(new personSelect(lista.get(i).cognome, lista.get(i).url, lista.get(i).stipendio, numeri.get(i)));
		
	}
}
// stampiamo la somma
System.out.println("La somma degli stipendi è: " + somma + " euro");
		/*
		 * Nel model passiamo sia listaS che la somma
		 */
		m1.addAttribute("somma", somma);
		m1.addAttribute("lista", listaS);
		
		
		
		return("recap");
		
		
	}
	
	@GetMapping("/getLista")
	@ResponseBody
	public ArrayList<person> getLista(){
		
		return lista;
	}
	
	
	
	

}
