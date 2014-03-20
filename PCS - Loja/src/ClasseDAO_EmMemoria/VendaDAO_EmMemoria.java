/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseDAO_EmMemoria;

import Classes.Produto;
import Classes.Venda;
import Classes.Vendedor;
import InterfacesDAO.VendaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class VendaDAO_EmMemoria implements VendaDAO{

    Map<Vendedor, List<Venda>> vendasImportadas;
  

    public VendaDAO_EmMemoria() {
        vendasImportadas = new HashMap<>();
       
    }
    
    

    @Override
    public List<Venda> recuperarVenda(Vendedor vendedor) {
            return vendasImportadas.get(vendedor);
    }

    @Override
    public void salvarVenda(Venda venda) {
        Vendedor vendedor = venda.getVendedor();
        List<Venda> lista = new ArrayList<>();
     
        if (vendasImportadas.get(vendedor)==null){
            lista.add(venda);
            vendasImportadas.put(vendedor, lista );
        }
        else{
            lista = vendasImportadas.get(vendedor);
            lista.add(venda);
            vendasImportadas.remove(vendedor);
            vendasImportadas.put(vendedor, lista);
        }     
    }

    //funcao que calcula as vendas mensais de cada vendedor
    @Override
    public double calculaVendaMes(Vendedor vendedor, int mes, int ano){
        List<Venda> lista=vendasImportadas.get(vendedor);
        double total=0.0;
        double precoCompra=0.0;
        
        if (lista!=null){
            for(Venda v : lista){
                Calendar cal = Calendar.getInstance();
                cal.setTime(v.getData());
                //percorre a lista de vendas e analisa se a venda eh do mesmo mes e ano pedido
                if((cal.get(Calendar.MONTH)+1==mes)&&(cal.get(Calendar.YEAR)==ano)){
                    Produto prod = v.getProduto();
                    precoCompra = prod.valorNaData(v.getData())*v.getQuantidade();
                    total+=precoCompra;
                }
                
            }   
        }
        return total;
    }
    
    //funcao calcula total de vendas de um vendedor em um periodo determinado
    @Override
    public double calculaVendaPeriodo(Vendedor vendedor, int mesInicio, int anoInicio, int mesFinal, int anoFinal){
        double total =0;
        int ano = anoFinal - anoInicio;
        int numMes;
        
        //total de meses (vezes) a chamar a funcao mensal
        numMes = (12*ano) + (mesFinal-mesInicio);
        
        for (int i=0; i<=numMes; i++){
            total+=calculaVendaMes(vendedor, mesInicio, anoInicio);
            mesInicio++;
            //caso mes = 1, significa que é janeiro e o ano deve ser incrementado
            if(mesInicio==1)
                anoInicio++;
        }
        return total;
    }
    
    //funcao calcula media de vendas total de um vendedor em um periodo determinado
    @Override
    public double mediaVendas(Vendedor vendedor, int mesInicio, int anoInicio, int mesFinal, int anoFinal){
        int ano = anoFinal - anoInicio;
        int numMes = (12*ano) + (mesFinal-mesInicio);
        double vendaTotal = calculaVendaPeriodo(vendedor, mesInicio, anoInicio, mesFinal, anoFinal);
        double media = vendaTotal/(numMes+1);
        return media;
        
    }
    
    
    
    @Override
    public Map<Vendedor, List<Venda>> getVendasImportadas() {
        return vendasImportadas;
    }

    @Override
    public void setVendasImportadas(Map<Vendedor, List<Venda>> vendasImportadas) {
        this.vendasImportadas = vendasImportadas;
    }
    
    
    
}
