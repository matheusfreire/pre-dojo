package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Jogador {
	
	private String nome;
	private Map<String, Integer> armas;
	private int qtdeMortes;
	private int qtdeMatou;
	private int award;
	
	public Jogador(){
		setQtdeMatou(0);
		setQtdeMortes(0);
	}
	
	public Jogador(String nome){
		this();
		this.nome = nome;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, Integer> getArmas() {
		if (armas == null) {
			armas = new HashMap<String, Integer>();
		}

		return armas;
	}

	public void setArmas(Map<String, Integer> armas) {
		this.armas = armas;
	}

	public int getQtdeMortes() {
		return qtdeMortes;
	}

	public void setQtdeMortes(int qtdeMortes) {
		this.qtdeMortes = qtdeMortes;
	}

	public int getQtdeMatou() {
		return qtdeMatou;
	}

	public void setQtdeMatou(int qtdeMatou) {
		this.qtdeMatou = qtdeMatou;
	}
	
	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	void matou(String arma){
		if(getArmas().containsKey(arma)){
			Integer qtde = (Integer) getArmas().get(arma);
			qtde++;
			getArmas().put(arma,qtde);
		}else{
			getArmas().put(arma,1);
		}
		++qtdeMatou;
	}
	
	void morreu(){
		++qtdeMortes;
	}
	
	public String getArmaPreferida(){
		if (!getArmas().isEmpty()){
			String armaPreferida = "";
			Integer armaPrefNum = 0;
			for (Entry<String, Integer> arma : getArmas().entrySet()) {
				if(arma.getValue() >  armaPrefNum){
					armaPrefNum = arma.getValue();
					armaPreferida = arma.getKey();
				}
			}
			return armaPreferida;
		} else {
			return "Jogador não tem nenhuma morte";
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.nome.equals(((Jogador)obj).getNome());
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

}
