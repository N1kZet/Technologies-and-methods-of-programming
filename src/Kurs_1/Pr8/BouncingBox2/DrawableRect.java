package BouncingBox2;

import java.awt.*;

public class DrawableRect extends java.awt.Rectangle {
    private Color color;

    public DrawableRect(int x, int y, int w, int h, Color c) {
        super(x, y, w, h);
        this.color = c;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}