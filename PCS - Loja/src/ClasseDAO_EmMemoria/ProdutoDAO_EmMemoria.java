/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseDAO_EmMemoria;


import InterfacesDAO.ProdutoDAO;
import java.util.Map;
import Classes.Produto;
import java.util.HashMap;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */

public class ProdutoDAO_EmMemoria implements ProdutoDAO {

    private Map<String, Produto> produtosImportados;

    @Override
    public Map<String, Produto> getProdutosImportados() {
        return produtosImportados;
    }    
    
    public ProdutoDAO_EmMemoria() {
        produtosImportados = new HashMap<>();
    }
    
    @Override
    public void setProdutosImportados(Map<String, Produto> produtosImportados) {
        this.produtosImportados = produtosImportados;
    }

    //Retorna o produto de acordo com o codigo passado
    @Override
    public Produto recuperarProduto(String codigo) {
       return produtosImportados.get(codigo);
    }
    
    //Salva no map o produto passado
     @Override
    public void salvarProduto(Produto p) {
         if (produtosImportados.containsKey(p.getCodigo()))
             produtosImportados.remove(p.getCodigo());
         
         produtosImportados.put(p.getCodigo(), p);
    }

     
    
        
}
