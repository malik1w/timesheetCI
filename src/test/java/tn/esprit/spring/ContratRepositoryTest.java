package tn.esprit.spring;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;
@RunWith(SpringRunner.class)
@SpringBootTest

public class ContratRepositoryTest {
	@Autowired 

	IContratService conts;
	@Test

	public void testGetAllContrats() {
		// si il ya 2 contrat dans la base :
		assertEquals(2, conts.getAllContrats().size());
	}

	@Test
	public void testAddOrUpdateCont() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-02-10");
		String typeContrat="cdi";
		float salaire=12;
		Contrat c = new Contrat(d,typeContrat,salaire); 
		Contrat addCont = conts.addOrUpdateCont(c);
	    assertEquals(addCont.getTypeContrat(), c.getTypeContrat());	
		}

	@Test
	public void testDeleteContratById() throws Exception  {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-02-04");
		String typeContrat="cdi";
		float salaire=12;
		Contrat c = new Contrat(d,typeContrat,salaire); 

		conts.addOrUpdateCont(c);
	    assertNotNull(c);
	    conts.deleteContratById(c.getReference());
	    		
	}

}

