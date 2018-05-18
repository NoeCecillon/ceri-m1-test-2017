package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

public class ISpecieTest {

	private static ISpecie specie;
	private static List<IAnimal> animals;
	
	/* Méthode permettant de récupérer l'objet sur lequel on va effectuer les tests */
	public static ISpecie getObject() {
		//creation mock
		ISpecie mock = mock(ISpecie.class);
		//crée la List et ajoute des mocks dedans 
		animals = new ArrayList<IAnimal>();
		animals.add(IAnimalTest.getObject());
		animals.add(IAnimalTest.getObject());
		
		when(mock.getAnimals()).thenReturn(animals);
		when(mock.getArea()).thenReturn(5);
		return mock;
	}
	
	@BeforeClass
	public static void setUp() {
		specie = getObject();
	}
	
	@Test
	public void testGetAnimals() {
		assertEquals(animals, specie.getAnimals());
		//Vérifie la taille de la liste
		assertEquals(2, specie.getAnimals().size());
	}
	
	@Test
	public void testGetArea() {
		assertEquals(5, specie.getArea());
	}
	
}
