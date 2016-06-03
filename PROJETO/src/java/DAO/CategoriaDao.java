package DAO;

import Bean.Categoria;
import Bean.Pedido;
import Bean.Produto;
import java.util.ArrayList;

public interface CategoriaDao {
    public int insert(Categoria categoria);
    public void remove (int id);
    public ArrayList<Categoria> list();
    public Categoria search(int id);
    public void edit(Categoria categoria);
}
