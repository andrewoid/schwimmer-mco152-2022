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
        return new double[] {
                (-b + Math.sqrt(b*b - 4*a*c)) / 2*a,
                (-b - Math.sqrt(b*b - 4*a*c)) / 2*a
        };
    }

}
