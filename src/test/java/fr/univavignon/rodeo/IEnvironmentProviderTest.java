package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;

public class IEnvironmentProviderTest {

	private static IEnvironmentProvider environmentProvider;
	private static List<String> environmentName;
	private static IEnvironment environment;
	
	/* Méthode permettant de récupérer l'objet sur lequel on va effectuer les tests */
	public static IEnvironmentProvider getObject() {
		//creation mock
		IEnvironmentProvider mock = mock(IEnvironmentProvider.class);
		//crée la List et ajoute des mocks dedans 
		environmentName = new ArrayList<String>();
		environmentName.add("env1");
		environmentName.add("env2");
		environmentName.add("env3");
				
		//renvoie des valeurs 
		when(mock.getAvailableEnvironments()).thenReturn(environmentName);
		when(mock.getEnvironment("test")).thenReturn(environment);
		return mock;
	}
	
	@BeforeClass
	public static void setUp() {
		environmentProvider = getObject();
	}
	
	@Test
	public void testGetAvailableEnvironments() {
		assertEquals(environmentName, environmentProvider.getAvailableEnvironments());
	}
	
	@Test
	public void testGetEnvironment() {
		assertEquals(environment, environmentProvider.getEnvironment("test"));
	}
	
}
