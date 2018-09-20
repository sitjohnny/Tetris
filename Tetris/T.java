
public class T extends Tetrimino
{
    public T(int x, int y, GamePanel p)
    {
        super(new java.awt.Color(100,50,150), p);
        this.setLocation(x,y);
    }

    public void setLocation(int x, int y)
    {
        _x = x;
        _y = y;
        _block2.setLocation(x,y);
        _block1.setLocation(x+TetrisConstants.BLOCK_SIZE,y);
        _block3.setLocation(x+(2*TetrisConstants.BLOCK_SIZE),y);
        _block4.setLocation(x+TetrisConstants.BLOCK_SIZE,y+TetrisConstants.BLOCK_SIZE);
    }
}
