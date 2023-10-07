package Entity;

import Random.RandomUtil;
public class EntityService {
    public static boolean checkHealth(Entity entity) {
        if (entity.getHealth() <= 0) {
            entity.setHealth(0);
            return false;
        }
        return true;
    }

    public static int modifierOfAttack(Entity entity1, Entity entity2) {
        return entity1.getAttack() - entity2.getDefence() + 1 <= 0 ? 1 : entity1.getAttack() - entity2.getDefence() + 1;
    }

    public static boolean luckOfAttack(Entity entity1, Entity entity2) {
        int dice; //result the throw of cube
        for (int i = 0; i < EntityService.modifierOfAttack(entity1, entity2); i++) {
            dice = RandomUtil.randomizer(1, 6);
            if (dice == 5 || dice == 6) {
                System.out.println(entity1.getType() + " атакует " + entity2.getType() + " - атака успешна");
                return true;
            }
        }
        System.out.println(entity1.getType() + " атакует " + entity2.getType() + " - атака провалена");
        return false;
    }

    public static boolean isAlive(Entity entity) {
        return entity.getHealth() > 0;
    }
}
