/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesDAO;

import Classes.Vendedor;
import java.util.Map;


/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public interface VendedorDAO {
    public void salvarVendedor(Vendedor v);
    public Vendedor recuperarVendedor(String codigo);
    public Map<String, Vendedor> getVendedoresImportados();
    public void setVendedoresImportados(Map<String, Vendedor> vendedoresImportados);
}
