package Entity;

import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;

public class Player extends Entity {
    public  final int MAX_NUMBER_OF_HEAL = 4;
    private int currentNumberOfHeal = 0;

    public Player(int health, int attack, int defence, int minDamage, int maxDamage) throws MinHealthException, AttackException, DefenceException, DamageException {
        super(health, attack, defence, minDamage, maxDamage);
        this.setType("Entity.Player");
    }

    private int getCurrentNumberOfHeal() {
        return currentNumberOfHeal;
    }

    private void setCurrentNumberOfHeal(int currentNumberOfHeal) {
        this.currentNumberOfHeal = currentNumberOfHeal;
    }

    public int getMAX_NUMBER_OF_HEAL() {
        return MAX_NUMBER_OF_HEAL;
    }

    private void checkMaxHealth() {
        if (this.getHealth() >= this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth());
        }
    }

    public void heal() {
        if (possibilityOfHealing(this)) {
            System.out.println("Игрок лечиться");
            this.setCurrentNumberOfHeal(this.getCurrentNumberOfHeal() + 1);
            this.setHealth(this.getHealth() + (this.getMaxHealth() * 3 / 10));
            this.checkMaxHealth();
        } else {
            System.out.println("Лечение невозможно, т.к. кончились очки для восстановления или из-за наличия максимального здоровья " +
                    " - игрок пропускает ход");
        }
    }

    public static boolean possibilityOfHealing(Player player) {
        return player.getHealth() < player.getMaxHealth() && player.getCurrentNumberOfHeal() < player.MAX_NUMBER_OF_HEAL;
    }

    @Override
    public String getType() {
        return "Player";
    }
}
