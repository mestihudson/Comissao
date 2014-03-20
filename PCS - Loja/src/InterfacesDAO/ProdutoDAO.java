/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesDAO;


import java.util.Map;
import Classes.Produto;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public interface ProdutoDAO {
    public void salvarProduto (Produto p);
    public Produto recuperarProduto (String codigo);
    public void setProdutosImportados(Map<String, Produto> produtosImportados);
    public Map<String, Produto> getProdutosImportados();
    
}
