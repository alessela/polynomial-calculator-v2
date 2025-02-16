public class TestPolynomials {
    public static void main(String[] args) {
        try {
            IntegerPolynomial p = PolynomialRegex.parsePolynomial("x^4-x^3+2x^2-3x+4");
            System.out.println("P = " + p);

            IntegerPolynomial q = PolynomialRegex.parsePolynomial("x^3+4x^2+0x+2");
            System.out.println("Q = " + q);

            System.out.println("P(2) = " + p.evaluate(2));

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
