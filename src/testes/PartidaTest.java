package testes;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Jogo;
import junit.framework.Assert;
import models.Partida;

public class PartidaTest {
	
	private Jogo jogo;

	@Before
	public void setUp() throws Exception {
		jogo = new Jogo();
		jogo.obterPartida(new File("/Users/matheus/workspace/web/java/pre-dojo/src/core/log.txt"));
	}

	@After
	public void tearDown() throws Exception {
		jogo = null;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void quantidadePartidas(){
		Assert.assertEquals(1, jogo.getPartidas().size());
	}
	
	@Test
	public void obterVencedor(){
		for (Partida partida : jogo.getPartidas()) {
			Assert.assertEquals("Roman", partida.getVencedor().toString());
		}
	}
	
	@Test
	public void quantidadeMortesVencedor(){
		for (Partida partida : jogo.getPartidas()) {
			Assert.assertEquals("R-15", partida.getVencedor().getArmaPreferida());
		}
	}
	
}