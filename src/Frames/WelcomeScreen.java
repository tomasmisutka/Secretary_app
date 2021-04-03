package Frames;

import Components.WelcomeLabel;
import Components.Panels.ButtonsPanel;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame
{
    public WelcomeScreen()
    {
        super();
        this.initFrame();
    }

    private void initFrame()
    {
        WelcomeLabel welcomeLabel = new WelcomeLabel();
        ButtonsPanel buttonsPanel = new ButtonsPanel();

        this.setLayout(new BorderLayout());
        this.add(welcomeLabel,BorderLayout.CENTER);
        this.add(buttonsPanel,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Secretary");
        this.getContentPane().setBackground(Color.white);
        this.setSize(new Dimension(600,550));
        this.setResizable(false);
        this.setVisible(true);
    }
}