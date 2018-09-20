import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;

public class GamePanel extends JPanel implements ActionListener
{
    
    private PieceProxy _piece;
    private Timer _timer;
    private Random _generator;
    private SmartRectangle[][] _board;
    private KeyUpListener _upKey;
    private KeyDownListener _downKey;
    private KeyLeftListener _leftKey;
    private KeyRightListener _rightKey;
    private KeyPListener _pauseKey;
    private KeySpaceListener _spaceKey;
    private boolean _gameOver;
    
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel()
    {
        this.setBackground(Color.BLACK);
        this.setSize(new Dimension(TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_WIDTH), TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_HEIGHT)+15));
        this.setPreferredSize(new Dimension(TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_WIDTH), TetrisConstants.BLOCK_SIZE*(TetrisConstants.BOARD_HEIGHT)+15));

        _upKey = new KeyUpListener(this);
        _downKey = new KeyDownListener(this);
        _leftKey = new KeyLeftListener(this);
        _rightKey = new KeyRightListener(this);
        _pauseKey = new KeyPListener(this);
        _spaceKey = new KeySpaceListener(this);
        
        _board = new SmartRectangle[TetrisConstants.BOARD_HEIGHT][TetrisConstants.BOARD_WIDTH];   
        _generator = new Random();
        
        _piece = new PieceProxy();
        _piece.setPiece(tetriminoFactory());

        _timer = new Timer(500, this);
        _timer.start();

        _gameOver = false;
    }
    
    public Tetrimino tetriminoFactory()
    {
        Tetrimino newPiece;
        int randomNumber;
        
        int x = (TetrisConstants.BOARD_WIDTH/2) * TetrisConstants.BLOCK_SIZE;
        int y = 0;
        randomNumber = (int) (Math.floor(Math.random()*7)+1);
        switch(randomNumber) {
            case 1: newPiece = new Z(x,y,this);     break;
            case 2: newPiece = new S(x,y,this);     break;
            case 3: newPiece = new L(x,y,this);     break;
            case 4: newPiece = new J(x,y,this);     break;
            case 5: newPiece = new O(x,y,this);     break;
            case 6: newPiece = new I(x,y,this);     break;
            default: newPiece = new T(x,y,this);     break;
        }
        return newPiece;
    }
    
    public void paintComponent (java.awt.Graphics aBrush) 
    {
        super.paintComponent(aBrush);
        java.awt.Graphics2D betterBrush = (java.awt.Graphics2D)aBrush;
        for (int i = 0; i < _board.length; i++)
        {
            for (int j = 0; j < _board[i].length; j++)
            {
                if (_board[i][j] != null)
                {
                    _board[i][j].fill(betterBrush);
                    _board[i][j].draw(betterBrush);
                }
            }
        }
        _piece.fill(betterBrush);
        _piece.draw(betterBrush);
    }
    public boolean canMove(int c, int r)
    {
        if (isValid(c,r) && isFree(c,r)) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
       
    private boolean isFree(int c, int r)
    {
        if(_board[r][c] == null)
            return true;
        else
            return false;
    }

    private boolean isValid(int c, int r)
    {
        if(c >= 0 && c < TetrisConstants.BOARD_WIDTH && r >= 0 && r < TetrisConstants.BOARD_HEIGHT)
            return true;
        else
            return false;
    }
  
    public void addToBoard(SmartRectangle r)
    {
        int row = (int) r.getY() / TetrisConstants.BLOCK_SIZE;
        int col = (int) r.getX() / TetrisConstants.BLOCK_SIZE;
        _board[row][col] = r;
    }

    private void moveBlocksDown(int row)
    {
        for (int i = 0; i < _board[row].length; i++) 
        {
            if (_board[row][i] != null) 
            {
                _board[row][i].setLocation(i*TetrisConstants.BLOCK_SIZE, (row + 1)*TetrisConstants.BLOCK_SIZE);
            }
                _board[row + 1][i] = _board[row][i];
                _board[row][i] = null;
        }
    }

    private void checkRows(){
        for (int i = 0; i < _board.length; i++) 
        {
            boolean isFull = true;
            for (int j = 0; j < _board[i].length; j++) 
            {
                if (_board[i][j] == null)
                {
                    isFull = false;
                }
            }
            if (isFull)
            {
                for (int j = 0; j < _board[i].length; j++)
                {
                    _board[i][j] = null;
                }
                for (int r = i - 1; r >= 0; r--) {
                    moveBlocksDown(r);
                }
            }
        }
    }

    private boolean checkEndGame()
    {
            for (int j = 0; j < _board[0].length; j++)
            {
                if (_board[0][j] != null)
                {
                    _gameOver = true;
                }
            }
            return _gameOver;
    }
    public void actionPerformed(ActionEvent e)
    {if (_piece.moveDown() == false){
                if (checkEndGame() == true){
                    _timer.stop();
                }
                else{
                    _piece.setPiece(tetriminoFactory());
                    checkRows();
                    repaint();
                }
            }
            else{
            repaint();
        }
    }
    private class KeyUpListener extends KeyInteractor 
    {
        public KeyUpListener(JPanel p)
        {
            super(p,KeyEvent.VK_UP);
        }
        
        public  void actionPerformed (ActionEvent e) {
            _piece.turnRight();
            repaint();
        }
    }
    private class KeyDownListener extends KeyInteractor {
    
        public KeyDownListener(JPanel p){
                 super(p,KeyEvent.VK_DOWN);
        }
    
        public  void actionPerformed (ActionEvent e) {
            if (!_gameOver) {
                if (_piece.moveDown() == false){
                    if (checkEndGame() == true){
                        _timer.stop();
                    }
                    else{
                        _piece.setPiece(tetriminoFactory());
                        checkRows();
                        repaint();
                    }
                }
                else{
                repaint();
                }
            }
        }
    }
    private class KeyLeftListener extends KeyInteractor 
    {
        public KeyLeftListener(JPanel p)
        {
            super(p,KeyEvent.VK_LEFT);
        }
        
        public  void actionPerformed (ActionEvent e) {
            if (!_gameOver) {
                _piece.moveLeft();
                repaint();
            }
        }
    } 
    private class KeyRightListener extends KeyInteractor 
    {
        public KeyRightListener(JPanel p)
        {
            super(p,KeyEvent.VK_RIGHT);
        }
        
        public void actionPerformed (ActionEvent e) {
            if (!_gameOver) {
                _piece.moveRight();
                repaint();
            }
        }
    }
    private class KeyPListener extends KeyInteractor 
    {
        public KeyPListener(JPanel p)
        {
            super(p,KeyEvent.VK_P);
        }
        
        public  void actionPerformed (ActionEvent e) {
            if (!_gameOver) {
                if(_timer.isRunning()){
                    _timer.stop();
                }
                else
                    _timer.start();
            }
        }
    }
    
    private class KeySpaceListener extends KeyInteractor
    {
        public KeySpaceListener(JPanel p)
        {
            super(p, KeyEvent.VK_SPACE);
        }
        public void actionPerformed(ActionEvent e)
        {
            if (!_gameOver) 
            {
                while(_piece.moveDown()) 
                    repaint();
            }
        }
    }
    
}
