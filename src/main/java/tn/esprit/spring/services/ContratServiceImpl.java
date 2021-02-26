package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	@Autowired
	ContratRepository contratRepository;

	public List<Contrat> getAllContrats() {
		l.info("In  retrieveAllContrats : ");
		List<Contrat> listCont = (List<Contrat>) contratRepository.findAll();
		for (Contrat cont : listCont) {
			l.debug("deps +++ : " + cont);
		}
		l.info(" all contrat retrieved");
		return listCont;
	}

	@Override

	public Contrat addOrUpdateCont(Contrat c) {
		l.info("in add cont : " + c);
		Contrat cont = contratRepository.save(c);
		l.info(c + "added");
		return cont;
	}

	@Override
	public void deleteContratById(int contId) {
		l.info("delted contrat id : " + contId);
		contratRepository.delete(contratRepository.findById(contId).get());

	}

}
