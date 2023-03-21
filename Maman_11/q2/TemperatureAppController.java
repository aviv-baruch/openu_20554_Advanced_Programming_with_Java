package q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class TemperatureAppController {

    @FXML
    private Canvas canv;

    @FXML
    private Label year;

    @FXML
    private Button btn;

    private GraphicsContext gc;
    final int BAR_WIDTH = 26;
    final int FIRST_YEAR = 2018;
    final int LAST_YEAR = 2022;
    final int GRAPH_START_POINT = 29;
    final int BARS_JUMP_PADDING = 45;
    final int MIN_TEMP = 0;
    final int MAX_TEMP = 50;
    final int AMOUNT_OF_MONTH = 12;
    final int MIN_BAR_SIZE = 1;

    private int yearDate = 2018;
    private int graphID = 0;

    @FXML
    public void initialize() {
        gc = canv.getGraphicsContext2D();
    }

    @FXML
    private void drawGraph(ActionEvent event) {
        final double CANVAS_WIDTH = canv.getWidth();
        final double CANVAS_HEIGHT = canv.getHeight();
        TemperatureData tempData = new TemperatureData();
        // Get the current year's temperature data
        ArrayList<Integer> temperatures = tempData.getTemperatureForYear(getYearDate());
        year.setText(Integer.toString(getYearDate()));

        // Calculate the minimum and maximum temperature
        final int minTemp = temperatures.stream().min(Integer::compare).orElse(MIN_TEMP);
        final int maxTemp = temperatures.stream().max(Integer::compare).orElse(MAX_TEMP);
        // Calculate the height of each bar based on the canvas height and the range of
        // temperatures
        final double barHeightUnit = CANVAS_HEIGHT / MAX_TEMP;
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // Draw the bars for each month
        double x = GRAPH_START_POINT;
        for (int i = 0; i < AMOUNT_OF_MONTH; i++) {
            // Calculate the scaled height of the bar
            double temp = temperatures.get(i);
            double scaledHeight = (temp == MIN_TEMP) ? MIN_BAR_SIZE : barHeightUnit * temp;

            // Draw the bar
            if (temp == minTemp) {
                gc.setFill(Color.BLUE);
            } else if (temp == maxTemp) {
                gc.setFill(Color.RED);
            } else {
                gc.setFill(Color.GREY);
            }
            gc.fillRect(x, CANVAS_HEIGHT - scaledHeight, BAR_WIDTH, scaledHeight);

            // Move to the next x coordinate
            x += BARS_JUMP_PADDING;
        }

        // Update the year and graph ID for the next graph
        setYearDate();
    }

    /**
     * Get the current year.
     *
     * @return The current year.
     */
    public int getYearDate() {
        return yearDate;
    }

    /**
     * Set the year to the next year, and reset the graph ID if the year is 2022.
     */
    public void setYearDate() {
        if (yearDate == LAST_YEAR) {
            yearDate = FIRST_YEAR;
            setGraphID(0);
        } else {
            int currentID = getGraphID();
            yearDate++;
            setGraphID(currentID + 1);
        }
    }

    /**
     * Get the current graph ID.
     *
     * @return The current graph ID.
     */
    public int getGraphID() {
        return graphID;
    }

    /**
     * Set the graph ID to the specified value.
     *
     * @param newID The new graph ID.
     */
    public void setGraphID(int newID) {
        graphID = newID;
    }
}