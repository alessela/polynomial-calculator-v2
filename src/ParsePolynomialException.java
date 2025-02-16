public class ParsePolynomialException extends Exception {
    public ParsePolynomialException(String expression) {
        super("Error: Polynomial expression " + expression + " is not valid");
    }
}
