package Board;

public class PuttingCourse implements Function2d {

    private double  out_of_bounds_height;
    private double friction_coefficient;//for now just a coefficient for the entire field, later a function like height
    private double maximum_velocity;
    private double hole_tolerance;
    private Function2d height;
    private Vector2d flag;
    private Vector2d start;
    private double[][] board;
    private Ball ball;


    public PuttingCourse(double[][] board, Vector2d flag, Vector2d start, double friction_coefficient,
                         double maximum_velocity, double hole_tolerance, double out_of_bounds_height, Ball ball) {

        this.ball = ball;
        this.board = board;
        this.height = height;
        this.flag = flag;
        this.start = start;
        this.friction_coefficient = friction_coefficient;
        this.maximum_velocity = maximum_velocity;
        this.hole_tolerance = hole_tolerance;
        this.out_of_bounds_height = out_of_bounds_height;
    }

    public PuttingCourse() {

        System.out.println("Default Constructor");
    }

    // Evaluate the height of a vector with its x and y position on the game board
    @Override
    public double evaluate_height(Vector2d p) {

        double x = p.get_x();
        double y = p.get_y();
        if (x < 0 || y < 0 || x > board.length-1 || y > board[0].length-1) {
            return out_of_bounds_height;
        }
        if (x == Math.floor(x) && y == Math.floor(y)) {
            return board[(int) x][(int) y];
        }
        double x_diff = x - Math.floor(x);
        double y_diff = y - Math.floor(y);
        double n1 = board[(int) Math.floor(x)][(int) Math.floor(y)];
        double n2;
        if (x >= board.length-1 || y >= board[0].length-1) {
            n2 = 1;
        }
        else {
            n2 =  board[(int) Math.floor(x + 1)][(int) Math.floor(y + 1)];
        }

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

        double x = p.get_x();
        double y = p.get_y();

        double x1;
        double y1;

        double step = 0.1;

        x1 = evaluate_height(new Vector2d(x+step, y)) - evaluate_height(new Vector2d(x-step, y));
        y1 = evaluate_height(new Vector2d(x, y+step)) - evaluate_height(new Vector2d(x, y-step));

        p = new Vector2d(x1, y1);
        return p;
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

    // Return the maximum velocity of the start vector
    public double get_maximum_velocity() {

        return maximum_velocity;
    }

    // Return the winning tolerance of the hole
    public double get_hole_tolerance() {

        return hole_tolerance;
    }

    // Return the outside of the array height
    public double getOut_of_bounds_height() {

        return out_of_bounds_height;
    }

    public Ball getBall(){
        return ball;
    }
}

