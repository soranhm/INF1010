import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;



public class Plenum extends Application{
  @Override
  public void start(Stage primaryStage){
    TextField brukernavn = new TextField();
    TextField passord = new TextField();
    Button logginn = new Button("Logg inn");
    logginn.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent e){
        System.out.println("Brukernavn: " + brukernavn.getText());
        System.out.println("Passords: " + passord.getText());
        }
      });

    VBox root = new VBox(brukernavn,passord,logginn);

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
