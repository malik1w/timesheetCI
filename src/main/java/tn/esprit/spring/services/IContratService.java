package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;


public interface IContratService {
	
	
	public List<Contrat> getAllContrats();
	public Contrat addOrUpdateCont(Contrat c); 
	public void deleteContratById(int contId);

	
	
	

	
}
