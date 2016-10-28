package core;

import java.io.File;
import java.util.ArrayList;

import util.FileUtil;

public class Jogo {
	
	public static void main(String[] args) {
		new Jogo().obterPartida(new File("/Users/matheus/workspace/web/java/pre-dojo/src/core/log.txt"));
	}
	
	public void obterPartida(File log){
		FileUtil<ArrayList<String>> linhas = new FileUtil<ArrayList<String>>();
		for (String eventoPartida : linhas.lerArquivoPartida(log)) {
			System.out.println(eventoPartida);
		}
	}

}
