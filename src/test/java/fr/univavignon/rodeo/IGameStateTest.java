package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.SpecieLevel;

public class IGameStateTest {

	private static IGameState gameState;
	
	/* Méthode permettant de récupérer l'objet sur lequel on va effectuer les tests */
	public static IGameState getObject() {
		//creation mock
		IGameState mock = mock(IGameState.class);
				
		//renvoie des valeurs 
		when(mock.getSpecieLevel(null)).thenReturn(SpecieLevel.NOVICE);
		when(mock.getProgression()).thenReturn(50);
		return mock;
	}
	
	@BeforeClass
	public static void setUp() {
		gameState = getObject();
	}
	
	@Test
	public void testGetAvailableEnvironments() {
		assertEquals(SpecieLevel.NOVICE, gameState.getSpecieLevel(null));
	}
	
	@Test
	public void testGetProgression() {
		assertEquals(50, gameState.getProgression());
	}
	
}
