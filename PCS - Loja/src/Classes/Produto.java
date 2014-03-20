/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class Produto {
    private String codigo;
    private String nome;
    private List<Preco> precos;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto() {
        precos = new ArrayList<>();
    }

    public Produto(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        precos=new ArrayList<>();
    }
    
    public void registraPreco(Date data, double preco){
        Preco p = new Preco(data, preco);
        if (precos.contains(p))
            return;
        
        precos.add(p);
        Collections.sort(precos, new Comparator<Preco>(){
            @Override
            public int compare(Preco o1, Preco o2) {
                if (o1.getDataVigencia().before(o2.getDataVigencia()))
                    return -1;
                else if (o1.getDataVigencia().after(o2.getDataVigencia()))
                    return 1;
                
                return 0;
            }
        });
    }

    public List<Preco> getPrecos() {
        return precos;
    }
    
    public Preco getUltimoPreco(){
        return precos.get(precos.size()-1);
    }
    
    public double valorNaData(Date data){
        double valor = 0.0;
        for (Preco p : precos){
            if (data.before(p.getDataVigencia()))
                    continue;
            valor=p.getValor();
            break;
        }
        return valor;
    }
    
    
}
