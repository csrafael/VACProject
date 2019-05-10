package fractal;

import javax.swing.*;
import java.awt.*;

public class Sierpinski extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recursion;
	
	public Sierpinski(Dimension dimension, int recursion) {
		// TODO Auto-generated constructor stub
        setSize(dimension);
        setPreferredSize(dimension);
		this.recursion = recursion;
	}
	
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Dimension d = getSize();
	    
        Point a = mid(new Point(0, 0), new Point(d.width, 0));
	    Point b = new Point(d.width, d.height);
	    Point c = new Point(0, d.height);
	    
        drawTriangle(g2, a, b, c,recursion);
    }
	
    public void drawTriangle(Graphics2D g, Point a, Point b, Point c, int rec) {
        g.drawLine(a.x, a.y, b.x, b.y);
        g.drawLine(b.x, b.y, c.x, c.y);
        g.drawLine(c.x, c.y, a.x, a.y);

        if(rec==1) {
            return;
        }

        Point ab = mid(a, b);
        Point bc = mid(b, c);
        Point ca = mid(c, a);

        drawTriangle(g, a, ab, ca, rec-1);
        drawTriangle(g, ab, b, bc, rec-1);
        drawTriangle(g, c, ca, bc, rec-1);
    }
	
	
	public static Point mid(Point a, Point b) {
		return new Point((a.x+b.x)/2, (a.y+b.y)/2);
	}
}