package Board;

import Physics.PhysicsEngine;

public class PuttingSimulator {

    private PuttingCourse course;
    private PhysicsEngine engine;

    public PuttingSimulator(PuttingCourse course, PhysicsEngine engine) {

        this.course = course;
        this.engine = engine;
    }

    public void set_ball_position(Vector2d p) {

        course.getBall().setLocation(p);
    }

    public void get_ball_position() {

        course.getBall().getLocation();
    }

    public void take_shot(Vector2d initial_ball_velocity) {

        //TODO finish this method
    }
}