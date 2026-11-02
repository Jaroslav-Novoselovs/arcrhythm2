package mmsprites;

import windows.MenuWindow;
import menu.MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class optionbuttons extends menusprites {

    MenuWindow mwindow = new MenuWindow();
    menubuttons mnbuttons = new menubuttons();

    public void getoptionbuttons() {
        try {
            audiobu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/audiobutton.png"));
            graphicsbu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/graphicsbutton.png"));
            controlsbu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/controlsbutton.png"));
            backbu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/backbutton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

        public void draw(Graphics2D g2) {
            g2.drawImage(audiobu, 100, 50, null);
            g2.drawImage(graphicsbu, 450, 50, null);
            g2.drawImage(controlsbu, 800, 50, null);
            g2.drawImage(backbu, 1550, 50, null);
        }

        public optionbuttons() {
            getoptionbuttons();
        }

        public void obuttons(JFrame window) {
            JButton backbutton = new JButton();
            backbutton.setBounds(1550, 50, 300, 100);
            window.add(backbutton);
            backbutton.setOpaque(false);

            backbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainMenu.gameStates.gameState = 0;
                    if (MainMenu.gameStates.gameState == 0) {
                    }
                    }
            });
        }
    }

