import java.util.TreeMap;

public abstract class Polynomial<T extends Number> {
    private final TreeMap<Integer, T> coefficients;

    public Polynomial() {
        coefficients = new TreeMap<>();
    }

    public Polynomial(TreeMap<Integer, T> coefficients) {
        this.coefficients = new TreeMap<>(coefficients);
    }

    public TreeMap<Integer, T> getCoefficients() {
        return new TreeMap<>(coefficients);
    }

    public boolean isNull() {
        return coefficients.isEmpty();
    }

    public int getDegree() {
        return isNull() ? 0 : coefficients.lastKey();
    }

    public T getCoefficient(int exp) {
        return coefficients.get(exp);
    }

    public void setCoefficient(int exp, T value) {
        coefficients.put(exp, value);
    }

    public void removeCoefficient(int exp) {
        coefficients.remove(exp);
    }

    public abstract void addCoefficient(int exp, T value);
}
