package teach03;

import com.google.gson.Gson;

public class Game {
    Player player;

    public Game(Player player) {
        setPlayer(player);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void saveGame() {
        Output output = Output.getInstance();

        String gameFileName = getFilename("Save file name: ");
        String fileContents = player.SerializeToJson(player);
        output.writeToFile(gameFileName, fileContents);
    }

    public static Game loadGame() {
        Input input = Input.getInstance();
        Gson gson = new Gson();

        String gameFileName = getFilename("Load file name: ");
        String fileContents = input.getFileContentsString(gameFileName);

        Player player = gson.fromJson(fileContents, Player.class);
        Game game = new Game(player);
        return game;
    }

    private static String getFilename(String prompt) {
        Input input = Input.getInstance();
        return input.getString(prompt);
    }
}
