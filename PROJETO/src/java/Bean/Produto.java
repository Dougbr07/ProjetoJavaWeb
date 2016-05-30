/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Douglas
 */
public class Produto {
    
    private String description;
    private double price;
    private int amount;
    private String image;
    private double centro;
    private int category;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * @return the descricao
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the descricao to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the precoUnidade
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the precoUnidade to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quantidade
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the quantidade to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the imagem
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the imagem to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the centro
     */
    public double getCentro() {
        return centro;
    }

    /**
     * @param centro the centro to set
     */
    public void setCentro(double centro) {
        this.centro = centro;
    }
}
