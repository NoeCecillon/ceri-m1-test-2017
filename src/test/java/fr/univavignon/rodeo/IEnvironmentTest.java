package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

public class IEnvironmentTest {

	private static IEnvironment environment;
	private static List<ISpecie> species;
	
	/* Méthode permettant de récupérer l'objet sur lequel on va effectuer les tests */
	public static IEnvironment getObject() {
		//creation mock
		IEnvironment mock = mock(IEnvironment.class);
		//crée la List et ajoute des mocks dedans 
		species = new ArrayList<ISpecie>();
		species.add(ISpecieTest.getObject());
		species.add(ISpecieTest.getObject());
				
		//renvoie des valeurs 
		when(mock.getAreas()).thenReturn(15);
		when(mock.getSpecies()).thenReturn(species);
		return mock;
	}
	
	@BeforeClass
	public static void setUp() {
		environment = getObject();
	}
	
	@Test
	public void testGetAreas() {
		assertEquals(100, environment.getAreas());
	}
	
	@Test
	public void testGetSpecies() {
		assertEquals(species, environment.getSpecies());
	}
	
}
