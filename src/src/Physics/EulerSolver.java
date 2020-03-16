package Physics;

import Board.PuttingCourse;
import Board.Vector2d;

public class EulerSolver extends PuttingCourse {

    private double dt;
    private double Px;
    private double Pxprev;
    private double Py;
    private double Pyprev;
    private double Vx;
    private double Vy;
    private double ax;
    private double ay;
    private double resistance;
    private double height;
    private final double g = 9.81;

    public void set_step_size(double h) {

        dt = h;
    }

    public void set_start_acceleration(double x, double y) {

        ax = x;
        ay = y;
    }

    public void reset_ball() {

        Px=0;
        Py=0;
        Vx=0;
        Vy=0;
    }

    public void update_p() {

        Pxprev = Px;
        Pyprev = Py;
        Px= Px+Vx*dt;
        Py = Py+Vy*dt;
    }

    public void update_v() {

        Vx = Vx+ax*dt;
        Vy = Vy+ay*dt;
    }

    public void update_a() {

        ax = ax - g*(get_height(Px,Py)-get_height(Pxprev, Pyprev))-get_resistance(Px,Py)*g*(Vx/Math.sqrt(Vx*Vx +Vy*Vy));
        ay = ay - g*(get_height(Px,Py)-get_height(Pxprev, Pyprev))-get_resistance(Px,Py)*g*(Vy/Math.sqrt(Vx*Vx +Vy*Vy));
    }

    public double get_resistance(double x, double y) {

        Vector2d p = new Vector2d(x, y);
        return evaluate_friction(p);
    }

    public double get_height(double x, double y) {

        Vector2d p = new Vector2d(x, y);
        return evaluate_height(p);
    }
    public void update_all(){
        update_p();
        update_v();
        update_a();
    }
}