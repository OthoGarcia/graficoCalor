/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficocalor;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class LeituraArquivo {

    List<String> linhasArquivo;

    public List<String> lerArquivos() throws IOException {
        Path p = Paths.get(URI.create("file:///C:/Users/PC/Documents/predro/dados.txt"));
        Charset charset = Charset.forName("ISO-8859-1");
        linhasArquivo = Files.readAllLines(p, charset);

        /*
        System.out.println("teste");
        for (String l : linhasArquivo) {
            System.out.println("Linha: " + l);
        }
         */
        return linhasArquivo;
    }

    public List<Double> pegarValor() throws IOException {
        Double valor = 0.0;
        String result = "";
        List<Double> valores = new ArrayList<>();
        for (String l : linhasArquivo) {
            for (int j = 0; j < l.length(); j++) {
                if (l.charAt(j) == ',') {
                    result += '.';
                } else if (isDigit(l.charAt(j))) {
                    result += l.charAt(j);
                } else {
                    result = "";
                }
            }
            if (!result.isEmpty()) {
                valores.add(Double.parseDouble(result));
                result = "";
            }
        }

        return valores;
    }
    
    public List<String> pegarNomes() throws IOException {
        
        String result = "";
        List<String> valores = new ArrayList<>();
        for (String l : linhasArquivo) {
            for (int j = 0; j < l.length(); j++) {
                if (!isDigit(l.charAt(j))) {
                    result += l.charAt(j);
                } 
            }
            if (!result.isEmpty()) {
                valores.add(result);
                result = "";
            }
        }

        return valores;
    }

    public int quantValores() {
        return linhasArquivo.size();

    }

    public static boolean isDigit(char str) {
        boolean isInteger = false;
        if (Character.isDigit(str)) {
            return true;
        }
        return isInteger;
    }

}
