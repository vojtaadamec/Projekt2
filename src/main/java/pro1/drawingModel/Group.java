package pro1.drawingModel;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Group implements Drawable
{
    private Drawable[] items;
    private double rotationDegrees;
    private double scaleX;
    private double scaleY;

    public Group(Drawable[] items, double rotationDegrees, double scaleX, double scaleY) {
        this.items = items;
        this.rotationDegrees = rotationDegrees;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public Group(Drawable drawable) {
    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform transform = g.getTransform();
        g.scale(scaleX,scaleY);
        g.rotate(rotationDegrees * Math.PI / 180);
        for (Drawable item : items)
        {
            item.draw(g);
        }
        g.setTransform(transform);
    }
}
