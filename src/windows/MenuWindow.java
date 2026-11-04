package windows;

import menu.MainMenu;
import mmsprites.menubuttons;
import Controls.Keybinds;

import javax.swing.*;

public class MenuWindow extends JFrame {
    public void MenuWindows() throws InterruptedException {

        Keybinds cont = new Keybinds();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Arcrhythm");
        window.setUndecorated(true);

        MainMenu menu = new MainMenu();
        window.add(menu);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        menu.startGameThread();
        menu.setupGame(window);

        menu.mainbuttons(window);

    }
}
