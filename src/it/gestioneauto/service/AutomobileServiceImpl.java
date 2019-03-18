package it.gestioneauto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.gestioneauto.dao.AutomobileDAO;
import it.gestioneauto.model.Automobile;

@Component
public class AutomobileServiceImpl implements AutomobileService {

	@Autowired
	private AutomobileDAO automobileDAO;

	@Transactional(readOnly = true)
	public Automobile caricaSingolaAutomobile(long idAutomobileInput) {
		return automobileDAO.get(idAutomobileInput);
	}

	@Transactional(readOnly = true)
	public List<Automobile> listTutteLeAutomobili() {
		return automobileDAO.list();
	}

	@Transactional
	public void aggiorna(Automobile automobileInstance) {
		automobileDAO.update(automobileInstance);
	}

	@Transactional
	public void inserisciNuova(Automobile automobileInstance) {
		automobileDAO.insert(automobileInstance);
	}

	@Transactional
	public void rimuovi(Automobile automobileInstance) {
		automobileDAO.delete(automobileInstance);
	}
	
	@Transactional(readOnly = true)
	public List<Automobile> cercaAutomobileByExample(Automobile example) {
		return automobileDAO.findByExample(example);
	}

}
