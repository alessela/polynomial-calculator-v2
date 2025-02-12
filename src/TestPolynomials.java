public class TestPolynomials {
    public static void main(String[] args) {
        IntegerPolynomial p = new IntegerPolynomial();
        p.setCoefficient(4, 1);
        p.setCoefficient(3, -1);
        p.setCoefficient(2, 2);
        p.setCoefficient(1, -3);
        p.setCoefficient(0, 4);
        System.out.println("P = " + p);

        IntegerPolynomial q = PolynomialRegex.stringToPolynomial("x^3+4x^2+2");
        assert q != null;
        System.out.println("Q = " + q);

        System.out.println("P + Q = " + PolynomialArithmetic.add(p, q));
        System.out.println("P - Q = " + PolynomialArithmetic.subtract(p, q));
        System.out.println("P * Q = " + PolynomialArithmetic.multiply(p, q));
        DoublePolynomial[] div = PolynomialArithmetic.divide(p, q);
        System.out.println("P / Q = " + div[0]);
        System.out.println("P % Q = " + div[1]);

        System.out.println("P' = " + PolynomialCalculus.derivative(p));
        System.out.println("Q' = " + PolynomialCalculus.derivative(q));
        System.out.println("integral P = " + PolynomialCalculus.integral(p));
        System.out.println("integral Q = " + PolynomialCalculus.integral(q));
    }
}
