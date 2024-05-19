package scene.practicafinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import paqueteClases.Juego;

public class PrimaryController {

    @FXML
    private Button atacar;
    @FXML
    private Button este;

    @FXML
    private Button iniciar;

    @FXML
    private Button luz;

    @FXML
    private TextArea mostrar;

    @FXML
    private Button norte;

    @FXML
    private Button oeste;

    @FXML
    private Button salir;

    @FXML
    private Button volver;

    @FXML
    private Button sur;

    @FXML
    private Button iniciarAutomatico;

    public Juego j;
    public static boolean salida;

    @FXML
    void iniciarJuego(ActionEvent event) {
        j = new Juego();
        salida = false;
        volver.setDisable(true);
        sur.setDisable(false);
        norte.setDisable(false);
        este.setDisable(false);
        oeste.setDisable(false);
        atacar.setDisable(false);
        luz.setDisable(false);
        iniciar.setDisable(true);
        iniciarAutomatico.setDisable(true);
        mostrar.appendText(j.bienvenido() + "\n");
        mostrar.appendText(j.habitaciono() + "\n");
    }

    @FXML
    void iniciarJuegoAutomatico(ActionEvent event) {
        j = new Juego();
        iniciar.setDisable(true);
        iniciarAutomatico.setDisable(true);
        mostrar.appendText(j.bienvenido() + "\n");
        BufferedReader br = null;
        File f = new File("./recorrido.txt");
        try {
            br = new BufferedReader(new FileReader(f));
            String aux;
            while ((aux = br.readLine()) != null) {
                mostrar.appendText(j.juego(aux));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        if (j.isTerminar()) {
            sal();
        }
    }

    @FXML
    void irEste(ActionEvent event
    ) {
        mostrar.appendText(j.irA(este.getText()) + "\n");
        if (j.isTerminar()) {
            sal();
        }
    }

    @FXML
    void irNorte(ActionEvent event
    ) {
        mostrar.appendText(j.irA(norte.getText()) + "\n");
        if (j.isTerminar()) {
            sal();
        }
    }

    @FXML
    void irOeste(ActionEvent event
    ) {
        mostrar.appendText(j.irA(oeste.getText()) + "\n");
        if (j.isTerminar()) {
            sal();
        }
    }

    @FXML
    void irSur(ActionEvent event
    ) {
        mostrar.appendText(j.irA(sur.getText()) + "\n");
        if (j.isTerminar()) {
            sal();
        }
    }

    @FXML
    void salir(ActionEvent event
    ) {
        System.exit(0);
    }

    @FXML
    void atacar(ActionEvent event
    ) {
        mostrar.appendText(j.atacar() + "\n");
    }

    @FXML
    void iluminar(ActionEvent event
    ) {
        mostrar.appendText(j.luz() + "\n");
    }

    @FXML
    void volveraJugar(ActionEvent event) {
        mostrar.clear();
       iniciar.setDisable(false);
       iniciarAutomatico.setDisable(false);
       volver.setDisable(true);
    }

    private void sal() {
        mostrar.appendText("\nEl Juego Termino. GANASTE");
        sur.setDisable(true);
        norte.setDisable(true);
        este.setDisable(true);
        oeste.setDisable(true);
        atacar.setDisable(true);
        luz.setDisable(true);
        volver.setDisable(false);
        j = null;
    }
}
