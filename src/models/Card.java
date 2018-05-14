package models;

public class Card {
    private float card_money;
    private String expireDate;
    private String passType;

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

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }
}
