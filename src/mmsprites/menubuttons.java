package mmsprites;

import windows.MenuWindow;
import menu.MainMenu;
import Controls.Keybinds;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class menubuttons extends menusprites {

    Keybinds cont = new Keybinds();

    public void getmenubuttons() {
        try {
            playbu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/playbut.png"));
            editorbu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/editorbutton.png"));
            optionsbu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/optionsbutton.png"));
            exitbu = ImageIO.read(getClass().getResourceAsStream("/menubuttons/exitbutton.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(playbu, 150, 400, null);
        g2.drawImage(editorbu, 150, 550, null);
        g2.drawImage(optionsbu, 150, 700, null);
        g2.drawImage(exitbu, 150, 850, null);
    }

    public menubuttons() {
        getmenubuttons();
    }

    public void mbuttons (JFrame window) {
        JButton exbutton = new JButton();
        JButton opbutton = new JButton();
        JButton backbutton = new JButton();
        JButton playbutton = new JButton();
        JButton editorbutton = new JButton();
        exbutton.setBounds(150, 850, 300, 100);
        window.add(exbutton);
        exbutton.setOpaque(false);

        exbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        opbutton.setBounds(150, 700, 300, 100);
        window.add(opbutton);
        opbutton.setOpaque(false);

        opbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.gameStates.gameState = 3;
                }
        });
        }
    }


