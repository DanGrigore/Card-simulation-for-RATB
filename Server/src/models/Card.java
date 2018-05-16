package models;

public class Card {
    private int id;
    private float card_money;
    private String expireDate;
    private int client_id;

    public Card(int id, float card_money, String expireDate, int client_id) {
        this.id = id;
        this.card_money = card_money;
        this.expireDate = expireDate;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCard_money() {
        return card_money;
    }

    public void setCard_money(float card_money) {
        this.card_money = card_money;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

}
