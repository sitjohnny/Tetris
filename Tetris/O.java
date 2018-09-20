
public class O extends Tetrimino
{
    public O(int x, int y, GamePanel p)
    {
        super(java.awt.Color.YELLOW, p);
        // initialise instance variables
        this.setLocation(x,y);
    }

    public void setLocation(int x, int y)
    {
        _x = x;
        _y = y;
        _block4.setLocation(x,y);
        _block2.setLocation(x,y+TetrisConstants.BLOCK_SIZE);
        _block3.setLocation(x+TetrisConstants.BLOCK_SIZE,y);
        _block1.setLocation(x+TetrisConstants.BLOCK_SIZE,y+TetrisConstants.BLOCK_SIZE);
    }
    public boolean turnLeft(){return true;}
    public boolean turnRight(){return true;}
}
