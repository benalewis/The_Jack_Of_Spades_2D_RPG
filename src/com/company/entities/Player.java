package com.company.entities;

import com.company.gfx.Assets;

import java.awt.*;

/**
 * Created by Ben on 20/11/2016.
 */
public class Player extends Creature {

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
}
