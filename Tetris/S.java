
public class S extends Tetrimino
{

    public S(int x, int y, GamePanel p)
    {
        super(java.awt.Color.GREEN, p);
        // initialise instance variables
        this.setLocation(x,y);
    }

    public void setLocation(int x, int y)
    {
        _x = x;
        _y = y;
        _block4.setLocation(x+TetrisConstants.BLOCK_SIZE,y);
        _block2.setLocation(x+(2*TetrisConstants.BLOCK_SIZE),y);
        _block3.setLocation(x,y+TetrisConstants.BLOCK_SIZE);
        _block1.setLocation(x+TetrisConstants.BLOCK_SIZE,y+TetrisConstants.BLOCK_SIZE);
    }
}
