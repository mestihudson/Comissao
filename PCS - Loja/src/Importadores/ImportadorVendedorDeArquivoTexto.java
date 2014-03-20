/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Importadores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import trabalhopcs.LeitorArquivo;
import Classes.Vendedor;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class ImportadorVendedorDeArquivoTexto {
    public List<Vendedor> gerarListaVendedores(File arquivo){
         LeitorArquivo arquivoLido = new LeitorArquivo();
         List<String> lista = new ArrayList<>();
         lista = arquivoLido.leArquivo(arquivo);
         List<Vendedor> retorno = new ArrayList<>();
         
         for (int i=0; i<lista.size(); i++){
             String linha = lista.get(i);
             String[] vendedorLido = linha.split(";");
             Vendedor v = new Vendedor(vendedorLido[0], vendedorLido[1],vendedorLido[2] );
             retorno.add(v);
         }
         
         return retorno;
    }

    public ImportadorVendedorDeArquivoTexto() {
    }
    
    
}
