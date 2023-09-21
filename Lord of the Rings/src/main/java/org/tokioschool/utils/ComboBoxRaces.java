package org.tokioschool.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Combo box races.
 */
public class ComboBoxRaces {

    /**
     * Fills the combo box with the hero races.
     *
     * @return the observable list
     */
    public static ObservableList<String> heroRaces() {
        List<String> list = new ArrayList<>();
        list.add("Humano");
        list.add("Elfo");
        list.add("Hobbit");

        return FXCollections.observableArrayList(list);
    }

    /**
     * Fills the combo box with the beast races.
     *
     * @return the observable list
     */
    public static ObservableList<String> beastRaces() {
        List<String> list = new ArrayList<>();
        list.add("Orco");
        list.add("Trasgo");

        return FXCollections.observableArrayList(list);
    }
}
