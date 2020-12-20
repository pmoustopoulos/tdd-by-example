package guru.springframework;

import lombok.AllArgsConstructor;

/**
 * Created by mask on Dec, 2020
 */
@AllArgsConstructor
public class Money implements Expression {

    protected double amount;
    protected String currency;


    protected String currency() {
        return currency;
    }


    public static Money dollar(double amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(double amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;

        // the amount should be the same and the class should be the same
        return  amount == money.amount
                && this.currency == money.currency;
    }

    @Override
    public Money reduce(Bank bank, String to){
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Money times(int multiplier ) {
        return new Money(amount * multiplier, this.currency);
    }


    public Expression plus(Expression secondOperand) {
        return new Sum(this, secondOperand);
    }
}
