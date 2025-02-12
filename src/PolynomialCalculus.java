public class PolynomialCalculus {
    public static IntegerPolynomial derivative(IntegerPolynomial p) {
        IntegerPolynomial result = new IntegerPolynomial();
        for (int exp : p.getCoefficients().keySet()) {
            if (exp > 0) result.setCoefficient(exp - 1, exp * p.getCoefficient(exp));
        }
        return result;
    }

    public static DoublePolynomial integral(IntegerPolynomial p) {
        DoublePolynomial result = new DoublePolynomial();
        for (int exp : p.getCoefficients().keySet()) {
            result.setCoefficient(exp + 1, (double)p.getCoefficient(exp) / (exp + 1));
        }
        return result;
    }
}
