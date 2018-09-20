
public class I extends Tetrimino
{
    public I(int x, int y, GamePanel p)
    {
        super(java.awt.Color.CYAN, p);
        this.setLocation(x,y);
    }

    public void setLocation(int x, int y)
    {
        _x = x;
        _y = y;
        _block3.setLocation(x,y);
        _block2.setLocation(x,y+TetrisConstants.BLOCK_SIZE);
        _block1.setLocation(x,y+(2*TetrisConstants.BLOCK_SIZE));
        _block4.setLocation(x,y+(3*TetrisConstants.BLOCK_SIZE));
    }
}
