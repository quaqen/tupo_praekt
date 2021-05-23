package ru.quaqen.internal;

import ru.quaqen.internal.components.MainFrame;

import java.awt.*;

public class ObjectManager {

  private MainFrame mainFrame;

  public ObjectManager(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  public ObjectManager addPoint() {

    mainFrame.getComponent(0).repaint();
    return this;
  }

}
