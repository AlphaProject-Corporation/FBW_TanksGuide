package com.example.fbw_tanks_guide;

public class Tank {

        private int id;
        private String name;
        private int level;
        private int health;
        private int damage;
        private int armor;
        private String description;
        private String history;
        private String nation;
        private String type;

    public Tank(int id, String name, int level, int health, int damage, int armor, String description, String history, String nation, String type) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.description = description;
        this.history = history;
        this.nation = nation;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
