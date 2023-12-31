package Inputs;

import Entities.Player;
import Entities.PlayerManager;
import GameState.GameState;
import GameState.GameMode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {
    private PlayerManager playerManager;
    private Player player;

    public KeyInputs(PlayerManager playerManager, Player player) {
        this.player = player;
        this.playerManager = playerManager;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (player.isLost) return;
        if (GameMode.gameMode == GameMode.PVP) {
            if (!playerManager.isSwitchStatus()) {
                if (GameState.state == GameState.PLAYER1 && player == playerManager.getPlayer1())
                    playerManager.getPlayerState().keyPressed(e);
                else if (GameState.state == GameState.PLAYER2 && player == playerManager.getPlayer2())
                    playerManager.getPlayerState().keyPressed(e);
            } else {
                if (GameState.state == GameState.PLAYER1 && player == playerManager.getPlayer2())
                    playerManager.getPlayerState().keyPressed(e);
                else if (GameState.state == GameState.PLAYER2 && player == playerManager.getPlayer1())
                    playerManager.getPlayerState().keyPressed(e);
            }
        }
        else if (GameMode.gameMode == GameMode.PVE){
            if (!playerManager.isSwitchStatus()) {
                if (GameState.state == GameState.PLAYER1 && player == playerManager.getPlayer1())
                    playerManager.getPlayerState().keyPressed(e);
                else if (GameState.state == GameState.BOT && player == playerManager.getBot())
                    playerManager.getPlayerState().keyPressed(e);
            } else {
                if (GameState.state == GameState.PLAYER1 && player == playerManager.getBot())
                    playerManager.getPlayerState().keyPressed(e);
                else if (GameState.state == GameState.BOT && player == playerManager.getPlayer1())
                    playerManager.getPlayerState().keyPressed(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
