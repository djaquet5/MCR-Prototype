package controller;

import entity.*;
import magic.Spell;
import stuff.Item;

public class BattleController {

    public static String attack(GameCharacter attacker, GameCharacter target) {
        return attacker.attack(target) + " damage was inflicted !";
    }

    public static String castSpell(GameCharacter speller, Spell spell, GameCharacter target) {
        int damage = speller.castMagic(target, spell);

        if(damage == -1) {
            return spell + " not casted !";
        }

        return damage + " damage was inflicted !";
    }

    public static String useItem(GameCharacter user, Item item) {
        user.useItem(item);
        return item + " used !";
    }
}