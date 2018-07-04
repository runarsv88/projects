import com.player.Player;

import java.io.IOException;

/**
 * Created by rsverrisson on 25-06-2018.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Player musicPlayer = new Player("Library.csv");
        musicPlayer.start();
    }
}
