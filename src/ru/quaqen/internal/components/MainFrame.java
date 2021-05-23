package ru.quaqen.internal.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

  private Surface panel;

  public MainFrame() {
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      this.createGUI();
      this.setLocationRelativeTo(null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void createGUI() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setUndecorated(true);
    this.setPreferredSize(new Dimension(500, 400));

    panel = new Surface();
    panel.setBackground(Color.BLACK);
    this.add(panel);

    this.addMouseListener(panel);

    this.pack();
    this.setVisible(true);
    panel.repaint();
  }

}
