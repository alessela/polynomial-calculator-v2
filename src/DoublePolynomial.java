public class DoublePolynomial extends Polynomial<Double> {
    @Override
    public void addCoefficient(int exp, Double value) {
        Double coefficient = getCoefficient(exp);

        if (coefficient == null) setCoefficient(exp, value);
        else if (coefficient + value == 0.0) removeCoefficient(exp);
        else setCoefficient(exp, coefficient + value);
    }

    @Override
    public String toString() {
        if (getCoefficients().isEmpty()) return "0";

        return getCoefficients().descendingKeySet().stream().map(exp -> {
            Double coefficient = getCoefficients().get(exp);
            if (coefficient == 0.0) return "";

            String str = "";
            if (coefficient > 0) str += "+" + String.format("%.2f", coefficient);
            else str += String.format("%.2f", coefficient);

            if (exp == 1) str += "x";
            else if (exp > 1) str += "x^" + exp;

            return str;
        }).reduce("", String::concat);
    }
}
