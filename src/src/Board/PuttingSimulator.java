package Board;

import Physics.EulerSolver;
import Physics.PhysicsEngine;

public class PuttingSimulator extends EulerSolver {

    private PuttingCourse course;
    private PhysicsEngine engine;
    Vector2d position = new Vector2d(0, 0);
    Vector2d velocity = new Vector2d(0, 0);
    Vector2d acceleration;

    public PuttingSimulator(PuttingCourse course, PhysicsEngine engine) {

        this.course = course;
        this.engine = engine;
    }

    public void set_ball_position(Vector2d p) {
        Vector2d np = new Vector2d(x, y);   

        course.getBall().setLocation(p);
    }

    public void get_ball_position() {

        course.getBall().getLocation();
    }

    public void take_shot(Vector2d initial_ball_acceleration) {
        acceleration= initial_ball_acceleration;


        
    }
}