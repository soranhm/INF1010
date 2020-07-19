import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Oblig7 extends Application{
    Stage vindu;
    GridPane rutenett;
    Rektangel[][] rek;
    int r;
    List<Rute> farge = null;
    Labyrint l;
    String storrelse = null;
    BorderPane rot;
    String antall = null;

    public void start(Stage vindu) {
        this.vindu = vindu;
        rot = new BorderPane();
        rutenett = new GridPane();
        rot.setTop(lagToppBoks());
        rot.setBottom(bunnTekst(antall));
        rot.setCenter(rutenett);
        vindu.setScene(new Scene(rot));
        vindu.setTitle("Labyrint");
        vindu.show();
    }
    public HBox lagToppBoks() { // lager topp delen
        TextField filFelt = new TextField();
        Button velgFil = new Button("Velg fil...");
        velgFil.setOnAction(new FilVelger(filFelt));
        Button lastInn = new Button("Last inn");
        lastInn.setOnAction(new EventHandler<ActionEvent>() {// sier hva lastInn skal gjore
            @Override
            public void handle(ActionEvent event) {
                l = FilLeser.lesFil(filFelt.getText());  // velger filen
                farge = new ArrayList<Rute>();          // lager egen array for farger
                rek = new Rektangel[l.kol][l.rad];      // lager Rektangel lengden

                for(Rute[] r: l.rute){
                    for(Rute ru : r){
                        farge.add(ru);
                    }
                }
                int teller = 0;
                for(int rad = 0; rad < l.rad; rad++) {
                    for(int kol = 0; kol < l.kol; kol++) {

                        rek[kol][rad] = new Rektangel(farge.get(teller), kol, rad); //lager rektangeler for hver rute
                        teller++;
                        rutenett.add(rek[kol][rad], kol, rad);
                    }
                }
                vindu.sizeToScene();
            }
        });

        HBox returBoks = new HBox(50, velgFil, filFelt, lastInn);
        return returBoks;
    }

    public HBox bunnTekst(String ant) {
        TextField flow = new TextField();
        Label label = new Label("antall utveier: " + ant);

        HBox h = new HBox(label);
        return h;

    }

    private class FilVelger implements EventHandler<ActionEvent> {
        TextField filFelt;
        public FilVelger(TextField filFelt) {
            this.filFelt = filFelt;
        }
        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Velg Labyrintfil");
            File selectedFile = fileChooser.showOpenDialog(null);
            if(selectedFile != null) {
                filFelt.setText(selectedFile.getPath());
            }
        }
    }

    static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
        boolean[][] losning = new boolean[hoyde][bredde];
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
        java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
        while(m.find()) {
            int x = Integer.parseInt(m.group(1))-1;
            int y = Integer.parseInt(m.group(2))-1;
            losning[y][x] = true;
        }
        return losning;
    }

    public class Rektangel extends Rectangle{
        Rute farger;
        int kol;
        int rad;
        boolean[][] sant;
        boolean erHvit = true;

        public Rektangel(Rute farger, int kol, int rad){
            this.farger = farger;
            this.kol = kol;
            this.rad = rad;
            setWidth(20);
            setHeight(20);
            setStroke(Color.WHITE);

            oppdaterFarge();

            addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    Liste<String> utveier = l.finnUtveiFra((kol+1), (rad+1));
                    storrelse = (""+utveier.storrelse());
                    System.out.println("Antall utveier: " + utveier.storrelse());
                    System.out.println((kol+1) +" "+ (rad+1));
                    oppdaterFarge();
                    if (!utveier.erTom()) {
                        sant = losningStringTilTabell(utveier.fjern(), l.kol, l.rad);
                        for(int i = 0; i < l.rad; i ++){
                            for(int j = 0; j < l.kol ; j++){
                                if(sant[i][j]) {
                                    rek[j][i].setFill(Color.GREEN); // setter utvien gronn
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Ingen utveier.");
                    }
                    rot.setBottom(bunnTekst(storrelse));
                }
            });
        }

        public void oppdaterFarge() {
            if(farger instanceof SortRute) {
                setFill(Color.BLACK);
            }
            else{
                setFill(Color.WHITE);
            }
            for(int i = 0; i < l.rad; i++) {
                for(int j = 0; j < l.kol; j++) {
                    if(rek[j][i] == null) return;
                    if(rek[j][i].getFill() == Color.GREEN) {
                        rek[j][i].setFill(Color.WHITE);
                    }
                }
            }
        }
    }


}
