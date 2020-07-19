import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import java.io.File;
import java.util.ArrayList;

public class Tall extends Application {
    Stage vindu;
    VBox rot;

    @Override
    public void start(Stage vindu) {
        this.vindu = vindu;

        HBox toppboks = lagToppBoks();
        rot = new VBox(toppboks);
        Scene scene = new Scene(rot);
        vindu.setScene(scene);
        vindu.setTitle("Talleksempel");
        vindu.show();
    }

    private HBox lagToppBoks() {
        TextField filFelt = new TextField();

        Button velgFilKnapp = new Button("Velg fil...");
        velgFilKnapp.setOnAction(new FilVelger(filFelt));

        Button lastInnKnapp = new Button("Last inn");
        lastInnKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<Integer> tall = FilLeser.lesFil(filFelt.getText());
                FlowPane beholder = new FlowPane();
                for(int i : tall) {
                    Label tekst = new Label(""+i);
                    tekst.setPadding(new Insets(10));
                    beholder.getChildren().add(tekst);
                }
                rot.getChildren().add(beholder);
                vindu.sizeToScene();
            }
        });

        HBox returBoks = new HBox(50, velgFilKnapp, filFelt, lastInnKnapp);
        return returBoks;
    }

    private class FilVelger implements EventHandler<ActionEvent> {
        TextField filFelt;
        public FilVelger(TextField filFelt) {
            this.filFelt = filFelt;
        }
        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Velg tallfil");
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null) {
                filFelt.setText(selectedFile.getPath());
                //System.out.println(selectedFile.getPath());
            }
        }
    }
}