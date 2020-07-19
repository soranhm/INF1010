import javafx.application.Application; // Klassen alle JavaFX-applikasjoner utvider fra
import javafx.event.ActionEvent; // Se javafx.event.Event for andre typer events
import javafx.event.EventHandler; // Tilsvarer ActionListener i swing
import javafx.scene.image.*; // for bilder av forskjellige formater png, jpg ...
import javafx.scene.Scene; // Beholderen for alt innholdet
import javafx.scene.text.Text; // En tekstnode
import javafx.scene.layout.*; // for panes, HBox, VBox andre layoutnoder
import javafx.scene.control.*; // for Button, Checkbox, Hyperlink og andre grensesnittkontroller
import javafx.geometry.*; // plassering, orientering o.l.
import javafx.stage.*; // Hoeyeste nivaa av JavaFX-beholdere
import javafx.scene.paint.Color;  // Definerer fargekonstanter
import javafx.scene.text.Font; // For fonter
import javafx.scene.text.FontWeight;  // For fonttype normal, bold, italic osv.

// Oppsummerende eksempel for forelesningen 7. april 2016

public class Oppsummering extends Application {

    @Override
    public void start(Stage vindu) throws Exception {

        BorderPane border = new BorderPane();
        HBox hbox = nyHBox();

        border.setTop(hbox);

        border.setLeft(vBoxMedTekst());

        border.setCenter(minGridPane());

	border.setRight(nyVBoxMedLenker());

        Scene scene = new Scene(border, 800, 600);
        vindu.setScene(scene);
        vindu.show();
        vindu.setTitle("Eksempel paa bruk av Border- og GridPane, HBox og Vbox");
    }

    public static void main(String[] a) {
        launch(a);
    }

    private HBox nyHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Avstand mellom nodene
        hbox.setStyle("-fx-background-color: #336699;");

        Button knapp1 = new Button("Forelest");
        knapp1.setPrefSize(100, 20);

        Button knapp2 = new Button("Gjenstaar");
        knapp2.setPrefSize(100, 20);

        Button knapp3 = new Button("Trixoppgaver");
        knapp3.setPrefSize(130, 20);

        Button knapp4 = new Button("Innleveringsoppgaver");
        knapp4.setPrefSize(200, 20);

        hbox.getChildren().addAll(knapp1, knapp2, knapp3, knapp4);

        return hbox;
    }

/*
 * Lager en boks med linker skrevet vertikalt/nedover
 * Tenkt brukt i en venstremarg
 */

    private VBox nyVBoxMedLenker() {

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(40, 50, 10, 10 )); // marger t, r, b, l
        vbox.setSpacing(8);              // Avstand mellom nodene (elementene)

        Text title = new Text("INF1010 temaer");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Datastruktur"),
            new Hyperlink("Subklasser"),
            new Hyperlink("Klasser med typeparametre"),
            new Hyperlink("Begrensende typeparametre"),
            new Hyperlink("Arv og subklasser"),
            new Hyperlink("Polymorfi"),
            new Hyperlink("Grensesnitt"),
            new Hyperlink("Parallellprogrammering (traader)"),
            new Hyperlink("GUI")
        };


        for (int i=0; i<9; i++) {
            // Add offset to left side to indent from title
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }

        return vbox;
    }


    private VBox vBoxMedTekst() {

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Setter alle sider til 10
        vbox.setSpacing(8);              // Avstand mellom nodene (elementene)

        Text title = new Text("Hva er JavaFX ?");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Text t = new Text("JavaFX is a software platform");
        vbox.getChildren().add(t);
        t = new Text("for creating and delivering desktop");
        vbox.getChildren().add(t);
        t = new Text("applications, as well as rich internet");
        vbox.getChildren().add(t);
        t = new Text("applications (RIAs) that can run");
        vbox.getChildren().add(t);
        t = new Text("across a wide variety of devices.");
        vbox.getChildren().add(t);
        t = new Text("JavaFX is intended to replace");
        vbox.getChildren().add(t);
        t = new Text("Swing as the standard GUI library");
        vbox.getChildren().add(t);
        t = new Text("for Java SE, but both will be included");
        vbox.getChildren().add(t);
        t = new Text("for the foreseeable future.");
        vbox.getChildren().add(t);

        return vbox;
    }


    private GridPane minGridPane() {

          String[][] tekstArray = {  {"a", "b", "s", "d"},
                                     {"1", "2", "-", "4"},
                                     {"A", "", "", "."},
                                     {"", "", "", ""}
                                  };

          GridPane rutepanel = new GridPane();
          Text tekst = null;

          for (int i= 0; i < tekstArray.length; i++) {
              for (int j = 0; j < tekstArray[i].length; j++) {
                  StackPane s = new StackPane();
                  s.setAlignment(Pos.CENTER);
                  // Alternativ 1: CSS-border. Dette har prioritet, derfor vil man faa en
                  // red border selv om setBorder kjorer etterpa.
		  s.setStyle("-fx-border-width: 2px; -fx-border-style: solid; -fx-border-color: red;");
                  // Alternativ 2: Kanskje enklere aa skjoenne til aa begynne med ?

                  s.setBorder(new Border(new BorderStroke(Color.GRAY,
                                                          BorderStrokeStyle.SOLID,
                                                          CornerRadii.EMPTY,
                                                          new BorderWidths(1))));

                  tekst  = new Text(tekstArray[i][j]);
                  tekst.setFont(Font.font("Arial", FontWeight.BOLD, 32));

                  s.getChildren().add(tekst);
                  rutepanel.add(s, j, i);
              }
          }

          for (int i = 0; i < tekstArray[0].length; i++) {
              ColumnConstraints column1 = new ColumnConstraints();
              column1.setPercentWidth(20);
              rutepanel.getColumnConstraints().add(column1);

              RowConstraints r1 = new RowConstraints();
              r1.setPercentHeight(20);
              rutepanel.getRowConstraints().add(r1);
          }

          // legger inn et bilde

          Image blaafugl = new Image("file:grafikk/fugl.jpg", 120, 120, false, false);
          ImageView bFugl = new ImageView();
          bFugl.setImage(blaafugl);

          ImageView sFjes = new ImageView(
                    new Image(Eks04.class.getResourceAsStream("grafikk/smilefjes.png")));
          rutepanel.add(bFugl, 2, 2);
          rutepanel.add(sFjes, 3, 3);

          return rutepanel;
    }


}
