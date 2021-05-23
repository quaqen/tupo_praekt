package ru.quaqen.internal;

import ru.quaqen.internal.components.MainFrame;

public class EntryPoint {


  public static void main(String[] args) {
    MainFrame mainFrame = new MainFrame();
    new ObjectManager(mainFrame).addPoint();
  }

}
