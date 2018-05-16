package models;

public class CardType {
    private int id;
    private String pass_type;
    private float price;
    private int card_id;

    public CardType(int id, String pass_type, float price, int card_id) {
        this.id = id;
        this.pass_type = pass_type;
        this.price = price;
        this.card_id = card_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass_type() {
        return pass_type;
    }

    public void setPass_type(String pass_type) {
        this.pass_type = pass_type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }
}
