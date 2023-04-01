package Characters;

import java.util.Random;

public abstract class Character {
    protected static int DmgOnCritical = 120;

    protected String Name;
    protected int MaxHealth;
    protected int Health;
    protected int Armor;
    protected int AttackDamage;
    protected int CriticalChance;
    protected double AttackSpeed;

    protected Character(String name, int health, int armor, int attackDamage, int criticalChance, double attackSpeed)
    {
        Name = name;
        MaxHealth = health;
        Health = health;
        Armor = armor;
        AttackDamage = attackDamage;
        CriticalChance = criticalChance;
        AttackSpeed = attackSpeed;
    }

    public int GetCharacterAttackDamage() {
        Random rnd = new Random();
        return ((rnd.nextInt(100) + 1) <= CriticalChance) ? (int)((DmgOnCritical / 100.0) * AttackDamage) : AttackDamage;
    }

    public int DealDamageToCharacter(int attackDamage) {
        int finalDamage = (attackDamage <= Armor) ? 0 : (attackDamage - Armor);
        Health -= (finalDamage <= Health) ? finalDamage : Health;
        return finalDamage;
    }

    @Override
    public String toString() {
        return "{Character:" + Name + "}MH:" + MaxHealth + ";H: " + Health
                + ";\nA:" + Armor + ";Atd:" + AttackDamage + ";Ats:" + AttackSpeed
                + ";\nC:" + CriticalChance;
    }

    public static int getDmgOnCritical() {
        return DmgOnCritical;
    }

    public static void setDmgOnCritical(int dmgOnCritical) {
        DmgOnCritical = dmgOnCritical;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        MaxHealth = maxHealth;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        Armor = armor;
    }

    public int getAttackDamage() {
        return AttackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        AttackDamage = attackDamage;
    }

    public int getCriticalChance() {
        return CriticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        CriticalChance = criticalChance;
    }

    public double getAttackSpeed() {
        return AttackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        AttackSpeed = attackSpeed;
    }

    public String getInfo() {
        return "<html>Name: " + Name +
                "<br/>Health: " + Health + "/" + MaxHealth +
                "<br/>Armor: " + Armor +
                "<br/>AttackDamage: " + AttackDamage +
                "<br/>CriticalChance: " + CriticalChance + "%" +
                "<br/>AttackSpeed: " + AttackSpeed + "</html>";
    }
}
