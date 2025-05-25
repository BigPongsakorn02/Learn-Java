import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Comparator;

public class App extends Application {
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private TextArea outputArea;
    private TextField idField, nameField, lastNameField, gpaField;
    private ComboBox<String> sortByComboBox;
    private ComboBox<String> orderComboBox;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Management");

        // Input Fields
        GridPane inputGrid = createInputGrid();

        // Sort Controls
        HBox sortControls = createSortControls();

        // Output Area
        outputArea = new TextArea();
        outputArea.setEditable(false);

        // Main Layout
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(
            inputGrid, 
            createButtonBox(), 
            sortControls, 
            new Label("Student List:"),
            outputArea
        );

        // Scene and Show
        Scene scene = new Scene(mainLayout, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createInputGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.add(new Label("ID:"), 0, 0);
        idField = new TextField();
        grid.add(idField, 1, 0);

        grid.add(new Label("Name:"), 0, 1);
        nameField = new TextField();
        grid.add(nameField, 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        lastNameField = new TextField();
        grid.add(lastNameField, 1, 2);

        grid.add(new Label("GPA:"), 0, 3);
        gpaField = new TextField();
        grid.add(gpaField, 1, 3);

        return grid;
    }

    private HBox createButtonBox() {
        Button addButton = new Button("Add Student");
        addButton.setOnAction(e -> addStudent());

        Button deleteButton = new Button("Delete Selected");
        deleteButton.setOnAction(e -> deleteSelectedStudent());

        HBox buttonBox = new HBox(10, addButton, deleteButton);
        return buttonBox;
    }

    private HBox createSortControls() {
        // Sort By ComboBox
        sortByComboBox = new ComboBox<>();
        sortByComboBox.getItems().addAll(
            "ID", "Name", "Last Name", "GPA"
        );
        sortByComboBox.setValue("ID");

        // Order ComboBox
        orderComboBox = new ComboBox<>();
        orderComboBox.getItems().addAll(
            "Ascending", "Descending"
        );
        orderComboBox.setValue("Ascending");

        Button sortButton = new Button("Sort");
        sortButton.setOnAction(e -> sortStudents());

        HBox sortBox = new HBox(10);
        sortBox.getChildren().addAll(
            new Label("Sort By:"), 
            sortByComboBox, 
            new Label("Order:"), 
            orderComboBox, 
            sortButton
        );

        return sortBox;
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastName = lastNameField.getText();
            double gpa = Double.parseDouble(gpaField.getText());

            Student student = new Student(id, name, lastName, gpa);
            students.add(student);

            // Clear input fields
            clearInputFields();

            // Update output
            updateOutputArea();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid numeric values for ID and GPA.");
        }
    }

    private void deleteSelectedStudent() {
        if (!students.isEmpty()) {
            students.remove(students.size() - 1);
            updateOutputArea();
        }
    }

    private void sortStudents() {
        if (students.isEmpty()) return;

        Comparator<Student> comparator = switch(sortByComboBox.getValue()) {
            case "ID" -> Student.byId();
            case "Name" -> Student.byName();
            case "Last Name" -> Student.byLastName();
            case "GPA" -> Student.byGpa();
            default -> Student.byId();
        };

        // Reverse comparator if descending
        if (orderComboBox.getValue().equals("Descending")) {
            comparator = comparator.reversed();
        }

        // Perform QuickSort
        QuickSort.quickSort(students, comparator);

        // Update output
        updateOutputArea();
    }

    private void updateOutputArea() {
        outputArea.clear();
        students.forEach(student -> 
            outputArea.appendText(student.toString() + "\n")
        );
    }

    private void clearInputFields() {
        idField.clear();
        nameField.clear();
        lastNameField.clear();
        gpaField.clear();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}