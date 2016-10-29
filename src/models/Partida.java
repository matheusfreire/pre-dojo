package models;

import java.util.ArrayList;
import java.util.List;

public class Partida {
	
	private long id;
	private List<Jogador> listaDeJogadores;
	
	public Partida(long id){
		setId(id);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	public void adicionarJogadores(Jogador jogador1, Jogador jogador2){
		if(isJogadorAdicionado(jogador1.getNome())){
			jogador1 = obterJogadorRegistrado(jogador1.getNome());
		} else {
			adicionarJogador(jogador1);
		}
		
		if(jogador2 != null && isJogadorAdicionado(jogador2.getNome())){
			jogador2 = obterJogadorRegistrado(jogador2.getNome());
		} else if(jogador2 != null) {
			adicionarJogador(jogador2);
		}
	}
	
	private boolean isJogadorAdicionado(String nome){
		if (getListaDeJogadores().isEmpty()){
			return false;
		} else {
			return getListaDeJogadores().contains(new Jogador(nome));
		}
	}
	
	
	public Jogador obterJogadorRegistrado(String nome){
		if(getListaDeJogadores().isEmpty()){
			return new Jogador(nome);
		} else {
			for (Jogador jogador : getListaDeJogadores()) {
				if (jogador.equals(new Jogador(nome))){
					return jogador;
				}
			}
			return new Jogador(nome);
		}
	}
	
	private void adicionarJogador(Jogador jogador){
		if(!getListaDeJogadores().contains(jogador)){
			getListaDeJogadores().add(jogador);
		}
	}
	
	public int getQuantidadeJogadores(){
		return getListaDeJogadores().size();
	}

	
	public void registrarMorteJogador(Jogador jogadorMatador,Jogador jogadorMorto, String armaUsada){
		jogadorMatador.matou(armaUsada);
		jogadorMorto.morreu();
	}
	
	public void registrarMorteJogadorPorWorld(Jogador jogadorMorto){
		jogadorMorto.morreu();
	}
	
	public Jogador getVencedor(){
		if(getListaDeJogadores().isEmpty()){
			return null;
		} else {
			Jogador jogadorVencedor = new Jogador();
			for (Jogador jogador : listaDeJogadores) {
				if(jogador.getQtdeMatou() > jogadorVencedor.getQtdeMatou()){
					jogadorVencedor = jogador;
				}
			}
			return jogadorVencedor;
		}
	}
	
}