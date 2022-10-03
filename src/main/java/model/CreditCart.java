package model;

public class CreditCart {

    private String cardNumber;
    private String nameOnCard;
    private String expirationDate;
    private String securityCode;

    public CreditCart(String cardNumber, String nameOnCard, String expirationDate, String securityCode) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
        this.securityCode=securityCode;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
