package Characters;

import java.util.Random;

public class RangeTypeCharacter extends Character {
    public static final int[] HealthRange = { 100, 250 };
    public static final int[] ArmorRange = { 0, 10 };
    public static final int[] AttackDamageRange = { 10, 30 };
    public static final int[] CriticalChanceRange = { 0, 100 };
    public static final double[] AttackSpeedRange = { 1.0, 2.5 };

    public static RangeTypeCharacter CreateCharacter(String name, int health, int armor, int attackDamage, int criticalChance, double attackSpeed) {
        if (!isNumberInRange(health, HealthRange)) return null;
        if (!isNumberInRange(armor, ArmorRange)) return null;
        if (!isNumberInRange(attackDamage, AttackDamageRange)) return null;
        if (!isNumberInRange(criticalChance, CriticalChanceRange)) return null;
        if (!isNumberInRange(attackSpeed, AttackSpeedRange)) return null;

        return new RangeTypeCharacter(name, health, armor, attackDamage, criticalChance, attackSpeed);
    }

    public static RangeTypeCharacter CreateRandomCharacter(String name) {
        Random rnd = new Random();

        int health = rnd.nextInt(HealthRange[0], (HealthRange[1] - HealthRange[0]));
        int armor = rnd.nextInt(ArmorRange[0], (ArmorRange[1] - ArmorRange[0]));
        int attackDamage = rnd.nextInt(AttackDamageRange[0], (AttackDamageRange[1] - AttackDamageRange[0]));
        int criticalChance = rnd.nextInt(CriticalChanceRange[0], (CriticalChanceRange[1] - CriticalChanceRange[0]));
        double attackSpeed = rnd.nextDouble(AttackSpeedRange[0], (AttackSpeedRange[1] - AttackSpeedRange[0]));

        //Round 1 decimal np. 1.50
        attackSpeed *= 10; attackSpeed = Math.round(attackSpeed); attackSpeed /= 10;

        return new RangeTypeCharacter(name, health, armor, attackDamage, criticalChance, attackSpeed);
    }

    private RangeTypeCharacter(String name, int health, int armor, int attackDamage, int criticalChance, double attackSpeed) {
        super(name, health, armor, attackDamage, criticalChance, attackSpeed);
    }

    private static boolean isNumberInRange(int number, int[] range) {
        return (number >= range[0] && number <= range[1]) ? true : false;
    }
    private static boolean isNumberInRange(double number, double[] range) {
        return (number >= range[0] && number <= range[1]) ? true : false;
    }
}
