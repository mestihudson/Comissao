/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import InterfacesDAO.VendaDAO;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
//Classe que calcula a comissao dos vendedores
public class CalculaComissao {

    public CalculaComissao() {
    }
    //funcao que calcula a comissao mensal de um vendedor
    public double comissaoVendedorMes(VendaDAO venda, Vendedor vendedor, int mes, int ano){
        double total;
        double comissao=0;
        
        total = venda.calculaVendaMes(vendedor, mes, ano);
        if (vendedor.getCategoria().equals("1")){
            if (total<=1000){
                comissao = total*0.1;
                return comissao;
            }
            if((1800>=total)&&(total>1000)){
                total-=1000;
                comissao = (total*0.15)+100;
                return comissao;
            }
            if (1800>=total){
                total-=1800;
                comissao = (total*0.2)+100+120;
                return comissao;
            }
        }
        
        else if(vendedor.getCategoria().equals("2")){
            if (total<=2000){
                comissao = total*0.1;
                return comissao;
            }
            if(total<=4000){
                comissao = total*0.2;
                return comissao;
            }
            if(total>4000){
                comissao=total*0.3;
                return comissao;
            }
        }
        return comissao;
    }
    
    //funcao que calcula a comissao de um vendedor em um determinado periodo
    public double comissaoVendedorPeriodo(VendaDAO venda, Vendedor vendedor, int mesInicial, int anoInicial, int mesFinal, int anoFinal){
        double comissao = 0;
        //calcula se o periodo a calcular eh maior que um ano
        int ano = anoFinal - anoInicial;
        int numMes;
   
        //calcula o periodo em meses, (vezes que ira chamar a funcao de calculo mensal de comissao)
        numMes = (12*ano) + (mesFinal-mesInicial);
        
        for (int i=0; i<=numMes; i++){
            comissao+=comissaoVendedorMes(venda, vendedor, mesInicial, anoInicial);
            mesInicial++;
            //caso mes = 1, significa que eh janeiro e o ano deve ser incrementado
            if(mesInicial==1)
              anoInicial++;
        }
        return comissao;
    }
    
    //funcao que calcula a media de comissoes de um vendedor em um periodo
    public double mediaComissao(VendaDAO venda, Vendedor vendedor, int mesInicial, int anoInicial, int mesFinal, int anoFinal){
        
        int ano = anoFinal - anoInicial;
        int numMes = (12*ano) + (mesFinal-mesInicial);
        double comissaoTotal = comissaoVendedorPeriodo(venda, vendedor, mesInicial, anoInicial, mesFinal, anoFinal);
        double media = comissaoTotal/(numMes+1);
        return media;
        
    }
}

