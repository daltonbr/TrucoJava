package beans;

import ui.MainView;

import java.util.List;

/**
 * Class that represents a round of a point of the game.
 * @author Lucas Pinheiro @lucaspin
 * @author Bruno Vedovetto @bleandro
 * @author Dalton Lima @daltonbr
 */
public class Round {
    private MainView view;
    private boolean ended = false;
    private boolean tied = false;
    private Player winner;
    private List<Player> playersInOrder;

    /**
     * Set the order of the players in this round
     * @param _playersInOrder {List<Player>}
     */
    public void setPlayersInOrder(List<Player> _playersInOrder) {
        this.playersInOrder = _playersInOrder;
    }

    /**
     * Init the round flow
     */
    public void initRound() {
        while (!this.isEnded()) {
            for (Player aPlayersInOrder : this.playersInOrder) {
                aPlayersInOrder.chooseCard();
            }

            // Compare the chosen cards
            Card winnerCard = this.playersInOrder.get(0).getCurrentChosenCard();
            Player winnerPlayer = this.playersInOrder.get(0);

            for (Player player : this.playersInOrder) {
                Card playerCard = player.getCurrentChosenCard();
                if (playerCard.isStrongerThan(winnerCard)) {
                    winnerCard = playerCard;
                    winnerPlayer = player;
                }

                //Here we have a tie. So there's no Winner here
                else if ( (!playerCard.getSuit().equals(winnerCard.getSuit()))
                     && ( !(playerCard.isStrongerThan(winnerCard)) && !(winnerCard.isStrongerThan(playerCard)) ) )
                    winnerPlayer = null;
            }

            if (winnerPlayer != null) {
                winnerPlayer.increaseRoundScore();

                if (winnerPlayer.getName().equals("player1")) {
                    this.view.gamePanel.scorePanel.setPlayer1RoundScore(winnerPlayer.getRoundScore());
                } else {
                    this.view.gamePanel.scorePanel.setPlayer2RoundScore(winnerPlayer.getRoundScore());
                }
            }

            this.setWinner(winnerPlayer);
            this.setEnded(true);
        }
    }

    public void setView(MainView view) {
        this.view = view;
    }

    /**
     * Set the winner of the round
     * @param _winner {Player}
     */
    public void setWinner(Player _winner) {
        this.winner = _winner;
    }

    /**
     * Get the winner of the round
     * @return {PLayer}
     */
    public Player getWinner() {
        return this.winner;
    }

    /**
     * Check if a round has ended
     * @return {Boolean}
     */
    public boolean isEnded() {
        return this.ended;
    }

    /**
     * Set the new ended status of the round
     * @param _ended {boolean}
     */
    public void setEnded(boolean _ended) {
        this.ended = _ended;
    }

    /**
     * Check is a round has tied.
     * @return {Boolean}
     */
    public boolean isTied() {
        return this.tied;
    }

    /**
     * Set the new tied status of the round
     * @param _tied {Boolean}
     */
    public void setTied(boolean _tied) {
        this.tied = _tied;
    }
}
