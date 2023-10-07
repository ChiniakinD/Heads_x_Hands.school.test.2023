package Game;

import Entity.Monster;
import Entity.Player;
import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;
import Random.RandomUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateEntity {
    public static Player createRandomPlayer() throws MinHealthException, AttackException, DefenceException, DamageException {
        return new Player(RandomUtil.randomizer(1, 100), RandomUtil.randomizer(1, 30), RandomUtil.randomizer(1, 30), 1,6);
    }
    public static Monster createRandomMonster() throws MinHealthException, AttackException, DefenceException, DamageException{
        return new Monster(RandomUtil.randomizer(1, 100), RandomUtil.randomizer(1, 30), RandomUtil.randomizer(1, 30),1,6);

    }
    private static int getIntegerInput(BufferedReader reader, String message) throws IOException {
        System.out.print(message);
        String input = reader.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println("Ввод некорректен - требуется ввести целое число");
            return getIntegerInput(reader, message);
        }
    }
    public static Player createPlayerFromInput() throws MinHealthException, AttackException, DefenceException, DamageException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите параметры игрока (здоровье, атака, защита, минимальный урон, максимальный урон):");

        int health = getIntegerInput(reader, "Введите здоровье: ");
        int attack = getIntegerInput(reader, "Введите атаку: ");
        int defence = getIntegerInput(reader, "Введите защиту: ");
        int minDamage = getIntegerInput(reader, "Введите минимальный урон: ");
        int maxDamage = getIntegerInput(reader, "Введите максимальный урон: ");

        return new Player(health, attack, defence, minDamage, maxDamage);
    }

    public static Monster createMonsterFromInput() throws MinHealthException, AttackException, DefenceException, DamageException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите параметры монстра (здоровье, атака, защита, минимальный урон, максимальный урон):");

        int health = getIntegerInput(reader, "Введите здоровье: ");
        int attack = getIntegerInput(reader, "Введите атаку: ");
        int defence = getIntegerInput(reader, "Введите защиту: ");
        int minDamage = getIntegerInput(reader, "Введите минимальный урон: ");
        int maxDamage = getIntegerInput(reader, "Введите максимальный урон: ");

        return new Monster(health, attack, defence, minDamage, maxDamage);
    }
    public static void infoAboutEntities(Player player, Monster monster) {
        System.out.println("Персонажи созданы с следующими характеристиками и готовы к бою:\n" +
                "" + player.toString() + "\n" +
                "" + monster.toString());
    }
}
