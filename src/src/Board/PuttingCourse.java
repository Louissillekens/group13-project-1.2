package Board;

public class PuttingCourse implements Function2d {

    private double friction_coefficient;//for now just a coefficient for the entire field, later a function like height
    private double maximum_velocity;
    private double hole_tolerance;
    private Function2d height;
    private Vector2d flag;
    private Vector2d start;
    private double[][] board;

    public PuttingCourse(double[][] board, Function2d height, Vector2d flag, Vector2d start,
                         double friction_coefficient, double maximum_velocity, double hole_tolerance) {

        this.board = board;
        this.height = height;
        this.flag = flag;
        this.start = start;
        this.friction_coefficient = friction_coefficient;
        this.maximum_velocity = maximum_velocity;
        this.hole_tolerance = hole_tolerance;
    }

    // Evaluate the height of a vector with its x and y position on the game board
    @Override
    public double evaluate_height(Vector2d p, double out_of_bounds_height) {

        double x = p.get_x();
        double y = p.get_y();
        if (x < 0 || y < 0 || x >= board.length || y >= board.length) {
            return out_of_bounds_height;
        }
        double x_diff = x - Math.floor(x);
        double y_diff = y - Math.floor(y);
        double n1 = board[(int) Math.floor(x)][(int) Math.floor(y)];
        double n2 = board[(int) Math.floor(x)][(int) Math.floor(y)];

        return ((x_diff + y_diff)/2) * (n2-n1)+n1;
    }

    // Evaluate the friction coefficient of a vector wrt slope and ground
    @Override
    public double evaluate_friction(Vector2d p) {

        // TODO implement a friction evaluator
        return 0;
    }

    @Override
    public Vector2d gradient(Vector2d p) {

        // TODO implement the gradient method
        return start;
    }

    // Return an object of type Function2d
    // Access to the height of a location on the field by doing get_height.evaluate_height(Vector2d p);
    public Function2d get_height() {

        return height;
    }

    // Return the flag given in the constructor
    // Access to the position with the Vector2d methods
    public Vector2d get_flag_position() {

        return flag;
    }

    // Return the given start vector in the constructor
    // Access to the position with the Vector2d methods
    public Vector2d get_start_position() {

        return start;
    }

    // Return the friction coefficient of the start vector
    public double get_friction_coefficient() {

        return friction_coefficient;
    }

    // Return the maximum velocity on this course
    public double get_maximum_velocity() {

        return maximum_velocity;
    }

    // Return the winning tolerance of the hole
    public double get_hole_tolerance() {

        return hole_tolerance;
    }
}