package Characters;

import java.util.Random;

public class PointTypeCharacter extends Character {
    public static final int BaseHealth = 100;
    public static final int BaseArmor = 0;
    public static final int BaseAttackDamage = 10;
    public static final int BaseCriticalChance = 0;
    public static final double BaseAttackSpeed = 1.0;

    public static final int PointToHealth = 30;
    public static final int PointToArmor = 2;
    public static final int PointToAttackDamage = 4;
    public static final int PointToCriticalChance = 20;
    public static final double PointToAttackSpeed = 0.3;

    public static final int MaxPointOnOneAttribute = 5;
    public static final int MaxPointOnOneCharacter = 10;

    public static PointTypeCharacter CreateCharacter
            (String name, int healthPoints, int armorPoints, int attackDamagePoints, int criticalChancePoints, int attackSpeedPoints) {
        int leftPoints = MaxPointOnOneCharacter;

        if ((healthPoints >= 0) && (healthPoints <= MaxPointOnOneAttribute) && (healthPoints <= leftPoints)) {
            leftPoints -= healthPoints;
        } else return null;

        if ((armorPoints >= 0) && (armorPoints <= MaxPointOnOneAttribute) && (armorPoints <= leftPoints)) {
            leftPoints -= armorPoints;
        } else return null;

        if ((attackDamagePoints >= 0) && (attackDamagePoints <= MaxPointOnOneAttribute) && (attackDamagePoints <= leftPoints)) {
            leftPoints -= attackDamagePoints;
        } else return null;

        if ((criticalChancePoints >= 0) && (criticalChancePoints <= MaxPointOnOneAttribute) && (criticalChancePoints <= leftPoints)) {
            leftPoints -= criticalChancePoints;
        } else return null;

        if ((attackSpeedPoints >= 0) && (attackSpeedPoints <= MaxPointOnOneAttribute) && (attackSpeedPoints <= leftPoints)) {
            leftPoints -= attackSpeedPoints;
        } else return null;

        return CreateCharacterViaPoints(name, healthPoints, armorPoints, attackDamagePoints, criticalChancePoints, attackSpeedPoints);
    }

    public static PointTypeCharacter CreateRandomCharacter(String name) {
        Random rnd = new Random();
        int pointsLeft = MaxPointOnOneCharacter;

        //Health
        int healthPoints;
        if (pointsLeft != 0) {
            healthPoints = rnd.nextInt(0, MaxPointOnOneAttribute);
            if (healthPoints > pointsLeft) {
                healthPoints = pointsLeft;
                pointsLeft = 0;
            } else pointsLeft -= healthPoints;
        } else healthPoints = 0;

        //Armor
        int armorPoints;
        if (pointsLeft != 0) {
            armorPoints = rnd.nextInt(0, MaxPointOnOneAttribute);
            if (armorPoints > pointsLeft) {
                armorPoints = pointsLeft;
                pointsLeft = 0;
            } else pointsLeft -= armorPoints;
        } else armorPoints = 0;

        //AttackDamage
        int attackDamagePoints;
        if (pointsLeft != 0) {
            attackDamagePoints = rnd.nextInt(0, MaxPointOnOneAttribute);
            if (attackDamagePoints > pointsLeft) {
                attackDamagePoints = pointsLeft;
                pointsLeft = 0;
            } else pointsLeft -= attackDamagePoints;
        } else attackDamagePoints = 0;

        //CriticalChance
        int criticalChancePoints;
        if (pointsLeft != 0) {
            criticalChancePoints = rnd.nextInt(0, MaxPointOnOneAttribute);
            if (criticalChancePoints > pointsLeft) {
                criticalChancePoints = pointsLeft;
                pointsLeft = 0;
            } else pointsLeft -= criticalChancePoints;
        } else criticalChancePoints = 0;

        //AttackSpeed
        double attackSpeedPoints = pointsLeft;
        pointsLeft -= attackSpeedPoints;

        return CreateCharacterViaPoints(name, healthPoints, armorPoints, attackDamagePoints, criticalChancePoints, attackSpeedPoints);
    }

    private static PointTypeCharacter CreateCharacterViaPoints
            (String name, int health, int armor, int attackDamage, int criticalChance, double attackSpeed) {
        health = BaseHealth + (health * PointToHealth);
        armor = BaseArmor + (armor * PointToArmor);
        attackDamage = BaseAttackDamage + (attackDamage * PointToAttackDamage);
        criticalChance = BaseCriticalChance + (criticalChance * PointToCriticalChance);
        attackSpeed = BaseAttackSpeed + (attackSpeed * PointToAttackSpeed);

        return new PointTypeCharacter(name, health, armor, attackDamage, criticalChance, attackSpeed);
    }

    private PointTypeCharacter(String name, int health, int armor, int attackDamage, int criticalChance, double attackSpeed) {
        super(name, health, armor, attackDamage, criticalChance, attackSpeed);
    }
}
