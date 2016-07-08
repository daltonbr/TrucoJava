package rc.unesp.br.DAO;

import rc.unesp.br.beans.Player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class that makes all the DataBase transactions to the table GameWinner
 * @author Dalton Lima @daltonbr
 * @author Bruno Vedovetto @bleandro
 * @author lucas Pinheiro @lucaspin
 */
public class GameWinnerRepository implements IGameWinnerRepository{
    @Override
    public void insertGameWinner(Player player) {
        //Create query for insert
        String query = "INSERT INTO GameWinner(name)" +
                       "VALUES(?)";

        try {
            //Fill parameter with the "Player name"
            PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(query);
            stmt.setString(1, player.getName());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            //Any SQL problem
            e.printStackTrace();
        }
    }

    @Override
    public void updateGameWinner(Player player) {
        //Create query for update
        String query = "UPDATE GameWinner SET name = ?" +
                       "WHERE name = ?";

        try {
            //Fill parameters with the "Player name"
            PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(query);
            stmt.setString(1, player.getName());
            stmt.setString(2, player.getName());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            //Any SQL problem
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGameWinner(Player player) {
        //Create query for delete
        String query = "DELETE FROM GameWinner WHERE name = ?";

        try {
            //Fill parameters with the "Player name"
            PreparedStatement stmt = MySQLConnection.getConnection().prepareStatement(query);
            stmt.setString(1, player.getName());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            //Any SQL problem
            e.printStackTrace();
        }
    }
}
