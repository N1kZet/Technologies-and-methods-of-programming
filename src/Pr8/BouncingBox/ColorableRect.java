package Pr8.BouncingBox;

import java.awt.*;

public class ColorableRect extends java.awt.Rectangle {
    private Color borderColor;
    private Color fillColor;

    public ColorableRect(int x, int y, int w, int h, Color b, Color f) {
        super(x, y, w, h);
        this.borderColor = b;
        this.fillColor = f;
    }

    public void draw(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(x, y, width, height);
        g.setColor(borderColor);
        g.drawRect(x, y, width, height);
    }
}
