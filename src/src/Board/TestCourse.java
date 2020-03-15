package Board;

public class TestCourse {

    static double[][] board1 = {{1   , 1.2 , 1.3 , 1.3 , 1.1 , 1   , 0   ,-1  },
                        {1.05, 1.15, 1.2 , 1.2 , 1.1 , 0.9 , 0.55, 0  },
                        {1.1 , 1.2 , 1.2 , 1.25, 1.34, 1   , 0.33, 0.1},
                        {1.43, 1.23, 1.18, 0.9 , 0.4 , 0   ,-0.4 ,-1.2}};

    static double[][] board2 = new double[10][10]; //a double array of 0's which gives a flat surface on which we can test stuff


    static double out_of_bounds_height = 1; //outside of the array the height is just 1

    static Vector2d start = new Vector2d(1,2);
    static Vector2d hole = new Vector2d(2,5);

    static Ball ball = new Ball(start, 5);

    static final double gravity = 9.81;
    static final double max_velocity = 3;
    static final double hole_tolerance = 0.02;
    static final double mu = 0.131; //for now this counts for the entire field but later we will need to make a map for this as well (friction can differ from place to place)

    public static void main(String[]args) {

        PuttingCourse test = new PuttingCourse(board1, hole, start, mu, max_velocity, hole_tolerance, out_of_bounds_height, ball);

        System.out.println(test.evaluate_height(start));
        // System.out.println(test.evaluate_friction(start)); // Still need to implement
        Vector2d p = test.gradient(start);
        System.out.println(p.get_x());
        System.out.println(p.get_y());
    }
}
