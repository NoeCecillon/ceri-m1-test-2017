package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;

public class IAnimalTest {

	private static IAnimal animal;
	
	/* Méthode permettant de récupérer l'objet sur lequel on va effectuer les tests */
	public IAnimal getObject() {
		//creation mock
		IAnimal mock = mock(IAnimal.class);
		//renvoie des valeurs 
		when(mock.getXP()).thenReturn(100);
		when(mock.isBoss()).thenReturn(true);
		when(mock.isEndangered()).thenReturn(false);
		when(mock.isSecret()).thenReturn(true);
		return mock;
	}
	
	@BeforeClass
	public void setUp() {
		animal = getObject();
	}
	
	@Test
	public void testXP() {
		assertEquals(100, animal.getXP());
	}
	
	@Test
	public void testBoss() {
		assertEquals(true, animal.isBoss());
	}
	
	@Test
	public void testEndangered() {
		assertEquals(false, animal.isEndangered());
	}
	
	@Test
	public void testSecret() {
		assertEquals(true, animal.isSecret());
	}
	
}
