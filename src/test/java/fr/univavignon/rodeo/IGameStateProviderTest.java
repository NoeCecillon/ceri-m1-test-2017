package fr.univavignon.rodeo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

public class IGameStateProviderTest {

	private static IGameStateProvider gameStateProvider;
	private static IGameState gameState;
	
	/* Méthode permettant de récupérer l'objet sur lequel on va effectuer les tests */
	public static IGameStateProvider getObject() {
		//creation mock
		IGameStateProvider mock = mock(IGameStateProvider.class);
				
		//renvoie des valeurs 
		when(mock.get("test")).thenReturn(gameState);
		return mock;
	}
	
	@BeforeClass
	public static void setUp() {
		gameStateProvider = getObject();
	}
	
	@Test
	public void testGet() {
		assertEquals(gameState, gameStateProvider.get("test"));
	}
	
}
