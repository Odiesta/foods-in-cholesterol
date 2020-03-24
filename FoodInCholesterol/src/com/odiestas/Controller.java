package com.odiestas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;

public class Controller {

    @FXML
    private ComboBox<String> cholesterolLevel;
    @FXML
    private TableView<Foods> foodsTable;

    public void initialize() {

        ObservableList<Foods> foodsObservableList = FXCollections.observableArrayList(
                Arrays.asList(
                        new Foods("Beef Brain", 3100),
                        new Foods("Egg yolk", 1085),
                        new Foods("Caviar", 588),
                        new Foods("Fish Oil", 521),
                        new Foods("Egg", 373),
                        new Foods("Lamb kidney", 337),
                        new Foods("Lard", 97),
                        new Foods("Beef", 90),
                        new Foods("Chicken", 88),
                        new Foods("Pork", 80),
                        new Foods("Cottage cheese", 15),
                        new Foods("Yogurt", 13),
                        new Foods("Skimmed milk", 4),
                        new Foods("Fruits", 0),
                        new Foods("Grains", 0)
                )
        );

        FilteredList<Foods> lowFilter = new FilteredList<Foods>(
                foodsObservableList, i -> i.getCholesterol() <= 20
        );

        FilteredList<Foods> moderateFilter = new FilteredList<>(
                foodsObservableList, i -> i.getCholesterol() > 20 && i.getCholesterol() <= 100
        );

        FilteredList<Foods> highFilter = new FilteredList<>(
                foodsObservableList, i -> i.getCholesterol() > 100
        );

        cholesterolLevel.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    String choice = cholesterolLevel.getSelectionModel().getSelectedItem();
                    switch (choice) {
                        case "Low":
                            foodsTable.setItems(lowFilter);
                            break;
                        case "Moderate":
                            foodsTable.setItems(moderateFilter);
                            break;
                        case "High":
                            foodsTable.setItems(highFilter);
                            break;
                        default:
                            foodsTable.setItems(foodsObservableList);
                            break;
                    }
                })
        );

        TableColumn<Foods, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Foods, Integer> cholesterolCol = new TableColumn<>("Cholesterol");
        cholesterolCol.setMinWidth(100);
        cholesterolCol.setCellValueFactory(new PropertyValueFactory<>("cholesterol"));

        foodsTable.setItems(foodsObservableList);
        foodsTable.getColumns().addAll(nameCol, cholesterolCol);


    }

}
