package it.gestioneauto.service;

import java.util.List;

import it.gestioneauto.model.Automobile;

public interface AutomobileService {
	
	public Automobile caricaSingolaAutomobile(long idPersonaInput);
	
	public List<Automobile> listTutteLeAutomobili();

	public void aggiorna(Automobile automobileInstance);

	public void inserisciNuova(Automobile automobileInstance);

	public void rimuovi(Automobile automobileInstance);
	
	public List<Automobile> cercaAutomobileByExample(Automobile example);
}
