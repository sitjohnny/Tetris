
public class L extends Tetrimino
{
    public L(int x, int y, GamePanel p)
    {
        super(java.awt.Color.ORANGE, p);
        this.setLocation(x,y);
    }

    public void setLocation(int x, int y)
    {
        _x = x;
        _y = y;
        _block1.setLocation(x,y);
        _block2.setLocation(x,y+TetrisConstants.BLOCK_SIZE);
        _block3.setLocation(x,y+(2*TetrisConstants.BLOCK_SIZE));
        _block4.setLocation(x+TetrisConstants.BLOCK_SIZE,y+(2*TetrisConstants.BLOCK_SIZE));
    }
}
