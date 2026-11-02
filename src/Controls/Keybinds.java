package Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keybinds implements KeyListener {

    public boolean Back, Lane1, Lane2, Lane3, Lane4;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_ESCAPE) {
            Back = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_ESCAPE) {
            Back = false;
        }
    }
}
