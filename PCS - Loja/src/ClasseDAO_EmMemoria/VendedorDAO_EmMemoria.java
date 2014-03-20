/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseDAO_EmMemoria;

import InterfacesDAO.VendedorDAO;
import java.util.HashMap;
import java.util.Map;
import Classes.Vendedor;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class VendedorDAO_EmMemoria implements VendedorDAO {
        Map<String, Vendedor> vendedoresImportados;

    public VendedorDAO_EmMemoria() {
        vendedoresImportados = new HashMap<>();
    }

    //Salva objeto vendedor no map
    @Override
    public void salvarVendedor(Vendedor v) {
        if (vendedoresImportados.containsKey(v.getCodigo()))
            vendedoresImportados.remove(v.getCodigo());
            
        vendedoresImportados.put(v.getCodigo(), v);
    }

    
  
    @Override
    public Map<String, Vendedor> getVendedoresImportados() {
        return vendedoresImportados;
    }

    @Override
    public void setVendedoresImportados(Map<String, Vendedor> vendedoresImportados) {
        this.vendedoresImportados = vendedoresImportados;
    }

    @Override
    public Vendedor recuperarVendedor(String codigo) {
       Vendedor retorno = vendedoresImportados.get(codigo);
       return retorno;
    }
        
    
    
    
        
}
