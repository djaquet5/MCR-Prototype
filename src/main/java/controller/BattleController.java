package controller;

import entity.*;
import magic.Spell;
import stuff.Item;

public class BattleController {

    public static String attack(GameCharacter attacker, GameCharacter target) {
        return attacker + " dealt " + attacker.attack(target) + " damage to " + target + " ! ";
    }

    public static String castSpell(GameCharacter speller, Spell spell, GameCharacter target) {
        int damage = speller.castMagic(target, spell);

        if(damage == -1) {
            return speller + " couldn't cast " + spell + " ! ";
        }

        return speller + " dealt " + damage + " damage to " + target + " ! ";
    }

    public static String useItem(GameCharacter user, Item item) {
        user.useItem(item);
        return user + " used " + item + " ! ";
    }
}