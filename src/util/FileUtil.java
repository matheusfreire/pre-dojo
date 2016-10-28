package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	private static String content;
	
	public static String lerArquivoPartida(File log){
	    File file = log;
	    FileReader reader = null;
	    try {
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        content = new String(chars);
	        reader.close();
	    } catch (IOException e) {
	       e.getMessage();
	       return "Aconteceu um problema na leitura do arquivo";	
	    } finally {
	        if(reader !=null){
	        	try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					return "Não foi possível terminar a leitura do arquivo, tente novamente"; 
				}
        	}
	    }
	    return content;
	}
	

}
