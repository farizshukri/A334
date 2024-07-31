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
