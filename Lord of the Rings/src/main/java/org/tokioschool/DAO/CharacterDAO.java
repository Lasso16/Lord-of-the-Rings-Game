package org.tokioschool.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.beasts.Beast;
import org.tokioschool.model.characters.beasts.Goblin;
import org.tokioschool.model.characters.beasts.Orc;
import org.tokioschool.model.characters.heroes.Elf;
import org.tokioschool.model.characters.heroes.Hero;
import org.tokioschool.model.characters.heroes.Hobbit;
import org.tokioschool.model.characters.heroes.Human;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Character dao.
 */
public class CharacterDAO {

    private final ConnectionDB db;

    /**
     * Instantiates a new Character dao.
     */
    public CharacterDAO() {
        db = new ConnectionDB();
    }


    /**
     * Gets characters from database and are saved in an arraylist.
     *
     * @param code the code
     * @return the characters
     * @throws SQLException the sql exception
     */
    public List<Character> getCharacters(int code) throws SQLException {
        String sql = "SELECT name, hp, armor, race FROM " + selectType(code);
        PreparedStatement statement = null;

        try {
            db.connect();
            statement = db.getConnection().prepareStatement(sql);

            ResultSet result = statement.executeQuery();
            return getResults(result, code);
        } finally {
            if (statement != null) {
                statement.close();
            }
            db.close();
        }
    }


    private List<Character> getResults(ResultSet result, int code) throws SQLException {
        List<Character> characters = new ArrayList<>();

        while (result.next()) {
            Character character = null;
            if (code == 0) {
                if (result.getString(4).equals("human")) {
                    character = new Human(result.getString(1), result.getInt(2), result.getInt(3));
                } else if (result.getString(4).equals("elf")) {
                    character = new Elf(result.getString(1), result.getInt(2), result.getInt(3));
                } else if (result.getString(4).equals("hobbit")) {
                    character = new Hobbit(result.getString(1), result.getInt(2), result.getInt(3));
                }
            } else if (code == 1) {
                if (result.getString(4).equals("orc")) {
                    character = new Orc(result.getString(1), result.getInt(2), result.getInt(3));
                } else if (result.getString(4).equals("goblin")) {
                    character = new Goblin(result.getString(1), result.getInt(2), result.getInt(3));
                }
            }
            if (character != null) {
                characters.add(character);
            }
        }

        result.close();
        return characters;
    }

    /**
     * Add character to database.
     *
     * @param character the character
     * @throws SQLException the sql exception
     */
    public void addCharacterDB(Character character) throws SQLException {
        if (character == null) {
            System.out.println("El personaje es nulo");
            return;
        }
        String race = "";
        if (character instanceof Hero)
            race = "heroes";
        else
            race = "beasts";
        String sql = "INSERT INTO " + race + " (name, hp, armor, race) VALUES  (?, ?, ?, ?)";
        db.connect();

        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, character.getName());
            statement.setInt(2, character.getHealth());
            statement.setInt(3, character.getArmor());
            statement.setString(4, character.getClass().getSimpleName().toLowerCase());

            statement.executeUpdate();
        }
        db.close();
    }

    /**
     * Delete character from database.
     *
     * @param character the character
     * @throws SQLException the sql exception
     */
    public void deleteCharacterDB(Character character) throws SQLException {
        String table = (character instanceof Hero) ? "heroes" : "beasts";
        String sql = "DELETE FROM " + table + " WHERE name = ?";
        db.connect();

        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, character.getName());
            statement.executeUpdate();
        } finally {
            db.close();
        }
    }

    private String selectType(int code) {
        String type = "";
        if (code == 0)
            type = "heroes";
        if (code == 1)
            type = "beasts";
        return type;
    }
}
