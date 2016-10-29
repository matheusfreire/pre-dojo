package core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dominio.Evento;
import models.Jogador;
import models.Partida;
import util.FileUtil;

public class Jogo {
	
	private List<Partida> partidas = new ArrayList<Partida>();
	
	public void obterPartida(File log) throws NumberFormatException, Exception{
		FileUtil<ArrayList<String>> linhas = new FileUtil<ArrayList<String>>();
		Partida p = null;
		for (String eventoPartida : linhas.lerArquivoPartida(log)) {
			if (eventoPartida.contains(Evento.INICIO.getKey())){
				//23/04/2013 15:34:22 - New match 11348965 has started
				// 		0		1	  2  3    4      5      6    7	
				p = new Partida(Long.parseLong(getItemDoEvento(eventoPartida, 5)));
				continue;
			} else if (eventoPartida.contains(Evento.FIM.getKey())){
				partidas.add(p);
				p = null;
				continue;
			}
			
			//23/04/2013 15:36:04 - Roman killed Nick using M16
			//	  0			1	  2	  3		4	  5		6	7	
			if (eventoPartida.contains(Evento.MORTE.getKey()) && !eventoPartida.contains(Evento.MORREU_WORLD.getKey())){
				String nomeMatou = getItemDoEvento(eventoPartida, 3);
				String nomeMorreu = getItemDoEvento(eventoPartida, 5);
				String arma = getItemDoEvento(eventoPartida, 7);
				Jogador jQueMatou = p.obterJogadorRegistrado(nomeMatou);
				Jogador jQueMorreu = p.obterJogadorRegistrado(nomeMorreu);
				p.adicionarJogadores(jQueMatou, jQueMorreu);
				p.registrarMorteJogador(jQueMatou, jQueMorreu, arma);
				
			//23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN
			// 	0			1	  2		3	   4	5	6	7	
			} else if (eventoPartida.contains(Evento.MORREU_WORLD.getKey())){
				String nomeMorto = getItemDoEvento(eventoPartida, 5);
				Jogador jogador = new Jogador(nomeMorto);
				p.adicionarJogadores(jogador, null);
				p.registrarMorteJogadorPorWorld(jogador);
			}
			
		}
	}
	
	public void mostrarResultados(){
		if (partidas.isEmpty()){
			System.out.println("Não houve partidas realizadas");
		} else {
			for (Partida partida : partidas) {
				Jogador vencedor =  partida.getVencedor();
				System.out.printf("Partida: " +partida.getId() + "|Vencedor: "+ vencedor.toString() + "|Quantidade mortes/morreu: %d/%d "+ "|Arma mais utilizada: " + vencedor.getArmaPreferida() , vencedor.getQtdeMatou(), vencedor.getQtdeMortes());
				System.out.println("");
			}
		}
	}
	
	private String getItemDoEvento(String eventoPartida, int posicao){
		return eventoPartida.split(" ")[posicao];
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

}