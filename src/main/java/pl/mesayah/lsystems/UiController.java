package pl.mesayah.lsystems;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;

public class UiController implements Initializable {

    @FXML
    private Label seedLabel;

    @FXML
    private Canvas canvas;

    @FXML
    private ComboBox<Preset> presetComboBox;

    @FXML
    private TextField angleIncrementTextField;

    @FXML
    private TextField derivationLengthTextField;

    @FXML
    private TextField axiomTextField;

    @FXML
    private ListView<Map.Entry<Character, String>> productionsListView;

    private Turtle turtle;

    private LSystem system;

    @FXML
    public void onPresetChange() {

        Preset preset = presetComboBox.getValue();
        system = preset.getSystem();

        double angleIncrement = preset.getAngleIncrement();
        angleIncrementTextField.setText(Double.toString(angleIncrement));
        turtle.setAngleIncrement(angleIncrement);

        axiomTextField.setText(system.getAxiom());

        derivationLengthTextField.setText(Integer.toString(presetComboBox.getValue().getN()));

        ObservableList<Map.Entry<Character, String>> productions = new ObservableListWrapper<>(new ArrayList<>(system.getProductions().entrySet()));
        productionsListView.setItems(productions);

        turtle.resetState();

        draw();
    }

    private void draw() {

        draw(turtle.getState().getX(), turtle.getState().getY());
    }

    private void draw(double x, double y) {

        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        turtle.resetState();

        turtle.getState().setX(x);
        turtle.getState().setY(y);

        int derivationLength = Integer.parseInt(derivationLengthTextField.getText());
        String seed = system.generate(derivationLength);
        turtle.interprete(seed);

        seedLabel.setText(seed);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Preset> presets = new ObservableListWrapper<>(Presets.getPresets());
        presetComboBox.setItems(presets);

        turtle = new Turtle(10, 0, canvas);

        LSystem system = new LSystem("F-F-F-F", Collections.emptyMap());

        derivationLengthTextField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (derivationLengthTextField.getText().matches("/^[0-9]+(\\\\.[0-9]+)?$")) {
                    derivationLengthTextField.setText("");
                } else {
                    draw();
                }
            }
        });

        axiomTextField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if (axiomTextField.getText().matches("[A-Z\\+\\-\\[\\]]")) {
                    axiomTextField.setText("");
                } else {
                    system.setAxiom(axiomTextField.getText());
                    draw();
                }
            }
        });

        angleIncrementTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if (derivationLengthTextField.getText().matches("/^[0-9]+(\\\\.[0-9]+)?$")) {
                    derivationLengthTextField.setText("");
                } else {
                    double angleIncrement = Double.parseDouble(angleIncrementTextField.getText());
                    turtle.setAngleIncrement(angleIncrement);
                    draw();
                }
            }
        });

        canvas.setOnScroll(event -> {

            turtle.setStepSize(turtle.getStepSize() * (1 + event.getDeltaY() / 400));
            draw();
        });

        canvas.setOnMouseDragged(event -> {

            turtle.getState().setX(event.getSceneX());
            turtle.getState().setY(event.getSceneY());
            draw();
        });

        presetComboBox.setValue(presets.get(0));
        onPresetChange();
    }

}
