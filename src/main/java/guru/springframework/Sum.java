package guru.springframework;

import lombok.AllArgsConstructor;

/**
 * Created by mask on Dec, 2020
 */
@AllArgsConstructor
public class Sum implements Expression {

    final Expression firstOperand;
    final Expression secondOperand;

    @Override
    public Money reduce(Bank bank, String to) {
        double amount = firstOperand.reduce(bank, to).amount + secondOperand.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, secondOperand);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(firstOperand.times(multiplier), secondOperand.times(multiplier));
    }

}
