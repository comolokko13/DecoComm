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

    public String getCardNumber() {
        return cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

}
