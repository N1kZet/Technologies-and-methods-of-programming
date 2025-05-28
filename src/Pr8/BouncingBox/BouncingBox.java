package Pr8.BouncingBox;

import java.applet.*;
import java.awt.*;

public class BouncingBox extends Applet implements Runnable {
    // Массив для хранения всех объектов (родительский класс - Rectangle)
    Rectangle[] objects = new Rectangle[30];
    // Массивы для движения каждого объекта
    int[] dx = new int[30];
    int[] dy = new int[30];
    // Массив цветов для ColorableRect
    Color[] colors = new Color[30];
    
    Thread animator;
    volatile boolean pleaseStop;

    // Инициализация объектов
    public void init() {
        // Создаем 10 простых Rectangle
        for (int i = 0; i < 10; i++) {
            objects[i] = new Rectangle(50 + i*30, 50 + i*20, 40, 30);
            dx[i] = 5 + (int)(Math.random() * 10);
            dy[i] = 5 + (int)(Math.random() * 10);
        }
        
        // Создаем 10 DrawableRect
        for (int i = 10; i < 20; i++) {
            objects[i] = new DrawableRect(50 + (i-10)*30, 150 + (i-10)*20, 40, 30);
            dx[i] = 5 + (int)(Math.random() * 10);
            dy[i] = 5 + (int)(Math.random() * 10);
        }
        
        // Создаем 10 ColorableRect с разными цветами
        for (int i = 20; i < 30; i++) {
            objects[i] = new ColorableRect(50 + (i-20)*30, 250 + (i-20)*20, 40, 30);
            dx[i] = 5 + (int)(Math.random() * 10);
            dy[i] = 5 + (int)(Math.random() * 10);
            colors[i] = new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
            );
        }
    }

    public void paint(Graphics g) {
        // Отрисовка всех объектов
        for (int i = 0; i < 30; i++) {
            if (i < 10) {
                // Простые прямоугольники - серые
                g.setColor(Color.gray);
                g.fillRect(objects[i].x, objects[i].y, objects[i].width, objects[i].height);
            } else if (i < 20) {
                // DrawableRect - синие с черной рамкой
                g.setColor(Color.blue);
                g.fillRect(objects[i].x, objects[i].y, objects[i].width, objects[i].height);
                g.setColor(Color.black);
                g.drawRect(objects[i].x, objects[i].y, objects[i].width, objects[i].height);
            } else {
                // ColorableRect - случайные цвета
                g.setColor(colors[i]);
                g.fillRect(objects[i].x, objects[i].y, objects[i].width, objects[i].height);
            }
        }
    }

    public void animate() {
        Rectangle bounds = getBounds();
        
        for (int i = 0; i < 30; i++) {
            // Проверка столкновений с границами
            if ((objects[i].x + dx[i] < 0) || 
                (objects[i].x + objects[i].width + dx[i] > bounds.width)) {
                dx[i] = -dx[i];
            }
            if ((objects[i].y + dy[i] < 0) || 
                (objects[i].y + objects[i].height + dy[i] > bounds.height)) {
                dy[i] = -dy[i];
            }
            
            // Перемещение объекта
            objects[i].x += dx[i];
            objects[i].y += dy[i];
        }
        
        repaint();
    }

    public void run() {
        while(!pleaseStop) {
            animate();
            try { Thread.sleep(100); }
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

// Классы DrawableRect и ColorableRect (как в лабораторной работе №2)
class DrawableRect extends Rectangle {
    public DrawableRect(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}

class ColorableRect extends DrawableRect {
    public ColorableRect(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}