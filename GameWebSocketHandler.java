import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameWebSocketHandler extends TextWebSocketHandler {
    private List<WebSocketSession> players = new CopyOnWriteArrayList<>();
    private Map<WebSocketSession, String> playerNames = new HashMap<>();
    private Map<WebSocketSession, Integer> playerScores = new HashMap<>();
    private final int WINNING_SCORE = 20;
    private Random random = new Random();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        players.add(session);
        session.sendMessage(new TextMessage("Enter your name to join the game:"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();

        // Check if the player has entered a name
        if (!playerNames.containsKey(session)) {
            playerNames.put(session, msg);
            playerScores.put(session, 0);
            broadcastMessage(msg + " has joined the game.");
            return;
        }

        // Game logic - roll dice
        int points = rollDice();
        int currentScore = playerScores.get(session) + points;
        playerScores.put(session, currentScore);
        broadcastMessage(playerNames.get(session) + " rolled a " + points + " and now has " + currentScore + " points.");

        // Check if someone has won
        if (currentScore >= WINNING_SCORE) {
            broadcastMessage(playerNames.get(session) + " wins the game!");
            resetGame();
        }
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    private void broadcastMessage(String message) throws Exception {
        for (WebSocketSession player : players) {
            player.sendMessage(new TextMessage(message));
        }
    }

    private void resetGame() {
        playerScores.clear();
        playerNames.clear();
    }
}
