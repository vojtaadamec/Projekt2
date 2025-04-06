package pro1.drawingModel;

public abstract class XYShape implements Drawable
{
    protected int x;
    protected int y;

    public XYShape(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
