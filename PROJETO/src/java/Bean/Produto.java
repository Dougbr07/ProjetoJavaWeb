package Bean;

public class Produto {
    
    private int id;
    private String description;
    private double price;
    private String image;
    private double centro;
    private int category;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
