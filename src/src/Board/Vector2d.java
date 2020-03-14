package Board;

public class Vector2d {

    private double x;
    private double y;
    private double mu;
    private double g;
    private double vmax;
    private double tolerance;

    public Vector2d(double x, double y, double mu, double g, double vmax, double tolerance) {

        this.x = x;
        this.y = y;
        this.mu = mu;
        this.g = g;
        this.vmax = vmax;
        this.tolerance = tolerance;
    }

    // Get the x position of a vector
    public double get_x() {

        return x;
    }

    // Get the y position of a vector
    public double get_y() {

        return y;
    }

    // Get the coefficient of friction of a vector
    public double get_mu() {

        return mu;
    }

    // Get the gravity of a vector
    public double get_g() {

        return g;
    }

    // Get the max velocity of a vector
    public double get_vmax() {

        return vmax;
    }

    // Get the tolerance distance of a vector
    public double get_tolerance() {

        return tolerance;
    }
}