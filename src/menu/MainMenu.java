package menu;

import Controls.Keybinds;
import mmsprites.menubuttons;
import mmsprites.optionbuttons;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel implements Runnable {
    final int maxScreenRow = 1920;
    final int maxScreenColumn = 1080;

    public Thread gameThread;
    Sound sound = new Sound();

    menubuttons mebuttons = new menubuttons();
    optionbuttons opbuttons = new optionbuttons();
    Keybinds cont = new Keybinds();

    int FPS  = 120;

    int x = 5;
    int y = 5;


    public void setupGame(JFrame window) {
        gameStates.gameState =  0; //gameStates.titleState;
        playMusic(0);
        mebuttons.mbuttons(window);
    }

    public void options(JFrame window) {
        gameStates.gameState =  3; //gameStates.optionsState;
        opbuttons.obuttons(window);
    }

    public class gameStates {
        public static int gameState;
    }

    public MainMenu() {
        this.setPreferredSize(new Dimension(maxScreenRow, maxScreenColumn));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(cont);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    int drawCount = 0;

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println(drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (gameThread != null) {
            x = x + 3;
            if (gameStates.gameState == 3) y += 3;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawRect(x, y, 100, 100);
        g.drawString(String.valueOf(gameStates.gameState), 10, 10);
        g.drawString(String.valueOf(x), 10, 25);

        Graphics2D g2 = (Graphics2D) g;

        switch (gameStates.gameState) {
            case 0:
                mebuttons.draw(g2);
                break;
            case 3:
                opbuttons.draw(g2);
                break;
        }
    }

    public void mainbuttons (JFrame window) throws InterruptedException {
        while (true) {
            switch (gameStates.gameState) {
                case 0:
                    mebuttons.mbuttons(window);
                    break;
                case 3:
                    opbuttons.obuttons(window);
                    break;
            }
            Thread.sleep(1000/FPS);
        }
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }
}
