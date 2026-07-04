import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    Game game = new Game();
    Player p1 = new Player(1, "Ира", 4);
    Player p2 = new Player(2, "Катя", 3);
    Player p3 = new Player(3, "Настя", 4);

    @Test
    public void shouldWinFirstPlayer() {
        game.register(p1);
        game.register(p2);
        assertEquals(1, game.round("Ира", "Катя"));
    }

    @Test
    public void shouldWinSecondPlayer() {
        game.register(p1);
        game.register(p2);
        assertEquals(2, game.round("Катя", "Ира"));
    }

    @Test
    public void shouldBeDraw() {
        game.register(p1);
        game.register(p3);
        assertEquals(0, game.round("Ира", "Настя"));
    }

    @Test
    public void shouldThrowIfFirstNotRegistered() {
        game.register(p2);
        assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Petr"));
    }

    @Test
    public void shouldThrowIfSecondNotRegistered() {
        game.register(p1);
        assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Petr"));
    }

    @Test
    public void shouldThrowIfBothNotRegistered() {
        assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Petr"));
    }
}
