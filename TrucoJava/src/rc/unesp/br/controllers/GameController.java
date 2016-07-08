package rc.unesp.br.controllers;

import rc.unesp.br.DAO.GameWinnerRepository;
import rc.unesp.br.DAO.IGameWinnerRepository;
import rc.unesp.br.beans.*;
import rc.unesp.br.ui.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Vedovetto @bleandro
 * @author Lucas Pinheiro @lucaspin
 * @author Dalton Lima @daltonbr
 */
public class GameController {
    static final int EARLY_WIN_ROUND_SCORE = 2;
    static final int WIN_GAME_SCORE = 12;

    private MainView view;
    private boolean ended = false;
    private Player winner;
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();
    private Card turnedCard;  // ('vira' in Portuguese), the card that determine the Trump Cards (manilhas)
    private Card faceDownCard; // to represent the deck in the table

    /**
     * Initializes the game
     */
    public void initGame() {
        // Create the players. Initially, this will be just two
        HumanPlayer player1 = new HumanPlayer("player1");
        CPUPlayer player2 = new CPUPlayer("CPU player");
        this.players.add(player1);
        this.players.add(player2);
        //TODO: Ckeck this: instantiating any card here, just to avoid null
        this.faceDownCard = new Card(Rank.Ace, Suit.CLUBS, false);  // this card will be showed at middle panel, as the deck
        this.faceDownCard.setBackCardImageSource();
        this.initGameLoop();
    }

    public void resetGame() {
        this.setEnded(false);
        this.setWinner(null);
        this.players.clear();

        this.view.gamePanel.scorePanel.setPlayer1RoundScore(0);
        this.view.gamePanel.scorePanel.setPlayer2RoundScore(0);
        this.view.gamePanel.scorePanel.setPlayer1GameScore(0);
        this.view.gamePanel.scorePanel.setPlayer2GameScore(0);

        this.deck = new Deck();
        this.initGame();
    }

    /**
     * Get the reference to the view layer
     * @return {MainView}
     */
    public MainView getView() {
        return this.view;
    }

    /**
     * Set the reference to the view layer.
     * @param view {MainView}
     */
    public void setView(MainView view) {
        this.view = view;
    }

    private void initGameLoop() {
        Player pointWinner = null;

        while (!this.isEnded()) {
            // Instantiate a 'Turned Card' or 'Vira' (in Portuguese)
            turnedCard = this.deck.drawRandomCard();

            this.view.setTurnedCardOnMiddlePanel(turnedCard);
            this.view.setLastChosenCardOnMiddlePanel(Card.getFacedDownCard());

            // Set the player's hand
            Hand hand = null;
            for (Player player : this.players) {
                hand = new Hand(this.deck.drawRandomCards(3));
                //checking for 'Trump Cards' or 'Manilhas' (in Portugese)
                for(Card card : hand.getCards()) {
                    if (card.getRank().equals(turnedCard.getRank().getNext())) {
                        card.setManilha(true);
                    }
                }
                player.setHand(hand);
            }

            // TODO: check this
            this.view.setCardsOnTopPanel(this.players.get(0).getHand().getCards());
            this.view.setCardsOnBottomPanel(this.players.get(1).getHand().getCards());


            // Instantiate a new point
            Point point = new Point(this.players);
            point.setView(this.view);
            point.initPoint(this.players);

            // Check if the game has ended
            pointWinner = point.getWinner();
            if (pointWinner != null && pointWinner.getGameScore() == WIN_GAME_SCORE) {
                this.setWinner(pointWinner);
                this.setEnded(true);
            } else {
                this.deck.resetDeck();
                this.resetPlayersRoundScore();
            }
        }

        IGameWinnerRepository iGameWinnerRepository = new GameWinnerRepository();
        iGameWinnerRepository.insertGameWinner(pointWinner);
    }

    /**
     * Reset the player's round score before a new point begins
     */
    private void resetPlayersRoundScore() {
        for (Player player : this.players) {
            player.resetRoundScore();

            if (player.getName().equals("player1")) {
                this.view.gamePanel.scorePanel.setPlayer1RoundScore(player.getRoundScore());
            } else {
                this.view.gamePanel.scorePanel.setPlayer2RoundScore(player.getRoundScore());
            }
        }
    }

    /**
     * Set the game winner player
     * @param _winner {Player}
     */
    public void setWinner(Player _winner) {
        this.winner = _winner;
    }

    public void setChosenCardForHumanPlayer(Suit suit, Rank rank, boolean isManilha) {
        for (Player player : this.players) {
            if (player instanceof HumanPlayer) {
                HumanPlayer humanPlayer = (HumanPlayer) player;
                humanPlayer.setCurrentChosenCard(new Card(rank, suit, isManilha));
                humanPlayer.setChoosingCard(false);
            }
        }
    }

    /**
     * Set the new status of the game
     * @param ended {Boolean}
     */
    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    /**
     * Check if the game has ended
     * @return ended {Boolean}
     */
    public boolean isEnded() {
        return this.ended;
    }
}
