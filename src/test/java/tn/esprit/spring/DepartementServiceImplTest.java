package tn.esprit.spring;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;


import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.IDepartementService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DepartementServiceImplTest {

	@Autowired 
	IDepartementService deps; 
	@Test
	public void testGetAllDepartements() {
		// if there are 2 departements in DB : 
		Assertions.assertFalse(deps.getAllDepartements().isEmpty());
		//assertEquals(2, deps.getAllDepartements().size());
	}

	@Test
	public void testAddOrUpdateDep() {
		Departement d = new Departement("FinanceTest"); 
	    Departement addDept = deps.addOrUpdateDep(d);
	    assertEquals(d.getName(), addDept.getName());	}

	@Test
	public void testDeleteDepartementById() {
		Departement d = new Departement("FinanceTest"); 
	    deps.addOrUpdateDep(d);
	    assertNotNull(d);
	    deps.deleteDepartementById(d.getId());
	}

}
