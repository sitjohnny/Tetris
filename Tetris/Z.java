
public class Z extends Tetrimino
{
    public Z(int x, int y, GamePanel p)
    {
        super(java.awt.Color.RED, p);
        this.setLocation(x,y);
    }

    public void setLocation(int x, int y)
    {
        _x = x;
        _y = y;
        _block3.setLocation(x,y);
        _block2.setLocation(x+TetrisConstants.BLOCK_SIZE,y);
        _block1.setLocation(x+TetrisConstants.BLOCK_SIZE,y+TetrisConstants.BLOCK_SIZE);
        _block4.setLocation(x+(2*TetrisConstants.BLOCK_SIZE),y+TetrisConstants.BLOCK_SIZE);
    }
}
