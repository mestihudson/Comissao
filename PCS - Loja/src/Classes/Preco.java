/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;



/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class Preco {
    private Date dataVigencia;
    private double valor;

    public Preco(Date dataVigencia, double valor) {
        this.dataVigencia = dataVigencia;
        this.valor = valor;
    }

    public Preco() {
    }

    public Date getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(Date dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
  
    
}
