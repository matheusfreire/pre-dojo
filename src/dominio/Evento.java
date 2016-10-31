package dominio;

public enum Evento {
	
	INICIO("started"), 
	MORTE("killed"), 
	MORREU_WORLD("<WORLD>"), 
	FIM("ended");
	
	private String key;
	
	Evento(String key){
		setKey(key);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}