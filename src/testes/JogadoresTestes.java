package testes;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Jogo;
import junit.framework.Assert;
import models.Partida;

public class JogadoresTestes {
	
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
	public void quantidadeJogadores(){
		for (Partida partida : jogo.getPartidas()) {
			Assert.assertEquals(2, partida.getQuantidadeJogadores());
		}
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
	
	@Test
	public void awardsDoVencedor(){
		for (Partida partida : jogo.getPartidas()) {
			Assert.assertEquals(0, partida.trofeusVencedor());
		}
	}

}
