package controller;

import entity.*;
import magic.Spell;

public class BattleController {

    public void attack(GameCharacter attacker, GameCharacter target) {
        System.out.println(attacker.attack(target) + " damage was inflicted !");
    }

    public void castSpell(GameCharacter speller, Spell spell, GameCharacter target) {
        int damage = speller.castMagic(target, spell);

        if(damage == -1) {
            System.out.println(spell + " not casted !");
            return;
        }

        System.out.println(damage + " damage was inflicted !");
    }

//    public void useItem(GameCharacter user, Item item)
}