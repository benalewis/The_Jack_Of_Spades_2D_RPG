package com.company.states;

import com.company.entities.Player;
import com.company.gfx.Assets;

import java.awt.*;

/**
 * Created by Ben on 20/11/2016.
 */
public class GameState extends State{

    private Player player;

    public GameState() {
        player = new Player(100.0f, 100.0f);
    }

    @Override
    public void update() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
