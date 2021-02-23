package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	@Autowired
	DepartementRepository deptRepository;

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	public List<Departement> getAllDepartements() {
		l.info("In  retrieveAllDepts : "); 
		List<Departement> listDept = (List<Departement>) deptRepository.findAll();
		for (Departement deps : listDept) {
			l.debug("deps +++ : " + deps);
		}
		l.info(" all deps retrieved");
		return listDept;
	}

	@Override
	public Departement addOrUpdateDep(Departement d) {
		l.info("in add dept : "+ d);
		Departement dept = deptRepository.save(d);
		l.info(d+"added");

		return dept;
	}
	
	@Override
	public void deleteDepartementById(int depId) {
		deptRepository.delete(deptRepository.findById(depId).get());	
	
	}

	

}
