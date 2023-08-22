package com.example.finaltestjava2023;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class CustomersController implements Initializable {
    @FXML
    private Button allCustomersButton;

    @FXML
    private TableColumn<Customer, String> colCompany;

    @FXML
    private TableColumn<Customer, String> colCountry;

    @FXML
    private TableColumn<Customer, String> colCreatedAt;

    @FXML
    private TableColumn<Customer, String> colEmail;

    @FXML
    private TableColumn<Customer, String> colFirst;

    @FXML
    private TableColumn<Customer, String> colId;

    @FXML
    private TableColumn<Customer, String > colLast;

    @FXML
    private Button domesticCustomersButton;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private TableView<Customer> tableViewCustomers;

    @FXML
    private Label titleLabel;

    private ArrayList<Customer> allCustomers;

    @FXML
    protected void onAllCustomersButtonClick() {
        ObservableList<Customer> observableArrayList =
                FXCollections.observableArrayList(allCustomers);
        tableViewCustomers.setItems(observableArrayList);
        rowsInTableLabel.setText(String.valueOf(observableArrayList.size()));

    }


    @FXML
    protected void onDomesticCustomersButtonClick() {
        ObservableList<Customer> backingList = tableViewCustomers.getItems();
        FilteredList<Customer> filteredList = backingList.filtered(c->  c.getCountry().equals("Canada"));
        tableViewCustomers.setItems(filteredList);
        rowsInTableLabel.setText(String.valueOf(filteredList.size()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colFirst.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLast.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
        colCreatedAt.setCellValueFactory(new PropertyValueFactory<>("created_at"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));

        try (
                FileReader fileReader = new FileReader("src/main/resources/customers.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            Gson gson = new Gson();
            ApiResponse apiResponse= gson.fromJson(jsonReader,ApiResponse.class);
            tableViewCustomers.getItems().addAll(apiResponse.getCustomers());
            titleLabel.setText(apiResponse.getCompany());
            rowsInTableLabel.setText(Integer.toString( apiResponse.getCustomers().size()));
            allCustomers = apiResponse.getCustomers();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}