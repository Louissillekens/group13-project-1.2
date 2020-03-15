package Physics;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.UnaryOp.Sqrt;

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
    public double get_resistance(double x, double y){
        //TODO
        double res =?;
        return res;
    }
    public double get_height(double x, double y){
        //TODO
        double h = ?;
        return h;
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
        ax= ax -g*(get_height(Px,Py)-get_height(Pxprev, Pyprev))-get_resistance(Px,Py)*g*(Vx/Math.sqrt(Vx*Vx +Vy*Vy));
        ay= ay -g*(get_height(Px,Py)-get_height(Pxprev, Pyprev))-get_resistance(Px,Py)*g*(Vy/Math.sqrt(Vx*Vx +Vy*Vy));

    }



    

}