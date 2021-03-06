package Physics;

import Board.Friction_function;
import Board.Height_function;
import Board.Vector2d;
public class Rungakuttasolver{
    double g = 9.81;
    double mu;
    double x;
    double y;

    //needs to be linked to the game to know the x and y values
    void updatecoordinates(){
        x= getx();
        y= gety();
    }

    //needs to use a method that sets mu based on the position
    void updatemu(x,y){
        mu = getmu(x,y);
    }
    //these calculate the x and y acceleration values
    double xii(double x, double y, double xi, double yi){
        return hx(x,y) - (mu * g* xi)/(sqrt(xi^2+yi^2));
    }
    double yii(double x, double y, double xi, double yi){
        return hy(x,y) - (mu * g* yi)/(sqrt(xi^2+yi^2));
    }
    //in these next 2 methods h(x,y) is a method that returns the height of the ball with an x and y input and these methods return the velocities in both x and y directions
    double dzdx(double x, double y, double dx){
        return ((h(x+dx,y)-h(x+y))/dx);
    }
    double dzdy(double x, double y, double dy){
        return ((h(x,y+dy)-h(x+y))/dy);
    }
    double[] Rungakutta(double x0, double y0, double x, double n){
        int h=((x-x0)/n);
        Rungakuttasolver x = new Rungakuttasolver();
        double k1;
        double k2;
        double k3;
        double k4;
        double yr = y0;
        double xr = x0;
        for(int i =0;i<n;i++){
            k1x = h*(x.dzdx(x0,yr,h));
            k1y = h*(x.dzdy(xr,y0,h));
            k2x = h*(x.dzdx(x0+0.5*h,yr+0.5*k1x,h));
            k2y = h*(x.dzdy(xr+0.5*k1y,y+0.5*h,h));
            k3x = h*(x.dzdx(x0+0.5*h,yr+0.5*k2x,h));
            k3y = h*(x.dzdy(xr+0.5*k2y,y+0.5*h,h));
            k4x = h*(x.dzdx(x0+h,yr+k3x,h));
            k4y = h*(x.dzdy(xr+k3y,y0+h,h));
            yr=yr + (1/6)*(k1x+2*k2x+2*k3x+k4x);
            xr=xr + (1/6)*(k1y+2*k2y+2*k3y+k4y);
            x0=x0+h;
            y0=y0+h;
        }
        double[] estimate = {xr,yr};
        return estimate;
    }
}