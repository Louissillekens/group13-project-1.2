package Board;

public class TestCourse {

    /*double[][] board = {{1   , 1.2 , 1.3 , 1.3 , 1.1 , 1   , 0   ,-1  },
                        {1.05, 1.15, 1.2 , 1.2 , 1.1 , 0.9 , 0.55, 0  },
                        {1.1 , 1.2 , 1.2 , 1.25, 1.34, 1   , 0.33, 0.1},
                        {1.43, 1.23, 1.18, 0.9 , 0.4 , 0   ,-0.4 ,-1.2}};*/

    double[][] board = new double[10][10];//a double array of 0's which gives a flat surface on which we can test stuff


    double out_of_bounds_height = 1;//outside of the array the height is just 1

    Vector2d start = new Vector2d(0,0);
    Vector2d hole = new Vector2d(7,6);

    final double gravity = 9.81;
    final double max_velocity = 3;
    final double hole_tolerance = 0.02;
    final double mu = 0.131; //for now this counts for the entire field but later we will need to make a map for this as well (friction can differ from place to place)
}
