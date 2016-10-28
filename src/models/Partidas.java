package models;

import java.util.ArrayList;
import java.util.List;

public class Partidas {
	
	private int id;
	private List<Jogador> listaDeJogadores;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Jogador> getListaDeJogadores() {
		if (listaDeJogadores == null) {
			listaDeJogadores = new ArrayList<Jogador>();
		}
		return listaDeJogadores;
	}

	public void setListaDeJogadores(List<Jogador> listaDeJogadores) {
		this.listaDeJogadores = listaDeJogadores;
	}
	
	public void adicionarJogador(Jogador jogador){
		if(!getListaDeJogadores().isEmpty()){
			if(!getListaDeJogadores().contains(jogador)){
				getListaDeJogadores().add(jogador);
			}
		} else {
			getListaDeJogadores().add(jogador);
		}
	}
	
	public int getQuantidadeJogadores(){
		return getListaDeJogadores().size();
	}

	
	public void registrarMorteJogador(Jogador jogadorMorto,Jogador jogadorMatador, String armaUsada){
		jogadorMorto.morreu();
		jogadorMatador.matou(armaUsada);
	}
}
