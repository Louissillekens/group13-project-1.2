public class PuttingCourse {

    private Function2d height;
    private Vector2d flag;
    private Vector2d start;

    public PuttingCourse(Function2d height, Vector2d flag, Vector2d start){

        this.height = height;
        this.flag = flag;
        this.start = start;
    }

    public Function2d get_height(){

        return height;
    }

    public Vector2d get_flag_position(){

        return flag;
    }

    public Vector2d get_start_position(){

        return start;
    }

    public double get_friction_coefficient(){


        //TODO finish this method
        return 0;
    }

    public double get_maximum_velocity(){

        //TODO finish this method
        return 0;
    }

    public double get_hole_tolerance(){

        //TODO finish this method
        return 0;
    }
}