package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil<T> {
	
	private List<T> content;
	
	@SuppressWarnings("unchecked")
	public T lerArquivoPartida(File log) throws Exception{
	    try {
	    	FileInputStream fstream = new FileInputStream(log);
	    	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

	    	String strLine;

	    	while ((strLine = br.readLine()) != null)   {
	    	  getContent().add((T)strLine);
	    	}

	    	br.close();
	    } catch(IOException e) {
	    	throw new Exception("Não foi possível ler o arquivo, corrija-o e tente novamente");
	    }
	    return (T) getContent();
	}

	public List<T> getContent() {
		if (content == null) {
			content = new ArrayList<T>();
			
		}

		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
	

}
