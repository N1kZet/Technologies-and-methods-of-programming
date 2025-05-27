package BouncingBox2;

import java.applet.*;
import java.awt.*;
import java.util.Random;
@SuppressWarnings("removal")
public class BouncingBox2 extends Applet implements Runnable {
    private Rectangle[] shapes = new Rectangle[30];
    private int[] dx = new int[30];
    private int[] dy = new int[30];
    private Thread animator;
    private volatile boolean pleaseStop;
    private Random random = new Random();

    public void init() {
        for (int i = 0; i < 10; i++) {
            // 10 Rectangle
            shapes[i] = new Rectangle(
                random.nextInt(200), random.nextInt(200),
                20 + random.nextInt(30), 20 + random.nextInt(30));
            dx[i] = 1 + random.nextInt(5);
            dy[i] = 1 + random.nextInt(5);

            // 10 DrawableRect
            shapes[i+10] = new DrawableRect(
                random.nextInt(200), random.nextInt(200),
                20 + random.nextInt(30), 20 + random.nextInt(30),
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

            // 10 ColorableRect
            shapes[i+20] = new ColorableRect(
                random.nextInt(200), random.nextInt(200),
                20 + random.nextInt(30), 20 + random.nextInt(30),
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

            dx[i+10] = 1 + random.nextInt(5);
            dy[i+10] = 1 + random.nextInt(5);
            dx[i+20] = 1 + random.nextInt(5);
            dy[i+20] = 1 + random.nextInt(5);
        }
    }

    public void paint(Graphics g) {
        for (Rectangle shape : shapes) {
            if (shape instanceof ColorableRect) {
                ((ColorableRect)shape).draw(g);
            } else if (shape instanceof DrawableRect) {
                ((DrawableRect)shape).draw(g);
            } else {
                g.setColor(Color.black);
                g.drawRect(shape.x, shape.y, shape.width, shape.height);
            }
        }
    }

    public void animate() {
        Rectangle bounds = getBounds();
        for (int i = 0; i < shapes.length; i++) {
            if ((shapes[i].x + dx[i] < 0) || 
               (shapes[i].x + shapes[i].width + dx[i] > bounds.width)) dx[i] = -dx[i];
            if ((shapes[i].y + dy[i] < 0) || 
               (shapes[i].y + shapes[i].height + dy[i] > bounds.height)) dy[i] = -dy[i];
            shapes[i].x += dx[i];
            shapes[i].y += dy[i];
        }
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
