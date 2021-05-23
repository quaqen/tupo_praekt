package ru.quaqen.internal.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Surface extends JPanel implements MouseListener {

  private int threshold = 0;

  public Surface() {

  }

  private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g.setColor(Color.BLACK);
    Rectangle host = new Rectangle(this.getX() + this.getWidth() / 4, this.getY() + this.getHeight() / 2, this.getWidth() / 2, this.getHeight() / 2);
    drawRecursion(g2d, host, 0);

  }

  private void drawRecursion(Graphics2D g2d, Rectangle host, int level) {
    if (level > threshold)
      return;
    Polygon p = new Polygon();
    p.addPoint(round(host.getMinX()), round(host.getMinY()));
    p.addPoint(round(host.getMaxX()), round(host.getMinY()));
    p.addPoint(round(host.getMinX() + host.getWidth() / 2), round(host.getMaxY()));
//    g2d.fillPolygon(p);

    g2d.fillRect(round(host.getMinX()), round(host.getMinY()), round(host.getWidth()), round(host.getHeight()));

    Rectangle host1 = new Rectangle(
        round(host.getMinX() - host.getWidth() / 4), //x
        round(host.getMaxY() - host.getHeight() / 2), //y
        round((host.getWidth() ) / 2), //width
        round(host.getHeight() / 2)); //height

    g2d.setPaint(new Color(255, 255, 0));
    drawRecursion(g2d, host1, level + 1);

    Rectangle host2 = new Rectangle(
        round(host.getMaxX() - host.getWidth() / 4), //x
        round(host.getMinY() + host.getHeight() / 2), //y
        round(host.getWidth() / 2),  //width
        round(host.getHeight() / 2) //height
    );
    g2d.setPaint(new Color(0, 255, 255));
    drawRecursion(g2d, host2, level + 1);

    Rectangle host3 = new Rectangle(
        round(host.getMinX() + host.getWidth() / 4), //x
        round(host.getMinY() - host.getHeight() / 2) , //y
        round(host.getWidth() / 2),  //width
        round(host.getHeight() / 2) //height
    );
    g2d.setPaint(new Color(255, 0, 255));
    drawRecursion(g2d, host3, level + 1);

  }

  private Point buildPoint(double x, double y) {
    return new Point(round(x), round(y));
  }

  private int round(Double d) {
    return (int) Math.round(d);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    if(threshold > 8)
      threshold = 0;
    threshold++;
    this.repaint();
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
