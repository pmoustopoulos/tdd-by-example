package guru.springframework;

/**
 * Created by mask on Dec, 2020
 */
public interface Expression {

    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);

}
