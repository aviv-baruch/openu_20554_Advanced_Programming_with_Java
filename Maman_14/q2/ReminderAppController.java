package q2;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.Hashtable;
import java.util.Optional;

/**
 * Controller class for the ReminderApp.
 */
public class ReminderAppController {

    @FXML
    private Button addBtn;

    @FXML
    private VBox vbox;

    @FXML
    private ComboBox<Integer> ddDropDown;

    @FXML
    private ComboBox<Integer> mmDropDown;

    @FXML
    private ComboBox<Integer> yyDropDown;

    @FXML
    private TextArea txt;

    private Hashtable<Date, String> notes; // HashTable to store notes

    private boolean isExporting = false;

    /**
     * Initialize the controller.
     */
    @FXML
    public void initialize() {
        notes = new Hashtable<Date, String>();
        initDropDowns();
        showImportDialog();
    }

    /**
     * Add a window close listener to handle exporting notes on window close.
     */
    private void addWindowCloseListener() {
        Stage stage = (Stage) ((Node)vbox).getScene().getWindow();
        stage.getScene().getWindow().addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,event1 -> showExportDialog());
    }

    /**
     * Show a dialog to prompt the user for importing notes from a file.
     */
    private void showImportDialog() {
        Alert importDialog = new Alert(Alert.AlertType.CONFIRMATION);
        importDialog.setTitle("Import Notes");
        importDialog.setHeaderText("Do you want to import notes?");
        importDialog.setContentText("Choose your option.");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        importDialog.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = importDialog.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            importFromFile();
        }
    }

    /**
     * Show a file chooser dialog and return the selected file.
     *
     * @return The selected file.
     */
    private File getFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        fileChooser.setInitialDirectory(new File("."));
        return fileChooser.showOpenDialog(null);
    }

    /**
     * Import notes from a file.
     */
    private void importFromFile() {
        File file = getFile();
        if (file != null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                notes = (Hashtable<Date, String>) ois.readObject();
                showAlert("Success", "Notes imported successfully from the file.");
            } catch (IOException | ClassNotFoundException e) {
                showAlert("Error", "Failed to import notes from the file.");
            }
        }
    }

    /**
     * Show a dialog to prompt the user for exporting notes to a file.
     */
    private void showExportDialog() {
        Alert exportDialog = new Alert(Alert.AlertType.CONFIRMATION);
        exportDialog.setTitle("Export Notes");
        exportDialog.setHeaderText("Do you want to export notes?");
        exportDialog.setContentText("Choose your option.");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        exportDialog.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = exportDialog.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            exportToFile();
        } else {
            // Handle the case when user clicks "No" or closes the dialog
            showAlert("Info", "Notes not exported.");
        }
    }

    /**
     * Export notes to a file.
     */
    private void exportToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export Notes");
        fileChooser.setInitialDirectory(new File("."));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(notes);
                showAlert("Success", "Notes exported successfully to the file.");
            } catch (IOException e) {
                showAlert("Error", "Failed to export notes: " + e.getMessage());
            }
        } else {
            showAlert("Info", "Export canceled.");
        }
    }

    /**
     * Initialize the dropdowns with default values.
     */
    private void initDropDowns() {
        // Populate dropdowns with values
        for (int i = 1; i <= 31; i++) {
            ddDropDown.getItems().add(i);
        }
        ddDropDown.setValue(1);
        for (int i = 1; i <= 12; i++) {
            mmDropDown.getItems().add(i);
        }
        mmDropDown.setValue(1);
        for (int i = 2022; i <= 2099; i++) {
            yyDropDown.getItems().add(i);
        }
        yyDropDown.setValue(2022);
    }

    @FXML
    void dayOnClick(ActionEvent event) {
        addBtn.setText("Add");
        txt.setText("");
    }

    @FXML
    void monthOnClick(ActionEvent event) {
        addBtn.setText("Add");
        txt.setText("");
    }

    @FXML
    void yearOnClick(ActionEvent event) {
        addBtn.setText("Add");
        txt.setText("");
    }

    /**
     * Handle the "Add" button click event.
     */
    @FXML
    void addOnClick(ActionEvent event) {
        Integer day = ddDropDown.getValue();
        Integer month = mmDropDown.getValue();
        Integer year = yyDropDown.getValue();
        String note = txt.getText();

        if (day == null || month == null || year == null) {
            showAlert("Error", "Please select a valid date.");
            return;
        }

        if (day == 0 || month == 0 || year == 0) {
            showAlert("Error", "Please select a valid date.");
            return;
        }

        if (note.isEmpty()) {
            showAlert("Error", "Please enter a note.");
            return;
        }

        try {
            Date date = new Date(day, month, year);
            notes.put(date, note);
            showAlert("Success", "Note added: " + date + " - " + note);
            addBtn.setText("Edit");
            if(!isExporting) {
                addWindowCloseListener();
                isExporting = true;
            }
        } catch (IllegalArgumentException e) {
            showAlert("Error", "Invalid date: " + e.getMessage());
        }

    }

    /**
     * Handle the "Show" button click event.
     */
    @FXML
    void showOnClick(ActionEvent event) {
        Integer day = ddDropDown.getValue();
        Integer month = mmDropDown.getValue();
        Integer year = yyDropDown.getValue();

        if (day == null || month == null || year == null) {
            showAlert("Error", "Please select a valid date.");
            return;
        }

        if (day == 0 || month == 0 || year == 0) {
            showAlert("Error", "Please select a valid date.");
            return;
        }

        Date date = new Date(day, month, year);
        String note = notes.get(date);

        if (note == null) {
            showAlert("Note not found", "No note found for the selected date.");
            addBtn.setText("Add");
            txt.setText("");

        } else {
            addBtn.setText("Edit");
            txt.setText(note);
        }
    }

    /**
     * Show an alert dialog with the specified title and message.
     *
     * @param title   The title of the alert dialog.
     * @param message The message of the alert dialog.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
