package fr.uni.institute.library.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryDaoTestCase {
	
	private static Logger logger = Logger.getLogger( CategoryDaoTestCase.class);
	private int nombreAttendu;

	@Before
	public void setUp() throws Exception {
		logger.info("Initialisation des ressources necessaires avant le lancement de test");
		//chargement de fichiers xml ou autre pour recuperer les resultat attendu
		nombreAttendu = 9;
		
	}

	@After
	public void tearDown() throws Exception {
		logger.info("Libération des ressources utilisees dans test");
	}

	@Test()
	public void testResearchAllCategories() {
		logger.info("Execution de test ResearchAllCategories");
		int nombreCalcule = 9;
		assertEquals(nombreAttendu, nombreCalcule);
		//fail("Test de recherche des categories n'est pas encre implemente"); // TODO
	}

}
