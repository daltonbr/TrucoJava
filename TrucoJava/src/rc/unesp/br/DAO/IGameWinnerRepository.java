package rc.unesp.br.DAO;

import rc.unesp.br.beans.Player;

/**
 * Intertaface that makes all the DataBase transactions to the table GameWinner
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 * @author lucas Pinheiro @lucaspin
 */
public interface IGameWinnerRepository {
    /**
     * Insert a row to the table GameWinner
     * @param winner {Player}
     */
    public void insertGameWinner(Player winner);

    /**
     * Update a row in the table GameWinner
     * @param winner {Player}
     */
    public void updateGameWinner(Player winner);

    /**
     * Delete a row of the table GameWinner
     * @param winner {Player}
     */
    public void deleteGameWinner(Player winner);
}
