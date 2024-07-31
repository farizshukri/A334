import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;

public class BrickBreakerPanel extends JPanel implements ActionListener {
    private Timer timer;
    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;
    private int score;

    public BrickBreakerPanel() {
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }
        });
        initGame();
    }

    private void initGame() {
        ball = new Ball(400, 300, -2, -3);
        paddle = new Paddle(350, 550);
        bricks = new ArrayList<>();
        createBricks();
        score = 0;
    }

    private void createBricks() {
        int brickWidth = 75;
        int brickHeight = 20;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                bricks.add(new Brick(100 + i * (brickWidth + 10), 50 + j * (brickHeight + 10), brickWidth, brickHeight));
            }
        }
    }

    public void startGame() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move();
        checkCollision();
        repaint();
    }

    private void checkCollision() {
       
    }

   
}
