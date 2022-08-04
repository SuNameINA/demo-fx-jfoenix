package com.example.fxjfoenix2.main.controller;

import com.example.fxjfoenix2.main.model.entity.Person;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.StackPane;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Function;

public class TreeTableViewController {

    @FXML
    private StackPane root;

    private static final String PREFIX = "( ";

    private static final String POSTFIX = " )";

    @FXML
    private JFXTreeTableView<Person> treeTableView;

    @FXML
    private JFXTreeTableColumn firstNameColumn;

    @FXML
    private JFXTreeTableColumn lastNameColumn;

    @FXML
    private JFXTreeTableColumn ageColumn;

    @FXML
    private Label treeTableViewCount;

    @FXML
    private JFXButton treeTableViewAdd;

    @FXML
    private JFXButton treeTableViewRemove;

    @FXML
    private JFXTextField searchField;

    private BooleanProperty removeDisable;

    private final String[] names = {"Morley", "Scott", "Kruger", "Lain",
            "Kennedy", "Gawron", "Han", "Hall", "Aydogdu", "Grace",
            "Spiers", "Perera", "Smith", "Connoly",
            "Sokolowski", "Chaow", "James", "June",};

    private final Random random = new SecureRandom();

    public void initialize() throws Exception {
        this.setupReadOnlyTableView();
        this.setupEditableTableView();
    }

    private void setupReadOnlyTableView() {
        this.setupCellValueFactory(firstNameColumn, Person::firstNameProperty);
        this.setupCellValueFactory(lastNameColumn, Person::lastNameProperty);
        this.setupCellValueFactory(ageColumn, Person::ageProperty);
//        ObservableList<Person> persons = this.generatePersons(100);
        ObservableList<Person> persons = FXCollections.observableArrayList();
        treeTableView.setRoot(new RecursiveTreeItem<>(persons, RecursiveTreeObject::getChildren));
        treeTableView.setShowRoot(false);

        treeTableViewCount.textProperty()
                .bind(Bindings.createStringBinding(() -> PREFIX + treeTableView.getCurrentItemsCount() + POSTFIX,
                        treeTableView.currentItemsCountProperty()));

        treeTableViewAdd.setOnMouseClicked((e) -> {
            persons.add(this.createNewRandomPerson());
            IntegerProperty currentItem = treeTableView.currentItemsCountProperty();
            currentItem.set(currentItem.get() + 1);

            if (persons.size() == 1) {
                treeTableViewRemove.setDisable(true);
            } else if (treeTableView.getSelectionModel().getSelectedIndex() > 0) {
                treeTableViewRemove.setDisable(false);
            }
        });
        treeTableViewRemove.setOnMouseClicked((e) -> {
            persons.remove(treeTableView.getSelectionModel().selectedItemProperty().get().getValue());
            IntegerProperty currentItem = treeTableView.currentItemsCountProperty();
            if (currentItem.get() > 0) {
                currentItem.set(currentItem.get() - 1);
            }

            if (persons.isEmpty()) {
                treeTableViewRemove.setDisable(true);
            }
        });

        treeTableViewAdd.disableProperty()
                .bind(Bindings.lessThan(9, treeTableView.currentItemsCountProperty()));
//        treeTableViewRemove.disableProperty()
//                .bind(Bindings.createBooleanBinding(() -> removeDisable.get(), removeDisable));

        treeTableView.addEventHandler(EventType.ROOT, event -> {
            if (!persons.isEmpty() && treeTableView.getSelectionModel().getSelectedIndex() > 0) {
                treeTableViewRemove.setDisable(false);
            }
        });

        treeTableViewRemove.setDisable(true);

        searchField.textProperty().addListener(this.setupSearchField(treeTableView));
    }

    private void setupEditableTableView() {

    }

    ObservableList<Person> generatePersons(int count) {
        ObservableList<Person> persons = FXCollections.observableArrayList();
        for (int i = 0; i < count; i++) {
            persons.add(this.createNewRandomPerson());
        }
        return persons;
    }

    private Person createNewRandomPerson() {
        return new Person(names[random.nextInt(names.length)],
                names[random.nextInt(names.length)],
                random.nextInt(100));
    }

    public <T> void setupCellValueFactory(JFXTreeTableColumn<Person, T> column, Function<Person, ObservableValue<T>> mapper) {
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, T> param) -> {
            if (column.validateValue(param)) {
                return mapper.apply(param.getValue().getValue());
            } else {
                return column.getComputedValue(param);
            }
        });
    }

    private ChangeListener<String> setupSearchField(JFXTreeTableView<Person> tableView) {
        return (observable, oldValue, newValue) -> {
            tableView.setPredicate(personProp -> {
                Person person = personProp.getValue();
                return person.getFirstName().contains(newValue)
                        || person.getLastName().contains(newValue)
                        || Integer.toString(person.getAge()).contains(newValue);
            });
        };
    }

}
