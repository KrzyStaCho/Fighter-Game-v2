package Characters;

import java.util.ArrayList;

public class FightSimulation {
    public static ArrayList<String> StartSimulation(Character character1, Character character2) {
        ArrayList<String> LogSimulation = new ArrayList<>();

        double tmpAttackSpeed1 = 0;
        double tmpAttackSpeed2 = 0;

        int damage = 0;
        String log = "";
        boolean isEnd = false;
        while (true) {
            tmpAttackSpeed1 += character1.getAttackSpeed();
            tmpAttackSpeed2 += character2.getAttackSpeed();

            while (tmpAttackSpeed1 >= 1.0) {
                tmpAttackSpeed1 -= 1.0;

                damage = character1.GetCharacterAttackDamage();
                damage = character2.DealDamageToCharacter(damage);

                log = character1.getName() + " deal " + damage + " damage to " + character2.getName();
                LogSimulation.add(log);

                if (character2.getHealth() <= 0) {
                    log = character1.getName() + " killed " + character2.getName();
                    LogSimulation.add(log);

                    log = character1.getName() + " win fight!";
                    LogSimulation.add(log);

                    isEnd = true;
                    break;
                }
            }
            while (tmpAttackSpeed2 >= 1.0 && !isEnd) {
                tmpAttackSpeed2 -= 1.0;

                damage = character2.GetCharacterAttackDamage();
                damage = character1.DealDamageToCharacter(damage);

                log = character2.getName() + " deal " + damage + " damage to " + character1.getName();
                LogSimulation.add(log);

                if (character1.getHealth() <= 0) {
                    log = character2.getName() + " killed " + character1.getName();
                    LogSimulation.add(log);

                    log = character2.getName() + " win fight!";
                    LogSimulation.add(log);

                    isEnd = true;
                    break;
                }
            }
            if (isEnd) break;
        }
        return LogSimulation;
    }
}
