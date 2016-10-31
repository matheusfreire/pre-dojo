package main;

import java.io.File;

import core.Jogo;

public class IniciarPartida {

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		try {
			jogo.obterPartida(new File(args[0]));
		} catch (NumberFormatException e) {
			System.out.println("Aconteceu algo inesperado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		jogo.mostrarResultados();
	}

}
