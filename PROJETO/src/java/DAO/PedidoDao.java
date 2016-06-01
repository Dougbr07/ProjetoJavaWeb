/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Pedido;
import Bean.Produto;
import java.util.List;

/**
 *
 * @author Douglas
 */
public interface PedidoDao {
    
    public boolean insert(Pedido pedido, List<Produto> produtos);
    public void remove (int id);
    public List<Pedido> list();
    public Pedido search(int id);
    public void edit(Pedido pessoa);
}
