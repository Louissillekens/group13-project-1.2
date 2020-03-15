package Physics;

public class EulerSolver implements PhysicsEngine {
    double dt;
    double Px;
    double Pxprev;
    double Py;
    double Pyprev;
    double Vx;
    double Vy;
    double ax;
    double ay;
    double resistance;
    double height;
    final double g = 9.81;

    public void set_step_size(double h){
        dt= h;
    }
    public void set_start_acceleration(double x, double y){
        ax =x;
        ay= y;
    }
    public void reset_ball(){
        Px=0;
        Py=0;
        Vx=0;
        Vy=0;
    }
    public void set_resistance(double x, double y){
        //TODO
        resistance = ?;
    }
    public void set_height(double x, double y){
        //TODO
        height = ?;
    }
    public void update_p(){
        Pxprev=Px;
        Pyprev=Py;
        Px= Px+Vx*dt;
        Py= Py+Vy*dt;
    }
    public void update_v(){
        Vx= Vx+ax*dt;
        Vy= Vy+ay*dt;
    }
    public void update_a(){
        ax=
        ay=

    }



    

}