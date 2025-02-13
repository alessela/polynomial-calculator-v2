public class PolynomialArithmetic {
    public static IntegerPolynomial add(IntegerPolynomial p1, IntegerPolynomial p2) {
        IntegerPolynomial result = new IntegerPolynomial(p1.getCoefficients());

        p2.getCoefficients().descendingKeySet().forEach(
                exp -> result.addCoefficient(exp, p2.getCoefficient(exp)));

        return result;
    }

    public static IntegerPolynomial subtract(IntegerPolynomial p1, IntegerPolynomial p2) {
        IntegerPolynomial result = new IntegerPolynomial(p1.getCoefficients());

        p2.getCoefficients().descendingKeySet().forEach(
                exp -> result.addCoefficient(exp, -p2.getCoefficient(exp)));

        return result;
    }

    public static IntegerPolynomial multiply(IntegerPolynomial p1, IntegerPolynomial p2) {
        IntegerPolynomial result = new IntegerPolynomial();

        p1.getCoefficients().descendingKeySet().forEach(exp1 ->
                p2.getCoefficients().descendingKeySet().forEach(exp2 ->
                        result.addCoefficient(exp1 + exp2,
                                p1.getCoefficient(exp1) * p2.getCoefficient(exp2))));

        return result;
    }

    public static DoublePolynomial[] divide(IntegerPolynomial p, IntegerPolynomial d) {
        DoublePolynomial q = new DoublePolynomial();
        DoublePolynomial r = new DoublePolynomial();

        p.getCoefficients().keySet().forEach(exp ->
                r.setCoefficient(exp, p.getCoefficient(exp).doubleValue()));

        while (!r.isNull() && r.getDegree() >= d.getDegree()) {
            int exp = r.getDegree() - d.getDegree();
            double coeff = r.getCoefficient(r.getDegree()) / d.getCoefficient(d.getDegree());
            q.addCoefficient(exp, coeff);

            d.getCoefficients().descendingKeySet().forEach(dExp ->
                    r.addCoefficient(dExp + exp, -d.getCoefficient(dExp) * coeff));
        }

        return new DoublePolynomial[] {q, r};
    }
}
