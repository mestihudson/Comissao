/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopcs;

import Classes.Vendedor;
import Classes.Produto;
import Classes.Venda;
import Importadores.ImportadorVendedorDeArquivoTexto;
import Importadores.ImportadorProdutosDeArquivoTexto;
import InterfacesDAO.ProdutoDAO;
import InterfacesDAO.VendedorDAO;
import Importadores.ImportadorPrecosDeArquivoTexto;
import Importadores.ImportadorVendasDeArquivoTexto;
import InterfacesDAO.VendaDAO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Taina Leal
 * @author Ana Luiza Leal
 */
public class ServicoImportacaoDados{
    
    /*realiza o servico de carregar a lista de produtos da funcao gerarListaProdutos e 
    salvar no map de ProdutoDAO_EmMemoria*/
    public void gerenciaImportacaoProdutos(File arquivo, ProdutoDAO produto) throws IOException{
        ImportadorProdutosDeArquivoTexto importa = new ImportadorProdutosDeArquivoTexto();
        List<Produto> lista = importa.gerarListaProdutos(arquivo);
        
        for (int i=0; i<lista.size(); i++){
            Produto p = new Produto(lista.get(i).getCodigo(), lista.get(i).getNome());
            produto.salvarProduto(p);
        }
    }
    
    //realiza o servico de carregar a lista de vendedores 
    public void gerenciaImportacaoVendedores(File arquivo, VendedorDAO vendedor) throws IOException{
        ImportadorVendedorDeArquivoTexto importa = new ImportadorVendedorDeArquivoTexto();
        List<Vendedor> lista = importa.gerarListaVendedores(arquivo);
        
        for (int i=0; i<lista.size(); i++){
            Vendedor v = new Vendedor (lista.get(i).getCodigo(), lista.get(i).getNome(), lista.get(i).getCategoria());
            vendedor.salvarVendedor(v);
        }
    }
    
    //realiza o servico de carregar a lista de precos
    public void gerenciaImportacaoPrecos(File arquivo, ProdutoDAO produto) throws ParseException, IOException{
        ImportadorPrecosDeArquivoTexto importa = new ImportadorPrecosDeArquivoTexto();
        List<String> lista = importa.gerarListaPrecos(arquivo);
        for (int i=0; i<lista.size(); i++){
            String linha = lista.get(i);
            String[] camposSeparados = linha.split(";");
            //se produto nao existir ignora o campo
            if (produto.recuperarProduto(camposSeparados[1])==null)
                continue;
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            Date data = (Date)formatter.parse(camposSeparados[0]);
            double precoProd = Double.parseDouble(camposSeparados[2]);
            produto.recuperarProduto(camposSeparados[1]).registraPreco(data, precoProd);
        }
    }
    
    //realiza o servico de carregar a lista de vendas
    public void gerenciaImportacaoVendas(File arquivo, ProdutoDAO produto, VendedorDAO vendedor, VendaDAO venda) throws ParseException, IOException{
        ImportadorVendasDeArquivoTexto importa = new ImportadorVendasDeArquivoTexto();
        List<String> lista = importa.gerarListaVendas(arquivo);
        for (int i =0; i<lista.size(); i++){
            String linha = lista.get(i);
            String[] camposSeparados = linha.split(";");
            if (produto.recuperarProduto(camposSeparados[2])==null)
                continue;
            if (vendedor.recuperarVendedor(camposSeparados[3])==null)
                continue;
            
             DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
             Date data = (Date)formatter.parse(camposSeparados[0]);
             int qnt = Integer.parseInt(camposSeparados[1]);
             Produto prod = produto.recuperarProduto(camposSeparados[2]);
             Vendedor vended = vendedor.recuperarVendedor(camposSeparados[3]);
             Venda vend = new Venda(data, vended, prod, qnt);
             venda.salvarVenda(vend);
        }
        
        
    }
}
