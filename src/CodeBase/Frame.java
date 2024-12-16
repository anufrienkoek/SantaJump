package CodeBase;

import util.Resource;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Frame extends JFrame {

    private static final Dimension SIZE;

    static {
        var screenHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()) - 100;

        if (screenHeight > 800)
            screenHeight = 800;

        SIZE = new Dimension(500, screenHeight);
    }
    private final GamePanel gamePanel;

    public Frame() {
        super();
        this.setIconImage(Resource.getImage("doodle.png"));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setSizeWithoutInsets(SIZE);
        this.setLocationRelativeTo(null);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println("Error " + ex);
        }

        this.setTitle(0);
        this.gamePanel = new GamePanel(SIZE);
        this.gamePanel.setNewGameListener(new NewGameListener() {

            @Override
            public void updateScore(int score) {
                setTitle(score);
            }

            @Override
            public void gameOver() {
                setTitle(0);
            }
        });
        this.add(this.gamePanel);
        this.gamePanel.requestFocus();
    }

    public void start() {
        JOptionPane.showOptionDialog(null, "Konstantin Aleksandrovich, are u ready...?",
                "gogogo", JOptionPane.OK_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new String[]{"poexali!"},
                0);
        this.gamePanel.start();
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setVisible(true);
        f.start();
    }

    private void setTitle(int points)
    {
        this.setTitle("Doodle Jump - " + points + " points");
    }

    private void setSizeWithoutInsets(Dimension d) {
        Insets i = this.getInsets();
        this.setSize(d.width + i.left + i.right, d.height + i.top + i.bottom);
    }
}



