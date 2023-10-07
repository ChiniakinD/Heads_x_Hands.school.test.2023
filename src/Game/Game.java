package Game;

import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public static void launch() throws IOException, MinHealthException, DamageException, AttackException, DefenceException {
        System.out.println("Добро пожаловать в игру нажмите 1 - для демонстрационного запуска проекта, " +
                "2- для самостоятельной игры, любую другую клавишу - для выхода");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        switch (s) {
            case "1":
                AutoGame.launch();
                break;
            case "2":
                ManualGame.launch();
            default:
                System.out.println("До встречи!");
        }
    }
}

