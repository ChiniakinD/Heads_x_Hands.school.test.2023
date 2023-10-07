import Exceptions.AttackException;
import Exceptions.DamageException;
import Exceptions.DefenceException;
import Exceptions.MinHealthException;
import Game.Game;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws MinHealthException, DamageException, IOException, AttackException, DefenceException {
        Game.launch();
    }
}