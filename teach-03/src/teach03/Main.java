package teach03;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Gson g = new Gson();

        Player player = new Player();
        player.setGold(100);
        player.setHealth(100);
        player.setMana(100);
        player.addEquipment("Sword", 400);
        player.addEquipment("Shield", 250);
        player.addEquipment("Armor", 350);
        player.addEquipment("Rope", 100);
        player.removeEquipment("Rope");
        player.removeEquipment("Club"); // testing if item doesn't exist

        Game game = new Game(player);

        game.saveGame();

        Game newGame = game.loadGame();
        newGame.getPlayer().display();
    }
}
