/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesDAO;

import Classes.Venda;
import Classes.Vendedor;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Taina Leal  
 * @author Ana Luiza Leal
 */
public interface VendaDAO {
    public void salvarVenda(Venda venda);
    public List<Venda> recuperarVenda(Vendedor vendedor);
    public Map<Vendedor, List<Venda>> getVendasImportadas();
    public void setVendasImportadas(Map<Vendedor, List<Venda>> vendasImportadas);
    public double calculaVendaMes(Vendedor vendedor, int mes, int ano);
    public double calculaVendaPeriodo(Vendedor vendedor, int mesInicio, int anoInicio, int mesFinal, int anoFinal);
    public double mediaVendas(Vendedor vendedor, int mesInicio, int anoInicio, int mesFinal, int anoFinal);
    
    
}
