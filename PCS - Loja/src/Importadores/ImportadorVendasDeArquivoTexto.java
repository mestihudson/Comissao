/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Importadores;

import java.io.File;
import java.util.List;
import trabalhopcs.LeitorArquivo;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class ImportadorVendasDeArquivoTexto {
    
    
     public List<String> gerarListaVendas(File arquivo){
         LeitorArquivo arquivoLido = new LeitorArquivo();
         List<String> lista = arquivoLido.leArquivo(arquivo);
         
        return lista;
    }
}
