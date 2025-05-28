package Pr8.BouncingBox;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.*;

public class BouncingBox extends Applet implements Runnable {
    private ColorableRect box;
    private int dx = 5, dy = 5;
    private Thread animator;
    private volatile boolean pleaseStop;

    
    class ColorableRect extends Rectangle {
        private final Color border, fill;

        public ColorableRect(int x, int y, int w, int h, Color b, Color f) {
            super(x, y, w, h);
            this.border = b;
            this.fill = f;
        }

        public void draw(Graphics g) {
            g.setColor(fill);
            g.fillRect(x, y, width, height);
            g.setColor(border);
            g.drawRect(x, y, width, height);
        }
    }

    public void init() {
        box = new ColorableRect(50, 50, 40, 40, Color.RED, Color.BLUE);
        setSize(400, 300); // Явно задаем размер
    }

    public void paint(Graphics g) {
        box.draw(g);
    }

    public void run() {
        while(!pleaseStop) {
            Rectangle bounds = getBounds();
            if ((box.x + dx < 0) || (box.x + box.width + dx > bounds.width)) dx = -dx;
            if ((box.y + dy < 0) || (box.y + box.height + dy > bounds.height)) dy = -dy;
            box.x += dx;
            box.y += dy;
            
            repaint();
            try { Thread.sleep(50); } 
            catch (InterruptedException e) {}
        }
    }

    public void start() {
        if (animator == null) {
            animator = new Thread(this);
            pleaseStop = false;
            animator.start();
        }
    }

    public void stop() {
        pleaseStop = true;
        animator = null;
    }
}