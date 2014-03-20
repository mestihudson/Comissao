/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Importadores;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import trabalhopcs.LeitorArquivo;
import Classes.Produto;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class ImportadorProdutosDeArquivoTexto{
    
    //funcao que retorna uma lista de produtos lidos do arquivo
    public List<Produto> gerarListaProdutos(File arquivo){
        
         LeitorArquivo arquivoLido = new LeitorArquivo();
         List<String> lista = new ArrayList<>();
         lista = arquivoLido.leArquivo(arquivo);
         List<Produto> retorno = new ArrayList<>();
         
         for (int i=0; i<lista.size(); i++){
             String linha = lista.get(i);
             String[] produtoLido = linha.split(";");
             Produto p = new Produto(produtoLido[0], produtoLido[1]);
             retorno.add(p);
         }
         
         return retorno;
             
    }

    public ImportadorProdutosDeArquivoTexto() {
    }
    
    
}
