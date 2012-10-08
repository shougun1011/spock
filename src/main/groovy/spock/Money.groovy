package spock

class Money {
    protected int amount
    
    String currency
    
    Money(int amount, String currency) {
        this.amount = amount
        this.currency = currency
    }
    
    def currency() {
        currency
    }
    
    static Money dollar(int amount) {
        new Dollar(amount, "USD")
    }
    
    static Money franc(int amount) {
        new Franc(amount, "CHF")
    }
    
    boolean equals(Object object) {
        amount == object.amount && currency().equals(object.currency())
    }
    
    def times(int multiplier) {
        new Money(amount * multiplier, currency)
    }
}