package com.company.states;

import com.company.Game;

import java.awt.*;

/**
 * Created by Ben on 20/11/2016.
 */
public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    //--------------------//
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}
