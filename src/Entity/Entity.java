package Entity;

import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;
import Random.RandomUtil;

public abstract class Entity {
    public static final int MAX_ATTACK = 30;
    public static final int MAX_DEFENCE = 30;
    private String type;
    private int maxHealth;
    private int health;
    private int attack;
    private int defence;
    private int minDamage;
    private int maxDamage;



    public Entity(int health, int attack, int defence, int minDamage, int maxDamage) throws MinHealthException, AttackException, DefenceException, DamageException {
        if (health < 1)
            throw new MinHealthException();
        if (attack < 1 || attack > 30)
            throw new AttackException();
        if (defence < 1 || defence > 30)
            throw new DefenceException();
        if (minDamage >= maxDamage)
            throw new DamageException();
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defence = defence;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getType());
        sb.append(", health=").append(health);
        sb.append(", attack=").append(attack);
        sb.append(", defence=").append(defence);
        sb.append(", damage = from ").append(minDamage).append(" to ").append(maxDamage);
        return sb.toString();
    }

    public void attack(Entity entity) {
        if (EntityService.checkHealth(this) && EntityService.checkHealth(entity) && EntityService.luckOfAttack(this, entity)) {
            entity.setHealth(entity.getHealth() - RandomUtil.randomizer(this.getMinDamage(), this.getMaxDamage()));
        }
        EntityService.checkHealth(entity);
    }
}

