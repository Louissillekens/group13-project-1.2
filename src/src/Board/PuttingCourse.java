package Board;

public class PuttingCourse{

    private Function2d height;
    private Vector2d flag;
    private Vector2d start;

    public PuttingCourse(Function2d height, Vector2d flag, Vector2d start) {

        this.height = height;
        this.flag = flag;
        this.start = start;
    }

    // Return an object of type Function2d
    // Access to the height of a vector by doing height.evaluate(Vector2d p);
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

        return start.get_mu();
    }

    // Return the maximum velocity of the start vector
    public double get_maximum_velocity() {

        return start.get_vmax();
    }

    // Return the winning tolerance of the hole
    public double get_hole_tolerance() {

        return flag.get_tolerance();
    }
}