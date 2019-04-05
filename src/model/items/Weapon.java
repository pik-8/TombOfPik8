package model.items;

import model.effects.Condition;
import model.effects.Effect;

import java.util.Random;

public class Weapon extends Equipment {

    private Effect[] effects;


    public void Weapon (Effect effects[]) {
        this.effects[1] = model.effects.EffectGiver.getEffect(Condition.POISON);
        this.effects = effects;
    }

    public void tmp (){

    }
}
