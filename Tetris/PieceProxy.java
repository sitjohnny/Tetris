
public class PieceProxy implements Animatable
{
    private Animatable _p;     

    public void setPiece(Animatable m)
    {
        _p = m;
    }
    public void fill (java.awt.Graphics2D aBrush){
    _p.fill(aBrush);
    }
    public void draw (java.awt.Graphics2D aBrush) {
    _p.draw(aBrush);
    }
    public boolean moveUp()
    {
        return _p.moveUp();
    }
    public boolean moveDown()
    {
        return _p.moveDown();
    }    
    public boolean moveLeft()
    {
        return _p.moveLeft();
    }
    public boolean moveRight()
    {
        return _p.moveRight();
    }
    public boolean turnLeft()
    {
        return _p.turnLeft();
    }
    public boolean turnRight()
    {
        return _p.turnRight();
    }
   
}
