package com.company;

import com.company.display.Display;
import com.company.gfx.Assets;
import com.company.input.KeyManager;
import com.company.states.GameState;
import com.company.states.MenuState;
import com.company.states.SettingsState;
import com.company.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Ben on 20/11/2016.
 */
public class Game implements Runnable {

    private Display display;

    private Thread thread;
    private boolean running = false;

    public int width, height;
    public String title;

    private BufferStrategy bs;
    private Graphics g;

    //-- States --//
    private State gameState;
    private State menuState;
    private State settingsState;

    //-- Input --//
    private KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
            }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameState = new GameState(this);
        menuState = new MenuState(this);
        settingsState = new SettingsState(this);
        State.setState(gameState);
    }

    private void update(){

        keyManager.tick();

        if(State.getState() != null) {
            State.getState().update();
        }
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0,0, width, height);

        //Draw Here


        if(State.getState() != null) {
            State.getState().render(g);
        }

        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                update();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public KeyManager getKeyManager() {
        return  keyManager;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start(); //calls run method
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
