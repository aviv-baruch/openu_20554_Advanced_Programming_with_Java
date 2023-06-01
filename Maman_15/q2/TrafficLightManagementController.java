package q2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Controller class for managing the traffic light display.
 */
public class TrafficLightManagementController {

    @FXML
    private Rectangle top_ped_red;

    @FXML
    private Rectangle top_ped_green;

    @FXML
    private Circle top_vehicle_red;

    @FXML
    private Circle top_vehicle_green;

    @FXML
    private Rectangle right_ped_red;

    @FXML
    private Rectangle right_ped_green;

    @FXML
    private Circle right_vehicle_red;

    @FXML
    private Circle right_vehicle_green;

    @FXML
    private Rectangle left_ped_red;

    @FXML
    private Rectangle left_ped_green;

    @FXML
    private Circle left_vehicle_red;

    @FXML
    private Circle left_vehicle_green;

    @FXML
    private Rectangle bottom_ped_red;

    @FXML
    private Rectangle bottom_ped_green;

    @FXML
    private Circle bottom_vehicle_red;

    @FXML
    private Circle bottom_vehicle_green;

    private final int MINIMUM_BLINKING_CYCLE = 400; // ms
    private final int HALF_BLINKING_CYCLE = 200; // ms

    private int greenLightDuration;

    /**
     * Sets the duration for the green light of the traffic lights.
     *
     * @param greenLightDuration the duration for the green light in milliseconds
     */
    public void setLightDurations(int greenLightDuration) {
        this.greenLightDuration = greenLightDuration;
    }

    /**
     * Initializes the traffic light display.
     */
    public void initialize() {
        updateTrafficLights();
    }

    /**
     * Sets the fill color of a circle.
     *
     * @param circle the circle to set the color for
     * @param color  the color to set
     */
    private void setCircleColor(Circle circle, Color color) {
        circle.setFill(color);
    }

    /**
     * Sets the fill color of a rectangle.
     *
     * @param rectangle the rectangle to set the color for
     * @param color     the color to set
     */
    private void setRectangleColor(Rectangle rectangle, Color color) {
       rectangle.setFill(color);
    }

    /**
     * Updates the traffic lights periodically.
     */
    public void updateTrafficLights() {
        setAllBlack();

        Thread trafficThread = new Thread(() -> {
            while (true) {
                try {
                    setTopBottomStateOneColors();
                    setRightLeftStateZeroColors();
                    Thread.sleep(greenLightDuration);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    break;
                }

                try {
                    setTopBottomStateZeroColors();
                    setRightLeftStateOneColors();
                    Thread.sleep(greenLightDuration);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    break;
                }
            }
        });

        trafficThread.start();
    }

    /*
    vehicle green, ped red
     */
    private void setTopBottomStateOneColors() {
        setCircleColor(top_vehicle_red, Color.BLACK);
        setCircleColor(top_vehicle_green, Color.GREEN);
        setRectangleColor(top_ped_red, Color.RED);
        setRectangleColor(top_ped_green, Color.BLACK);

        setCircleColor(bottom_vehicle_red, Color.BLACK);
        setCircleColor(bottom_vehicle_green, Color.GREEN);
        setRectangleColor(bottom_ped_red, Color.RED);
        setRectangleColor(bottom_ped_green, Color.BLACK);
    }

    /*
    vehicle red, ped green
     */
    private void setTopBottomStateZeroColors() {
        setCircleColor(top_vehicle_red, Color.RED);
        setCircleColor(top_vehicle_green, Color.BLACK);
        setRectangleColor(top_ped_red, Color.BLACK);
        setBlinkingRectangleColor(top_ped_green);

        setCircleColor(bottom_vehicle_red, Color.RED);
        setCircleColor(bottom_vehicle_green, Color.BLACK);
        setRectangleColor(bottom_ped_red, Color.BLACK);
        setBlinkingRectangleColor(bottom_ped_green);
    }

    /*
    vehicle red, ped green
     */
    private void setRightLeftStateZeroColors() {
        setCircleColor(right_vehicle_red, Color.RED);
        setCircleColor(right_vehicle_green, Color.BLACK);
        setRectangleColor(right_ped_red, Color.BLACK);
        setBlinkingRectangleColor(right_ped_green);

        setCircleColor(left_vehicle_red, Color.RED);
        setCircleColor(left_vehicle_green, Color.BLACK);
        setRectangleColor(left_ped_red, Color.BLACK);
        setBlinkingRectangleColor(left_ped_green);
    }

    /*
    vehicle green, ped red
     */
    private void setRightLeftStateOneColors() {
        setCircleColor(right_vehicle_red, Color.BLACK);
        setCircleColor(right_vehicle_green, Color.GREEN);
        setRectangleColor(right_ped_red, Color.RED);
        setRectangleColor(right_ped_green, Color.BLACK);

        setCircleColor(left_vehicle_red, Color.BLACK);
        setCircleColor(left_vehicle_green, Color.GREEN);
        setRectangleColor(left_ped_red, Color.RED);
        setRectangleColor(left_ped_green, Color.BLACK);
    }

    /**
     * Sets the fill color of a rectangle to create a blinking effect.
     *
     * @param rectangle the rectangle to set the color for
     */
    private void setBlinkingRectangleColor(Rectangle rectangle) {
        if (greenLightDuration < MINIMUM_BLINKING_CYCLE) {
            setRectangleColor(rectangle, Color.GREEN);
        } else {
            Thread blinkingThread = new Thread(() -> {
                int cycles = greenLightDuration / MINIMUM_BLINKING_CYCLE;
                for (int i = 0; i < cycles; i++) {
                    try {
                        Thread.sleep(HALF_BLINKING_CYCLE);
                        Platform.runLater(() -> setRectangleColor(rectangle, Color.GREEN));
                        Thread.sleep(HALF_BLINKING_CYCLE);
                        Platform.runLater(() -> setRectangleColor(rectangle, Color.BLACK));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                        break;
                    }
                }
                try {
                    Thread.sleep(greenLightDuration);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            });
            blinkingThread.start();
        }
    }

    /**
     * Sets the fill color of all circles and rectangles to black.
     */
    private void setAllBlack() {
        setCircleColor(right_vehicle_red, Color.BLACK);
        setCircleColor(right_vehicle_green, Color.BLACK);
        setRectangleColor(right_ped_red, Color.BLACK);
        setRectangleColor(right_ped_green, Color.BLACK);

        setCircleColor(left_vehicle_red, Color.BLACK);
        setCircleColor(left_vehicle_green, Color.BLACK);
        setRectangleColor(left_ped_red, Color.BLACK);
        setRectangleColor(left_ped_green, Color.BLACK);

        setCircleColor(top_vehicle_red, Color.BLACK);
        setCircleColor(top_vehicle_green, Color.BLACK);
        setRectangleColor(top_ped_red, Color.BLACK);
        setRectangleColor(top_ped_green, Color.BLACK);

        setCircleColor(bottom_vehicle_red, Color.BLACK);
        setCircleColor(bottom_vehicle_green, Color.BLACK);
        setRectangleColor(bottom_ped_red, Color.BLACK);
        setRectangleColor(bottom_ped_green, Color.BLACK);
    }
}
