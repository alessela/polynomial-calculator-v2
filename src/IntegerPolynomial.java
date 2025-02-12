import java.util.TreeMap;

public class IntegerPolynomial extends Polynomial<Integer> {
    public IntegerPolynomial() {
    }

    public IntegerPolynomial(TreeMap<Integer, Integer> coefficients) {
        super(coefficients);
    }

    @Override
    public void addCoefficient(int exp, Integer value) {
        Integer coefficient = getCoefficient(exp);

        if (coefficient == null) setCoefficient(exp, value);
        else if (coefficient + value == 0) removeCoefficient(exp);
        else setCoefficient(exp, coefficient + value);
    }

    @Override
    public String toString() {
        if (getCoefficients().isEmpty()) return "0";

        return getCoefficients().descendingKeySet().stream().map(exp -> {
            int coefficient = getCoefficients().get(exp);

            if (coefficient == 0) return "";

            String str = "";
            if (coefficient == 1) {
                str += "+";
                if (exp == 0) str += coefficient;
            }
            else if (coefficient == -1) {
                if (exp == 0) str += coefficient;
                else str += "-";
            }
            else if (coefficient > 0) str += "+" + coefficient;
            else str += coefficient;

            if (exp == 1) str += "x";
            else if (exp > 1) str += "x^" + exp;

            return str;
        }).reduce("", String::concat);
    }
}
