import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Triangle extends JPanel
{
    private int iteration;
    private Point2D A;
    private Point2D B;
    private Point2D C;
    private Shape shape;
    private int depth;
    private Point2D tempA;
    private Point2D tempB;
    private Triangle[] triangles=new Triangle[3];
    Triangle(Window window, int z)
    {
        this.depth=z;
        int widht=(int)Math.round(((window.getHeigth()*2)/Math.sqrt(3))/2);
        this.iteration=0;
        this.A=new Point2D.Double((window.getWidth()/2)-widht,window.getHeigth());
        this.B=new Point2D.Double((window.getWidth()/2)+widht,window.getHeigth());
        this.C=new Point2D.Double(window.getWidth()/2,0);
        this.shape=new Shape(this.A,this.B,this.C);
        if(this.getIteration()<this.depth)
        {
            this.triangles[0]=new Triangle(this, -1);
            this.triangles[1]=new Triangle(this, 0);
            //this.triangles[2]=new Triangle(this, 1);
        }
    }
    Triangle(Triangle triangle, int locus)
    {
        this.iteration=triangle.iteration+1;
        this.depth=triangle.depth;
        if(locus==-1)
        {
            this.A=triangle.getA();
            this.B=new Point2D.Double((triangle.getA().getX()+triangle.getB().getX())/2,triangle.getA().getY());
            double height=((triangle.getC().getY()+Window.getHeigth())/2);
            this.C=new Point2D.Double((this.getA().getX()+this.getB().getX())/2,height);
        }
        else if (locus==0)
        {
            this.A=new Point2D.Double((triangle.getA().getX()+triangle.getB().getX())/2,triangle.getA().getY());
            this.B=triangle.getB();
            double height=((triangle.getC().getY()+Window.getHeigth())/2);
            this.C=new Point2D.Double((this.getA().getX()+this.getB().getX())/2,height);
        }
        else if (locus==1)
        {
            this.C=triangle.getC();
            this.A=new Point2D.Double(((triangle.getB().getX()-triangle.getA().getX())*0.25)+triangle.getA().getX(),(triangle.getA().getX()/2)+triangle.getC().getY());
            this.B=new Point2D.Double(((triangle.getB().getX()-triangle.getA().getX())*0.75)+triangle.getA().getX(),(triangle.getA().getX()/2)+triangle.getC().getY());
        }
        this.shape=new Shape(this.A,this.B,this.C);
        if(this.getIteration()<this.depth)
        {
            System.out.println("yes");
            this.triangles[0]=new Triangle(this, -1);
            this.triangles[1]=new Triangle(this, 0);
            //this.triangles[2]=new Triangle(this, 1);
        }
    }
    public void paintComponent(Graphics g)
    {
        if(this.getIteration()<this.depth)
        {
            for (Triangle t:this.triangles)
            {
                if (t == null) {
                    continue;
                }
                t.paintComponent(g);
            }
        }
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.draw(this.shape);
    }
    public int getIteration()
    {
        return iteration;
    }
    public Point2D getA()
    {
        return A;
    }
    public Point2D getB()
    {
        return B;
    }
    public Point2D getC()
    {
        return C;
    }
}