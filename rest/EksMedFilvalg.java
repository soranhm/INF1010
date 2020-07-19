import javafx.application.Application; // Klassen alle JavaFX-applikasjoner utvider fra
import javafx.event.ActionEvent; // Se javafx.event.Event for andre typer events
import javafx.event.EventHandler; // Tilsvarer ActionListener i swing
import javafx.scene.input.MouseEvent; // For hendelser ifm musa
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
import javafx.stage.FileChooser; // Dialogboks for å velge filer
import java.io.File;
import java.util.Optional;
import javafx.scene.control.Alert.AlertType;

// Oppsummerende eksempel for forelesningen 4. mai 2017

public class EksMedFilvalg extends Application {

    @Override
    public void start(Stage vindu) throws Exception {

	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Dialog for å bekrefte ...");
	alert.setHeaderText("Dette er en dialogboks av type AlertType.CONFIRMATION");
	alert.setContentText("Er vi klare for siste eksempel?");
	Optional<ButtonType> svar = alert.showAndWait();

	if (svar.get() == ButtonType.OK) {
	    System.out.println("Brukeren svarte ved å trykke på OK-knappen");
	    BorderPane border = new BorderPane();

	    HBox hbox = nyHBox(vindu);
	    border.setTop(hbox);
	    border.setLeft(vBoxMedTekst());
	    border.setCenter(minGridPane()); // GridPane
	    border.setRight(nyVBoxMedLenker()); // VBox
	    border.setBottom(bunnBoks()); // HBox
	    Scene scene = new Scene(border, 1230, 800);
	    vindu.setScene(scene);
	    vindu.show();
	    vindu.setTitle("Siste GUI-eksempel med dialogbokser og filvalg");

	} else {
	    System.out.println("Brukeren lukka vinduet eller trykka på CANCEL-knappen");
	    BorderPane border = new BorderPane();
	    Image slutt  = new Image("file:grafikk/slutt.jpg", 1920, 1080, false, false);
	    ImageView iv = new ImageView();
	    iv.setImage(slutt);
	    BorderPane bildepanel = new BorderPane();
	    bildepanel.setCenter(iv);
	    border.setCenter(bildepanel);
	    Scene scene = new Scene(border, 1920, 1080);
	    vindu.setScene(scene);
	    vindu.show();
	    vindu.setTitle("Takk for i dag !");

	}
    }

    private HBox nyHBox(Stage vindu) {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Avstand mellom nodene
        hbox.setStyle("-fx-background-color: #221199;");

        Button knapp1 = new Button("Forelest");
        knapp1.setPrefSize(100, 20);

        Button knapp2 = new Button("Gjenstaar");
        knapp2.setPrefSize(100, 20);

        Button knapp3 = new Button("Trykk her for å velge fil");
        knapp3.setPrefSize(230, 20);
	knapp3.setStyle("-fx-background-color: yellow;");

	knapp3.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) {
		    FileChooser fileChooser = new FileChooser();
		    /*		    FileChooser.ExtensionFilter extFilter =
			new FileChooser.ExtensionFilter("Javafiler (*.java)", "*.java");
			fileChooser.getExtensionFilters().add(extFilter); */
		    File file = fileChooser.showOpenDialog(vindu);
		    System.out.println(file);
		}
	    });

        Button knapp4 = new Button("En lyttende knapp");
        knapp4.setPrefSize(150, 20);

        EventHandler<ActionEvent> minLytter = new KnappeLytter(knapp4.getText()) ;
        knapp4.setOnAction(minLytter);

        hbox.getChildren().addAll(knapp1, knapp2, knapp3, knapp4);

        return hbox;
    }

    class KnappeLytter implements EventHandler<ActionEvent> {
        String knappeTekst = null;

        KnappeLytter (String s) {
            knappeTekst = s;
        }

        @Override
        public void handle(ActionEvent detJegVentaPaaHendte) {
            System.out.println("Det ble trykka på knappen med teksten «" + knappeTekst + "»");
	    System.out.println(detJegVentaPaaHendte.toString());
        }
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
            new Hyperlink("Parallellprogrammering (tråder)"),
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

	t = new Text("\n\nLæringskravet i INF1010 er ikke først og fremst\n"+
                         "å kunne et pensum, men å kunne lage programmer\n"+
		         "(rimelig raskt) ved å bruke programmeringsteknikker\nsom er forelest og som innøves i de forskjellige\nstudieaktivitetene. Det er viktig å vite at man\nikke kan lese seg til å nå dette målet. De fleste\ntemaer finnes i læreboka fra INF1000."
		     );
	t.setFont(Font.font("Roman", FontWeight.LIGHT, 10));
	vbox.getChildren().add(t);

        return vbox;
    }


    private GridPane minGridPane() {

          String[][] tekstArray = {  {" ", "4", "2", "3"},
                                     {" ", "2", "1", "4"},
                                     {"4", " ", " ", " "},
                                     {"3", "1", "4", " "}
                                  };

          GridPane rutepanel = new GridPane();
          Text tekst = null;

          for (int i= 0; i < tekstArray.length; i++) {
              for (int j = 0; j < tekstArray[i].length; j++) {
                  StackPane s = new StackPane();
                  s.setAlignment(Pos.CENTER);
                  // Alternativ 1: CSS-border. Dette har prioritet, derfor vil man faa en
                  // grønn border selv om setBorder kjorer etterpa.
                  s.setStyle("-fx-border-width: 4px; -fx-border-style: solid; -fx-border-color: red;");
                  // Alternativ 2: Kanskje enklere aa skjoenne til aa begynne med ?

                  s.setBorder(new Border(new BorderStroke(Color.GRAY,
                                                          BorderStrokeStyle.SOLID,
                                                          CornerRadii.EMPTY,
                                                          new BorderWidths(1))));

                  tekst  = new Text(tekstArray[i][j]);
                  tekst.setFont(Font.font("Arial", FontWeight.BOLD, 80));
		  tekst.setOnMousePressed( new SkiftTekst(tekst) );

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
          BorderPane panelMedFugl = new BorderPane();
          panelMedFugl.setCenter(bFugl);

          ImageView sFjes = new ImageView(
                    new Image(MinGUIApp.class.getResourceAsStream("grafikk/smilefjes.png")));
          BorderPane panelMedSmil = new BorderPane();
          panelMedSmil.setCenter(sFjes);
          rutepanel.add(panelMedFugl, 2, 2);
          rutepanel.add(panelMedSmil, 3, 3);

          BorderPane panelMedKnapp = new BorderPane();
          Button knapp = new Button("B Y T T");
          knapp.setPrefSize(100, 100);
          EventHandler<ActionEvent> lyttEtterTrykk = new ByttSmilOgFugl(rutepanel, panelMedSmil, panelMedFugl) ;
          knapp.setOnAction(lyttEtterTrykk);
          panelMedKnapp.setCenter(knapp);
          rutepanel.add(panelMedKnapp, 2, 3);

          return rutepanel;
    }

    class SkiftTekst implements EventHandler<MouseEvent> {
	Text tekst;

        SkiftTekst(Text t) {tekst = t;}
	@Override
	public void handle(MouseEvent me) {
		System.out.println("Klikk i " + me.getSceneX());
		System.out.println( tekst.toString() );
		System.out.println( me.toString() );
		String nyTekst = null;
		if (tekst.getText().equals(" ")) nyTekst = "0";
		else if (tekst.getText().equals("9")) nyTekst = " ";
		else {
		    Integer i = Integer.parseInt( tekst.getText() ) + 1 ;
		    nyTekst = new String(i.toString());
		}
		tekst.setText(nyTekst);
	}
    }

    class ByttSmilOgFugl implements EventHandler<ActionEvent> {

        GridPane rutepanel = null;
        BorderPane panelMedSmil= null, panelMedFugl = null;
        boolean opprinneligPlassering = true;

        ByttSmilOgFugl (GridPane gp, BorderPane bps, BorderPane bpf) {
            rutepanel = gp;
            panelMedSmil = bps;
            panelMedFugl = bpf;
        }

        @Override
        public void handle(ActionEvent ae) {
            System.out.println("Det ble trykka knappen [4,3] i rutepanelet");
                rutepanel.getChildren().remove(panelMedSmil);
                rutepanel.getChildren().remove(panelMedFugl);
            if (opprinneligPlassering) {
                rutepanel.add(panelMedFugl, 3, 3);
                rutepanel.add(panelMedSmil, 2, 2);
            }
            else {
                rutepanel.add(panelMedFugl, 2, 2);
                rutepanel.add(panelMedSmil, 3, 3);
            }
            opprinneligPlassering = ! opprinneligPlassering;

        }
    }

    private HBox bunnBoks() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(50);   // Avstand mellom nodene
        hbox.setStyle("-fx-background-color: #007700;");

        TextField tekstfelt = new TextField("Skriv noe i dette feltet ...");
        tekstfelt.setPrefSize(300, 30) ; // javafx.scene.control

	Button leverTekst  = new Button("Trykk for å lese inn teksten");
        leverTekst.setPrefSize(200, 30);
        leverTekst.setOnAction(new EventHandler<ActionEvent>() {
		        @Override
			public void handle(ActionEvent knapptrykka) {
			    String s = tekstfelt.getText();
			    tekstfelt.clear();
			    System.out.println("Teksten som ble skrevet inn var «" + s + "»");
			}
	    }
	);


	Button avslutt  = new Button("Lukk vinduet og avslutt programmet");
        avslutt.setPrefSize(200, 30);
        avslutt.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent avsluttknapptrykka) {
				    javafx.application.Platform.exit();
				}
			    }
	);

	hbox.getChildren().addAll(tekstfelt, leverTekst, avslutt);
        return hbox;
    }

}
