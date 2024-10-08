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
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.reverseYDirection();
        }

        for (int i = bricks.size() - 1; i >= 0; i--) {
            Brick brick = bricks.get(i);
            if (ball.getBounds().intersects(brick.getBounds())) {
                ball.reverseYDirection();
                bricks.remove(i);
                score++;
                break;
            }
        }

        if (ball.getY() > getHeight()) {
            timer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        for (Brick brick : bricks) {
            g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
        }

        g.setColor(Color.GREEN);
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());

        g.setColor(Color.WHITE);
        g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());

        g.drawString("Score: " + score, 10, 20);
    }
}
