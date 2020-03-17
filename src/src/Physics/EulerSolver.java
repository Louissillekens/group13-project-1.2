package Physics;

import Board.PuttingCourse;
import Board.Vector2d;

public class EulerSolver extends PuttingCourse {

    private double dt;
    private Vector2d P;
    private Vector2d Pprev;
    private Vector2d V;
    private Vector2d a;
    private double resistance;
    private double height;
    private final double g = 9.81;

    public void set_step_size(double h) {

        dt = h;
    }

    public void set_start_acceleration(double x, double y) {
        Vector2d a = new Vector2d(x, y);
    }

    public void reset_ball() {
        Vector2d p = new Vector2d(0, 0);

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