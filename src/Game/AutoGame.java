package Game;

import Entity.EntityService;
import Entity.Monster;
import Entity.Player;
import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;
import Random.RandomUtil;

public class AutoGame {

    private static void randomFight(Player player, Monster monster) {
        int i = 0; //count of round
        while (EntityService.isAlive(player) && EntityService.isAlive(monster)) {
            System.out.println("Раунд №" + ++i);
            if (player.getHealth() < player.getMaxHealth() && Player.possibilityOfHealing(player)) {
                if (RandomUtil.randomizer(0, 1) == 1) {
                    player.attack(monster);
                } else {
                    player.heal();
                }
            } else {
                player.attack(monster);
            }
            monster.attack(player);
            System.out.println(player);
            System.out.println(monster);
        }
    }

    public static void launch() throws MinHealthException, AttackException, DefenceException, DamageException {
        Player player = CreateEntity.createRandomPlayer();
        Monster monster = CreateEntity.createRandomMonster();
        CreateEntity.infoAboutEntities(player, monster);
        randomFight(player, monster);
        if (EntityService.isAlive(player)) {
            System.out.println("Победил игрок");
        } else {
            System.out.println("Победил монстр");
        }
    }
}
