package Board;

public interface Function2d {

    double evaluate_height(Vector2d p, double out_of_bounds_height);
    double evaluate_friction(Vector2d p);
    Vector2d gradient(Vector2d p);
}