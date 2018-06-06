package fr.uni.institute.library.web.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class IndexITTestCase {
	
	private static Logger logger= Logger.getLogger(IndexITTestCase.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Locale locale  = Locale.getDefault();
		logger.warn(">>>>>>>>>>>>>>>>language : "+locale.getLanguage() );
		logger.warn(">>>>>>>>>>>>>>>>Contry :"+locale.getCountry() );
		final String ADDRESS = "http://localhost:8181/UniLibraryWeb-vdb/";

		 	try {	
		 		
					WebConversation webConversation = new WebConversation();
					WebResponse menuResponse = webConversation.getResponse(ADDRESS);
					assertTrue(menuResponse.getTitle().contains("UNI Institute - UNI Library"));
				} catch (SAXException  e) {
					fail("SAXException: " + e.getMessage());
				} catch (IOException e) {
					fail("IOException: " + e.getMessage());
				}
			
	}

}