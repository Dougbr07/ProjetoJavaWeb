/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;

/**
 *
 * @author Douglas
 */
public class Pedido {
    
    
    private int id_pedido;
    private int id_cliente;
    private String datahour;
    private double preco;

    /**
     * @return the id_pedido
     */
    public int getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the datahour
     */
    public String getDatahour() {
        return datahour;
    }

    /**
     * @param datahour the datahour to set
     */
    public void setDatahour(String datahour) {
        this.datahour = datahour;
    }

    /**
     * @return the preço
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preço the preço to set
     */
    public void setPreco(double preço) {
        this.preco = preço;
    }
    
    
    
}
