package Entity;

import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;

public class Monster extends Entity {
    public Monster(int health, int attack, int defence, int minDamage, int maxDamage) throws MinHealthException, AttackException, DefenceException, DamageException {
        super(health, attack, defence, minDamage, maxDamage);
        this.setType("Entity.Monster");
    }

    @Override
    public String getType() {
        return "Monster";
    }
}
