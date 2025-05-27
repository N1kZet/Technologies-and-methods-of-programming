package Pr8.BouncingBox;

import java.applet.*;
import java.awt.*;

public class BouncingBox extends Applet implements Runnable {
    private ColorableRect box;
    private int dx = 5, dy = 5;
    private Thread animator;
    private volatile boolean pleaseStop;

    public void init() {
        box = new ColorableRect(50, 50, 40, 40, Color.red, Color.blue);
    }

    public void paint(Graphics g) {
        box.draw(g);
    }

    public void animate() {
        Rectangle bounds = getBounds();
        if ((box.x + dx < 0) || (box.x + box.width + dx > bounds.width)) dx = -dx;
        if ((box.y + dy < 0) || (box.y + box.height + dy > bounds.height)) dy = -dy;
        box.x += dx;
        box.y += dy;
        repaint();
    }

    public void run() {
        while(!pleaseStop) {
            animate();
            try { Thread.sleep(50); }
            catch(InterruptedException e) {}
        }
    }

    public void start() {
        animator = new Thread(this);
        pleaseStop = false;
        animator.start();
    }

    public void stop() {
        pleaseStop = true;
    }
}
