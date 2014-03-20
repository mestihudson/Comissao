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
public class Venda {
    Date data;
    Vendedor vendedor;
    Produto produto;
    int quantidade;

    public Venda() {
    }

    public Venda(Date data, Vendedor vendedor, Produto produto, int quantidade) {
        this.data = data;
        this.vendedor = vendedor;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
