
public abstract class Tetrimino implements Animatable
{
    protected SmartRectangle _block1, _block2, _block3, _block4;
    protected int _x, _y;
    protected java.awt.Color _color;
    protected GamePanel _panel;


    public Tetrimino (java.awt.Color color, GamePanel p) {
        _color = color;
        _panel = p;
        _block1 = new SmartRectangle(_color);
        _block1.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block2 = new SmartRectangle(_color);
        _block2.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block3 = new SmartRectangle(_color);
        _block3.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block4 = new SmartRectangle(_color);
        _block4.setSize(TetrisConstants.BLOCK_SIZE,TetrisConstants.BLOCK_SIZE);
        _block1.setBorderColor(java.awt.Color.WHITE);
        _block2.setBorderColor(java.awt.Color.WHITE);
        _block3.setBorderColor(java.awt.Color.WHITE);
        _block4.setBorderColor(java.awt.Color.WHITE);
    }
    public void draw(java.awt.Graphics2D aBrush)
    {
        _block1.draw(aBrush);
        _block2.draw(aBrush);
        _block3.draw(aBrush);
        _block4.draw(aBrush);
    }
    public void fill(java.awt.Graphics2D aBrush)
    {
        _block1.fill(aBrush);
        _block2.fill(aBrush);
        _block3.fill(aBrush);
        _block4.fill(aBrush);
    }
    public abstract void setLocation(int x, int y);
    public boolean moveLeft()
    {
        int newX1, newY1, newX2, newY2, newX3, newY3, newX4, newY4;
        newX1 = (int)_block1.getX()-TetrisConstants.BLOCK_SIZE;
        newY1 = (int)_block1.getY();
        newX2 = (int)_block2.getX()-TetrisConstants.BLOCK_SIZE;
        newY2 = (int)_block2.getY();
        newX3 = (int)_block3.getX()-TetrisConstants.BLOCK_SIZE;
        newY3 = (int)_block3.getY();
        newX4 = (int)_block4.getX()-TetrisConstants.BLOCK_SIZE;
        newY4 = (int)_block4.getY();
                    
        int X1 = (int) Math.round(newX1 / TetrisConstants.BLOCK_SIZE);
        int Y1 = (int) Math.round(newY1 / TetrisConstants.BLOCK_SIZE);
        int X2 = (int) Math.round(newX2 / TetrisConstants.BLOCK_SIZE);
        int Y2 = (int) Math.round(newY2 / TetrisConstants.BLOCK_SIZE);
        int X3 = (int) Math.round(newX3 / TetrisConstants.BLOCK_SIZE);
        int Y3 = (int) Math.round(newY3 / TetrisConstants.BLOCK_SIZE);
        int X4 = (int) Math.round(newX4 / TetrisConstants.BLOCK_SIZE);
        int Y4 = (int) Math.round(newY4 / TetrisConstants.BLOCK_SIZE);
        
        boolean canMove1 = _panel.canMove(X1, Y1);
        boolean canMove2 = _panel.canMove(X2, Y2);
        boolean canMove3 = _panel.canMove(X3, Y3);
        boolean canMove4 = _panel.canMove(X4, Y4);
        
        if (canMove1 && canMove2 && canMove3 && canMove4)
        {
            _block1.setLocation(newX1, newY1);
            _block2.setLocation(newX2, newY2);
            _block3.setLocation(newX3, newY3);
            _block4.setLocation(newX4, newY4);
            return true;
        }
        return false;
    }
    public boolean moveRight()
    {
        int newX1, newY1, newX2, newY2, newX3, newY3, newX4, newY4;
        newX1 = (int)_block1.getX()+TetrisConstants.BLOCK_SIZE;
        newY1 = (int)_block1.getY();
        newX2 = (int)_block2.getX()+TetrisConstants.BLOCK_SIZE;
        newY2 = (int)_block2.getY();
        newX3 = (int)_block3.getX()+TetrisConstants.BLOCK_SIZE;
        newY3 = (int)_block3.getY();
        newX4 = (int)_block4.getX()+TetrisConstants.BLOCK_SIZE;
        newY4 = (int)_block4.getY();
        
        int X1 = (int) Math.round(newX1 / TetrisConstants.BLOCK_SIZE);
        int Y1 = (int) Math.round(newY1 / TetrisConstants.BLOCK_SIZE);
        int X2 = (int) Math.round(newX2 / TetrisConstants.BLOCK_SIZE);
        int Y2 = (int) Math.round(newY2 / TetrisConstants.BLOCK_SIZE);
        int X3 = (int) Math.round(newX3 / TetrisConstants.BLOCK_SIZE);
        int Y3 = (int) Math.round(newY3 / TetrisConstants.BLOCK_SIZE);
        int X4 = (int) Math.round(newX4 / TetrisConstants.BLOCK_SIZE);
        int Y4 = (int) Math.round(newY4 / TetrisConstants.BLOCK_SIZE);
        
        boolean canMove1 = _panel.canMove(X1, Y1);
        boolean canMove2 = _panel.canMove(X2, Y2);
        boolean canMove3 = _panel.canMove(X3, Y3);
        boolean canMove4 = _panel.canMove(X4, Y4);
        
        if (canMove1 && canMove2 && canMove3 && canMove4)
        {
            _block1.setLocation(newX1, newY1);
            _block2.setLocation(newX2, newY2);
            _block3.setLocation(newX3, newY3);
            _block4.setLocation(newX4, newY4);
            return true;
        }
        return false;
    }
    public boolean moveDown()
    {
        int newX1, newY1, newX2, newY2, newX3, newY3, newX4, newY4;
        newX1 = (int)_block1.getX();
        newY1 = (int)_block1.getY()+TetrisConstants.BLOCK_SIZE;
        newX2 = (int)_block2.getX();
        newY2 = (int)_block2.getY()+TetrisConstants.BLOCK_SIZE;
        newX3 = (int)_block3.getX();
        newY3 = (int)_block3.getY()+TetrisConstants.BLOCK_SIZE;
        newX4 = (int)_block4.getX();
        newY4 = (int)_block4.getY()+TetrisConstants.BLOCK_SIZE;

        int X1 = (int) Math.round(newX1 / TetrisConstants.BLOCK_SIZE);
        int Y1 = (int) Math.round(newY1 / TetrisConstants.BLOCK_SIZE);
        int X2 = (int) Math.round(newX2 / TetrisConstants.BLOCK_SIZE);
        int Y2 = (int) Math.round(newY2 / TetrisConstants.BLOCK_SIZE);
        int X3 = (int) Math.round(newX3 / TetrisConstants.BLOCK_SIZE);
        int Y3 = (int) Math.round(newY3 / TetrisConstants.BLOCK_SIZE);
        int X4 = (int) Math.round(newX4 / TetrisConstants.BLOCK_SIZE);
        int Y4 = (int) Math.round(newY4 / TetrisConstants.BLOCK_SIZE);
        
        boolean canMove1 = _panel.canMove(X1, Y1);
        boolean canMove2 = _panel.canMove(X2, Y2);
        boolean canMove3 = _panel.canMove(X3, Y3);
        boolean canMove4 = _panel.canMove(X4, Y4);
        
        if (canMove1 && canMove2 && canMove3 && canMove4)
        {
            _block1.setLocation(newX1, newY1);
            _block2.setLocation(newX2, newY2);
            _block3.setLocation(newX3, newY3);
            _block4.setLocation(newX4, newY4);
            return true;
        }
        else
        {
            _panel.addToBoard(_block1);
            _panel.addToBoard(_block2);
            _panel.addToBoard(_block3);
            _panel.addToBoard(_block4);
            return false;
        }
    }
    public final boolean moveUp(){return false;}
    public boolean turnLeft()
    {
        int newX1, newY1, newX2, newY2, newX3, newY3, newX4, newY4;
        
        newX1 = (int)_block1.getX();
        newY1 = (int)_block1.getY();
        newX2 = (int)(newX1 + newY1 - _block2.getY());
        newY2 = (int)(newY1 - newX1 + _block2.getX());
        newX3 = (int)(newX1 + newY1 - _block3.getY());
        newY3 = (int)(newY1 - newX1 + _block3.getX());
        newX4 = (int)(newX1 + newY1 - _block4.getY());
        newY4 = (int)(newY1 - newX1 + _block4.getX());
        
        int X1 = (int) Math.round(newX1 / TetrisConstants.BLOCK_SIZE);
        int Y1 = (int) Math.round(newY1 / TetrisConstants.BLOCK_SIZE);
        int X2 = (int) Math.round(newX2 / TetrisConstants.BLOCK_SIZE);
        int Y2 = (int) Math.round(newY2 / TetrisConstants.BLOCK_SIZE);
        int X3 = (int) Math.round(newX3 / TetrisConstants.BLOCK_SIZE);
        int Y3 = (int) Math.round(newY3 / TetrisConstants.BLOCK_SIZE);
        int X4 = (int) Math.round(newX4 / TetrisConstants.BLOCK_SIZE);
        int Y4 = (int) Math.round(newY4 / TetrisConstants.BLOCK_SIZE);
        
        boolean canMove1 = _panel.canMove(X1, Y1);
        boolean canMove2 = _panel.canMove(X2, Y2);
        boolean canMove3 = _panel.canMove(X3, Y3);
        boolean canMove4 = _panel.canMove(X4, Y4);
        
        if (canMove1 && canMove2 && canMove3 && canMove4)
        {
            _block1.setLocation(newX1, newY1);
            _block2.setLocation(newX2, newY2);
            _block3.setLocation(newX3, newY3);
            _block4.setLocation(newX4, newY4);
            return true;
        }
        return false;
    }

    public boolean turnRight()
    {
        int newX1, newY1, newX2, newY2, newX3, newY3, newX4, newY4;
        
        newX1 = (int)_block1.getX();
        newY1 = (int)_block1.getY();
        newX2 = (int)(newX1 - newY1 + _block2.getY());
        newY2 = (int)(newY1 + newX1 - _block2.getX());
        newX3 = (int)(newX1 - newY1 + _block3.getY());
        newY3 = (int)(newY1 + newX1 - _block3.getX());
        newX4 = (int)(newX1 - newY1 + _block4.getY());
        newY4 = (int)(newY1 + newX1 - _block4.getX());
        
        int X1 = (int) Math.round(newX1 / TetrisConstants.BLOCK_SIZE);
        int Y1 = (int) Math.round(newY1 / TetrisConstants.BLOCK_SIZE);
        int X2 = (int) Math.round(newX2 / TetrisConstants.BLOCK_SIZE);
        int Y2 = (int) Math.round(newY2 / TetrisConstants.BLOCK_SIZE);
        int X3 = (int) Math.round(newX3 / TetrisConstants.BLOCK_SIZE);
        int Y3 = (int) Math.round(newY3 / TetrisConstants.BLOCK_SIZE);
        int X4 = (int) Math.round(newX4 / TetrisConstants.BLOCK_SIZE);
        int Y4 = (int) Math.round(newY4 / TetrisConstants.BLOCK_SIZE);
        
        boolean canMove1 = _panel.canMove(X1, Y1);
        boolean canMove2 = _panel.canMove(X2, Y2);
        boolean canMove3 = _panel.canMove(X3, Y3);
        boolean canMove4 = _panel.canMove(X4, Y4);
        
        if (canMove1 && canMove2 && canMove3 && canMove4)
        {
            _block1.setLocation(newX1, newY1);
            _block2.setLocation(newX2, newY2);
            _block3.setLocation(newX3, newY3);
            _block4.setLocation(newX4, newY4);
            return true;
        }
        return false;
    }
}