package com.company.entities;

/**
 * Created by Ben on 20/11/2016.
 */
public abstract class Creature extends  Entity{

    protected int health;

    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }
}
