public class QuadraticEquation {

    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getX() {
        double sqrt = Math.sqrt(b * b - 4 * a * c);
        return new double[]{
                (-b + sqrt) / 2 * a,
                (-b - sqrt) / 2 * a
        };
    }

}
