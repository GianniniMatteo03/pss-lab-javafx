package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //ho usato HBox, ma il funzionamento non cambia, solo che imposta i campi orrizzontalmente
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Controls Exercise!");
        final Counter counter = new Counter();
        // TODO aggiungere gli elementi come descritto da readme
        final Label lbl = new Label();
        lbl.setText("0");
        lbl.textProperty().bind(counter.counterProperty().asString());

        final Button btn = new Button();
        btn.setText("+");
        btn.setMinWidth(100);
        final Button btn2 = new Button();
        btn2.setText("-");
        btn2.setMinWidth(100);

        btn.setOnMouseClicked(event -> {
            counter.increment();
        });
        btn2.setOnMouseClicked(event -> {
            counter.decrement();
        });
        
        final HBox root = new HBox();
        root.getChildren().add(btn);
        root.getChildren().add(btn2);
        root.getChildren().add(lbl);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
} //finito e funziona. comando per eseguirlo da terminale: ./gradlew :javafx-1-property:run
