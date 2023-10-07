package Game;

import Entity.EntityService;
import Entity.Monster;
import Entity.Player;
import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManualGame {
    public static void launch() throws MinHealthException, AttackException, DefenceException, DamageException, IOException {
        System.out.println("Добро пожаловать в одиночную игру, введите 1 для автоматического создания персонажей, " +
                "любую другую - для ручного");
        Player player;
        Monster monster;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("1")) {
            player = CreateEntity.createRandomPlayer();
            monster = CreateEntity.createRandomMonster();
        } else {
            player = CreateEntity.createPlayerFromInput();
            monster = CreateEntity.createMonsterFromInput();
        }
        CreateEntity.infoAboutEntities(player,monster);
        manualFight(player,monster);

        if (Entity.EntityService.isAlive(player)) {
            System.out.println("Победил игрок");
        } else {
            System.out.println("Победил монстр");
        }
    }
    private static void manualFight(Player player, Monster monster) throws IOException {
        int i = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (EntityService.isAlive(player) && EntityService.isAlive(monster)) {
            System.out.println("Раунд №" + ++i);
            System.out.println("Введите 1 для лечения " +
                    "любую другую клавишу - для атаки");
            s = reader.readLine();
            if (s.equals("1")) {
                player.heal();
            } else {
                player.attack(monster);
            }
            monster.attack(player);
            System.out.println(player);
            System.out.println(monster);
        }
    }
}
