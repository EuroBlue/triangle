import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

class Shape extends Path2D.Double
{
    public Shape(Point2D A,Point2D B, Point2D C)
    {
        Point2D[] points={A,B,C};
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
}