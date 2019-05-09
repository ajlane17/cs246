package teach03;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private int health;
    private int mana;
    private int gold;
    private Map<String, Integer> equipment;

    public Player() {
        equipment = new HashMap<>();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addEquipment(String name, int cost) {
        this.equipment.put(name, cost);
    }

    public void removeEquipment(String name) {
        if (this.equipment.containsKey(name)) {
            this.equipment.remove(name);
        }
    }

    public Map<String, Integer> getEquipment() {
        return equipment;
    }

    public void display() {
        System.out.println("Health: " + health +
                           "\nMana: " + mana +
                           "\nGold: " + gold +
                           "\nEquipment: " + equipment.toString());
    }

    public static String SerializeToJson(Player player) {
        Gson gson = new Gson();
        return gson.toJson(player);
    }
}
