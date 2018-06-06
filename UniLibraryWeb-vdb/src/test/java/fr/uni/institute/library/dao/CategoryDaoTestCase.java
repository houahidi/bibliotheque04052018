package fr.uni.institute.library.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.uni.institute.library.business.inventory.Category;
import fr.uni.institute.library.dao.CategoryDao;
import fr.uni.institute.library.dao.DaoException;
import fr.uni.institute.library.dao.jdbc.CategoryDaoJdbc;

public class CategoryDaoTestCase {

	private CategoryDao categoryDao;
	private static Logger logger = Logger.getLogger(CategoryDaoTestCase.class);
	private Connection connection;
	private int nombreCategories;

	@Before
	public void setUp() throws Exception {
		logger.info("initialisation des ressources");

		InputStream file = CategoryDaoTestCase.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		properties.load(file);
		String url = properties.getProperty("url");// "jdbc:mysql://localhost/uni_library_db?autoReconnect=true";
		String login = properties.getProperty("login"); // "admin";
		String password = properties.getProperty("password"); // "admin";
		String driver = properties.getProperty("driver"); // "com.mysql.jdbc.Driver";
		logger.debug("chargment de driver");
		Class.forName(driver);
		connection = DriverManager.getConnection(url, login, password);
		categoryDao = new CategoryDaoJdbc(connection);
		logger.debug("defintion du nombre categories");
		nombreCategories = 9;
	}

	@After
	public void tearDown() throws Exception {
		logger.info("liberation des ressources");
		logger.debug("cloture de la connexion");
		connection.close();
		connection = null;
		logger.debug("liberation de service");
		categoryDao = null;
	}

	@Test
	public void testResearchAllCategories() {

		try {
			logger.info("Lancement de  testResearchAllCategories");
			Collection<Category> categories = categoryDao.researchAllCategories();
			logger.debug("Recuperation des categories de la BDD");
			assertNotNull(categories);
			logger.debug("la liste est non nulle");
			assertEquals(nombreCategories, categories.size(), 0);
			logger.debug("le nombre de categories calculé est equivaut au nombre de categories attendu");

		} catch (DaoException e) {
			fail(e.getMessage());
		}

	}

}