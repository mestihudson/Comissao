/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */

//Classe que faz a leitura de arquivo
public class LeitorArquivo {
    public List<String> leArquivo(File arquivo){
        List<String> retorno = new ArrayList<>();
        
        BufferedReader reader = null;
        try{
            try{
                reader = new BufferedReader(new FileReader(arquivo));
                
                String linha;
                while(reader.ready()){
                    linha = reader.readLine();
                    retorno.add(linha);
                }
            } finally{
                if (reader !=null)
                    reader.close();
            }
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
     
        return retorno;
    }

    public LeitorArquivo() {
    }
    
   
}
