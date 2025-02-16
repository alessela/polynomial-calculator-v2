import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialRegex {
    public static IntegerPolynomial parsePolynomial(String str) throws ParsePolynomialException {
        // verific mai intai daca stringul str respecta structura unui polinom
        String monomial_pattern = "(\\d*x(\\^\\d+)?|\\d+)";
        Pattern pattern = Pattern.compile("[+-]?"+monomial_pattern+"([+-]"+monomial_pattern+")*");
        Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) // daca nu respecta atunci ma opresc
            throw new ParsePolynomialException(str);

        //altfel voi extrage fiecare monom din stringul str folosind pattern-ul de mai jos
        IntegerPolynomial p = new IntegerPolynomial();
        pattern = Pattern.compile("[+-]*\\d*x(\\^\\d+)?|[+-]*\\d+");
        matcher = pattern.matcher(str);

        while(matcher.find()){
            String monomial = matcher.group();
            int coefficient, exp;
            if (!monomial.contains("x")){ // daca monomul nu contine 'x' atunci gradul sau va fi 0
                coefficient = Integer.parseInt(monomial);
                if (coefficient == 0) // daca coeficientul este 0, trec la urmatorul monom
                    continue;
                exp = 0;
            }
            else if (monomial.startsWith("x")) { // daca monomul incepe cu 'x'
                coefficient = 1;
                String[] parts = monomial.split("x"); //parts[0] = coeficientul, parts[1]=gradul
                exp = (parts.length == 0) ? 1 : Integer.parseInt(parts[1].substring(1));
            }
            else{
                String[] parts = monomial.split("x");
                coefficient = (parts[0].equals("+")) ? 1 : (parts[0].equals("-")) ? -1
                        : Integer.parseInt(parts[0]);

                if (coefficient == 0)
                    continue;
                exp = (parts.length == 1) ? 1 : Integer.parseInt(parts[1].substring(1));
            }
            p.addCoefficient(exp, coefficient);
        }
        return p;
    }
}
