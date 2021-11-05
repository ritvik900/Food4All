package sample;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private TableView<Person> table = new TableView<Person>();
    //private TableView<Person1> sheltTable = new TableView<Person1>();

    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person("Example", "Example", "example.123@example.com", "Comment"));
    private final ObservableList<Person1> dataVol =
            FXCollections.observableArrayList(
                    new Person1("Example", "Example", "example.123@example.com", "Comment"));
    final HBox hb = new HBox();
    final HBox hbVol = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene2 = new Scene(new Group());
        TextField whatFood = new TextField();
        whatFood.setPromptText("What Food");
        TextField whatQuantity = new TextField();
        whatQuantity.setPromptText("Quantity");
        TextField whatRestaurant = new TextField();
        whatRestaurant.setPromptText("Which Shelter");
        ArrayList<String> globalUserArr = new ArrayList<String>();
        globalUserArr.add("admin");
        stage.setTitle("Donation Page");
        stage.setWidth(450);
        final ListView<String> list = new ListView<>();
        list.setCellFactory(TextFieldListCell.forListView());

        list.setEditable(true);
        Label foodType = new Label("Food Type");
        Label foodQuantity = new Label("Quantity");
        Label restaurant = new Label("Restaurant");
        foodType.setAlignment(Pos.CENTER_RIGHT);
        foodQuantity.setAlignment(Pos.CENTER_RIGHT);
        Button button2 = new Button("Log out");
        Button btn = new Button();
        btn.setText("Add String");
        btn.setOnAction((ActionEvent event) -> {
            list.getItems().add("" + whatFood.getText() + ", " + whatQuantity.getText() + ", " + whatRestaurant.getText());
            //list.edit(i - 1);
            //i++;
        });
        stage.setHeight(550);

        HBox layout2 = new HBox();

        Text text = new Text("");
        //Setting font to the label
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10);
        text.setFont(font);
        text.setTranslateX(15);
        text.setTranslateY(125);
        text.setFill(Color.BROWN);
        text.maxWidth(580);
        text.setWrappingWidth(580);

        final Label label = new Label("Food Availability");
        label.setTranslateY(5);
        final Label voluntLabel = new Label("Food Requests");
        voluntLabel.setTranslateX(510);
        voluntLabel.setTranslateY(440);
        label.setFont(new Font("Arial", 20));
        voluntLabel.setFont(new Font("Arial", 20));

        Label label1 = new Label("Username: ");
        Label label2 = new Label("Password: ");
        table.setEditable(true);
        //sheltTable.setEditable(true);

        TableColumn firstNameCol = new TableColumn("Food Type");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
                    }
                }
        );

        /*TableColumn firstNameCol1 = new TableColumn("Food Type");
        firstNameCol1.setMinWidth(100);
        firstNameCol1.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName1"));
        firstNameCol1.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol1.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t1) {
                        ((Person) t1.getTableView().getItems().get(
                                t1.getTablePosition().getRow())
                        ).setFirstName1(t1.getNewValue());
                    }
                }
        );*/

        TableColumn lastNameCol = new TableColumn("Quantity");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
                    }
                }
        );





        TableColumn emailCol = new TableColumn("Restaurant Name");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));



        TableColumn commentCol = new TableColumn("Comment");
        commentCol.setMinWidth(200);
        commentCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("comment"));
        commentCol.setCellFactory(TextFieldTableCell.forTableColumn());
        commentCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setComment(t.getNewValue());
                    }
                }
        );

        TableColumn firstagainCol = new TableColumn("Food Type");
        firstagainCol.setMinWidth(100);
        firstagainCol.setCellValueFactory(
                new PropertyValueFactory<Person1, String>("firstName"));
        firstagainCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstagainCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person1, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person1, String> t) {
                        ((Person1) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstName1(t.getNewValue());
                    }
                }
        );

        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, commentCol);

        //sheltTable.setItems(dataVol);
        //sheltTable.getColumns().addAll(firstNameCol1);



        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("Food Type");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addFirstName1 = new TextField();
        addFirstName1.setPromptText("Food Type");
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Quantity");
        final TextField addLastName1 = new TextField();
        addLastName1.setPromptText("Quantity");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Restaurant Name");
        final TextField addEmail1 = new TextField();
        addEmail1.setPromptText("Restaurant Name");
        final TextField addComment = new TextField();
        addComment.setMaxWidth(commentCol.getPrefWidth());
        addComment.setPromptText("Comment");
        final TextField addComment1 = new TextField();
        addComment1.setPromptText("Comment");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText(),
                        addComment.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
                addComment.clear();
            }
        });
        final Button addButton1 = new Button("Add");
        addButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dataVol.add(new Person1(
                        addFirstName1.getText(),
                        addLastName1.getText(),
                        addEmail1.getText(),
                        addComment1.getText()));
                addFirstName1.clear();
                addLastName1.clear();
                addEmail1.clear();
                addComment1.clear();
            }
        });
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Label title = new Label("Food4All");
        title.setFont(Font.font("Cambria", 32));
        HBox box = new HBox(5);
        box.setPadding(new Insets(25, 5 , 5, 50));
        box.getChildren().addAll(title,label1, textField1, label2, textField2);
        Button button = new Button("Submit");
        button.setTranslateX(250);
        button.setTranslateY(75);
        Group root = new Group(box, button, text);

        button.setOnAction(e -> {
            //Retrieving data
            String name = textField1.getText();
            String email = textField2.getText();
            if (globalUserArr.contains(textField1.getText()) && textField2.getText().equals("foodPwd")) {
                stage.setScene(scene2);
            }
        });

        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.setSpacing(3);

        //hbVol.getChildren().addAll(addFirstName1, addButton1);
        hbVol.setSpacing(3);
        VBox buttonLab = new VBox();
        buttonLab.getChildren().addAll(whatFood, whatQuantity, whatRestaurant,btn);
        layout2.getChildren().addAll(button2, text, list, buttonLab);
        final VBox tempBox = new VBox();
        tempBox.setSpacing(5);
        tempBox.setPadding(new Insets(10, 0, 0, 10));
        tempBox.getChildren().addAll(label, voluntLabel, table, hb, hbVol);
        GridPane finBox = new GridPane();
        finBox.setAlignment(Pos.CENTER);
        finBox.add(tempBox, 0, 0);
        finBox.add(layout2, 0, 1);
        //BorderPane finBox = new BorderPane(tempBox, layout2);
        //finBox.getChildren().addAll(tempBox, layout2);
        //finBox.setAlignment(tempBox, Pos.CENTER_LEFT);
        //layout2.setTranslateX(-500);
        //layout2.setTranslateY(50);
        /*final VBox shelterBox = new VBox();
        shelterBox.setSpacing(5);
        shelterBox.setPadding(new Insets(10, 0, 0, 650));
        shelterBox.getChildren().addAll(voluntLabel ,sheltTable, hbVol);*/

        ((Group) scene2.getRoot()).getChildren().addAll(finBox);
        Scene scene = new Scene(root, 300, 300, Color.BEIGE);
        button2.setOnAction(e -> stage.setScene(scene));

        stage.setScene(scene);
        stage.show();
    }

    public static class Person {

        private final SimpleStringProperty foodType;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty comment;

        private Person(String fName, String lName, String email, String comment) {
            this.foodType = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.comment = new SimpleStringProperty(comment);
        }

        public String getFirstName() {
            return foodType.get();
        }

        public void setFirstName(String fName) {
            foodType.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }

        public String getComment() {
            return comment.get();
        }

        public void setComment(String fName) {
            comment.set(fName);
        }
    }

    public static class Person1 {

        private final SimpleStringProperty foodType1;
        private final SimpleStringProperty lastName1;
        private final SimpleStringProperty email1;
        private final SimpleStringProperty comment1;

        private Person1(String fName, String lName, String email, String comment) {
            this.foodType1 = new SimpleStringProperty(fName);
            this.lastName1 = new SimpleStringProperty(lName);
            this.email1 = new SimpleStringProperty(email);
            this.comment1 = new SimpleStringProperty(comment);
        }

        public String getFirstName1() {
            return foodType1.get();
        }


        public void setFirstName1(String fName) {
            foodType1.set(fName);
        }

        public String getLastName1() {
            return lastName1.get();
        }

        public void setLastName1(String fName) {
            lastName1.set(fName);
        }

        public String getEmail1() {
            return email1.get();
        }

        public void setEmail1(String fName) {
            email1.set(fName);
        }

        public String getComment1() {
            return comment1.get();
        }

        public void setComment1(String fName) {
            comment1.set(fName);
        }

    }

}
