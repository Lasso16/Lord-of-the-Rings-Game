package org.tokioschool;


import javafx.collections.FXCollections;
import org.tokioschool.ButtonListeners.*;
import org.tokioschool.DAO.CharacterDAO;
import org.tokioschool.model.AppModel;
import org.tokioschool.model.AvailableCharacters;
import org.tokioschool.model.characters.Character;
import org.tokioschool.model.characters.beasts.Beast;
import org.tokioschool.model.characters.heroes.Hero;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class AppController {

    private final AppModel model;
    private final AppView view;
    private final CharacterDAO db;

    public AppController(AppModel model, AppView view) {
        this.model = model;
        this.view = view;
        db = new CharacterDAO();
        initApp();

    }

    private void initApp() {
        fillAvailableCharacters();
        showCharacters();
        addActions();
    }

    public void showCharacters() {
        view.getLeftArmyPane().getTopListPane().getListOfCharacters().setItems(FXCollections.observableArrayList(model.getAvailableHeroes().getAvailableCharacters()));
        view.getRightArmyPane().getTopListPane().getListOfCharacters().setItems(FXCollections.observableArrayList(model.getAvailableBeasts().getAvailableCharacters()));
        view.getLeftArmyPane().getBotListPane().getListOfCharacters().setItems(model.getTeamHeroes().getObservableTeam());
        view.getRightArmyPane().getBotListPane().getListOfCharacters().setItems(model.getTeamBeasts().getObservableTeam());
        view.canDelete(false);
    }

    public void reset() {
        fillAvailableCharacters();
        model.getTeamHeroes().getTeam().clear();
        model.getTeamBeasts().getTeam().clear();
        showCharacters();
    }

    private void addActions() {
        addHeroesActions();
        addBeastsActions();
        addOtherActions();
    }


    private void fillAvailableCharacters() {
        if (model.getAvailableHeroes() == null && model.getAvailableBeasts() == null) {
            AvailableCharacters heroesAvailable = new AvailableCharacters();
            AvailableCharacters beastsAvailable = new AvailableCharacters();
        }
        model.getAvailableHeroes().getAvailableCharacters().clear();
        model.getAvailableBeasts().getAvailableCharacters().clear();

        try {
            model.getAvailableHeroes().getAvailableCharacters().addAll(db.getCharacters(0));
            model.getAvailableBeasts().getAvailableCharacters().addAll(db.getCharacters(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.getAvailableHeroes().getAvailableCharacters().sort(Comparator.comparing(Character::getName, String.CASE_INSENSITIVE_ORDER));
        model.getAvailableBeasts().getAvailableCharacters().sort(Comparator.comparing(Character::getName, String.CASE_INSENSITIVE_ORDER));
        model.setAvailableHeroes(model.getAvailableHeroes());
        model.setAvailableBeasts(model.getAvailableBeasts());
    }

    public void fight() {
        if (!model.getTeamHeroes().getTeam().isEmpty() && !model.getTeamBeasts().getTeam().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Hero hero = null;
            Beast beast = null;
            boolean isFinished = false;
            int damage = 0;
            int round = 1;
            ArrayList<Character> teamHeroesAux = model.getTeamHeroes().getTeam();
            ArrayList<Character> teamBeastsAux = model.getTeamBeasts().getTeam();
            sb.append(model.getTeamHeroes()).append(model.getTeamBeasts());

            while (!isFinished) {
                Iterator<Character> heroIterator = teamHeroesAux.iterator();
                Iterator<Character> beastIterator = teamBeastsAux.iterator();

                sb.append("\nTurno ").append(round++).append("\n");

                while (heroIterator.hasNext() && beastIterator.hasNext()) {
                    damage = 0;
                    hero = (Hero) heroIterator.next();
                    beast = (Beast) beastIterator.next();
                    sb.append("Lucha entre ").append(hero).append(" y ").append(beast).append("\n");

                    damage = hero.attack(beast);
                    sb.append(hero.getName()).append(" ha sacado ").append(hero.getHeroAttackValue()).append(" y le quita ").append(damage).append(" de vida a ").append(beast.getName()).append("\n");

                    if (beast.isAlive()) {
                        damage = beast.attack(hero);
                        sb.append(beast.getName()).append(" ha sacado ").append(beast.getBeastAttackValue()).append(" y le quita ").append(damage).append(" de vida a ").append(hero.getName()).append("\n");
                    }

                    if (!hero.isAlive()) {
                        heroIterator.remove();
                        model.getTeamHeroes().getTeam().remove(hero);
                        sb.append(hero.getName()).append(" ha muerto.\n");
                    }
                    if (!beast.isAlive()) {
                        beastIterator.remove();
                        sb.append(beast.getName()).append(" ha muerto.\n");
                    }
                    sb.append("\n");
                }


                if (teamHeroesAux.isEmpty() || teamBeastsAux.isEmpty()) {
                    isFinished = true;
                }
            }

            sb.append("¡Ha ganado el equipo de ").append(teamHeroesAux.isEmpty() ? "las Bestias!" : "los Héroes!");

            view.getFightPane().getFightConsole().setText(sb.toString());
            view.getFightPane().openFightPane();

            reset();
        }
    }


    public void addCharacterDB(Character character) {
        try {
            db.addCharacterDB(character);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteCharacterDB(Character character) {
        try {
            db.deleteCharacterDB(character);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addHeroesActions() {
        HeroesButtonListeners hbl = new HeroesButtonListeners(view, model, this);
        view.getLeftArmyPane().getTopListPane().getButtonAdd().setOnAction(hbl);
        view.getLeftArmyPane().getBotListPane().getButtonDelete().setOnAction(hbl);
        view.getLeftArmyPane().getBotListPane().getButtonUp().setOnAction(hbl);
        view.getLeftArmyPane().getBotListPane().getButtonDown().setOnAction(hbl);
        view.getLeftArmyPane().getTopListPane().getButtonNew().setOnAction(hbl);
        view.getLeftArmyPane().getTopListPane().getButtonDelete().setOnAction(hbl);

        view.getLeftArmyPane().getTopListPane().getListOfCharacters().setOnMouseClicked(new AvailableHeroesListListener(view));
    }

    private void addBeastsActions() {
        BeastButtonListeners bbl = new BeastButtonListeners(view, model, this);
        view.getRightArmyPane().getTopListPane().getButtonAdd().setOnAction(bbl);
        view.getRightArmyPane().getBotListPane().getButtonDelete().setOnAction(bbl);
        view.getRightArmyPane().getBotListPane().getButtonUp().setOnAction(bbl);
        view.getRightArmyPane().getBotListPane().getButtonDown().setOnAction(bbl);
        view.getRightArmyPane().getTopListPane().getButtonNew().setOnAction(bbl);
        view.getRightArmyPane().getTopListPane().getButtonDelete().setOnAction(bbl);

        view.getRightArmyPane().getTopListPane().getListOfCharacters().setOnMouseClicked(new AvailableBeastsListListener(view));
    }

    private void addOtherActions() {
        NewCharacterListeners ncl = new NewCharacterListeners(view, model, this, db);
        FightButtonListener fbl = new FightButtonListener(view, model, this);

        view.getAddNewHeroPane().getCancelButton().setOnAction(ncl);
        view.getAddNewBeastPane().getCancelButton().setOnAction(ncl);
        view.getAddNewHeroPane().getSaveButton().setOnAction(ncl);
        view.getAddNewBeastPane().getSaveButton().setOnAction(ncl);

        view.getBotPane().setOnAction(fbl);
    }
}