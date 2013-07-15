/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx.Plugins.Reloj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dony
 */
public class RelojController implements Initializable {
private static ImageView Hora;
private static ImageView Min;
private static ImageView Sec;
private static double hourAngle;
private static double minAngle;
private static double secAngle;
private ImageView back;
@FXML
private static Label tiempo;
@FXML
private AnchorPane primary;
@FXML
private AnchorPane secundary;



public static void setHour(int hora, int minuto, int segundo,String time){

    double horas = (hora*30)-90+(minuto/2);
    double minutos = (minuto*6)-90;
    double segundos = (segundo*6)-90;

Hora.setRotate(horas);
Min.setRotate(minutos);
Sec.setRotate(segundos);

tiempo.setText(time);
tiempo.toFront();
}
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    back = new ImageView();       
    AnchorPane.setBottomAnchor(back, 5.0);
    AnchorPane.setLeftAnchor(back, 5.0);
    AnchorPane.setRightAnchor(back, 5.0);
    AnchorPane.setTopAnchor(back, 5.0);
    back.setVisible(true);
    secundary.getChildren().add(back);    
    
    String NiconReloj = nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/NiconReloj.png").toString();
    Image img= new Image(NiconReloj,230,230, false, false);
    
    back.setImage(img);
    
    Hora = new ImageView();
    Min= new ImageView();
    Sec = new ImageView();
    
    
    
    
    //Definiendo Aguja de Minutos
    AnchorPane.setBottomAnchor(Min, 5.0);
    AnchorPane.setLeftAnchor(Min, 5.0);
    AnchorPane.setRightAnchor(Min, 5.0);
    AnchorPane.setTopAnchor(Min, 5.0);
    Min.setVisible(true);
    Min.setStyle("-fx-background-color:rgba(0,0,0,0)");
    
    secundary.getChildren().add(Min);
    String RelojMin = nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/NiconAgujaMin.png").toString();
    Image agujaMin= new Image(RelojMin,230,230, false, false);
    
    Min.setImage(agujaMin);
    
    //Definiendo Aguja de Hora
    AnchorPane.setBottomAnchor(Hora, 5.0);
    AnchorPane.setLeftAnchor(Hora, 5.0);
    AnchorPane.setRightAnchor(Hora, 5.0);
    AnchorPane.setTopAnchor(Hora, 5.0);
    Hora.setVisible(true);
    Hora.setStyle("-fx-background-color:rgba(0,0,0,0)");
   
    secundary.getChildren().add(Hora);
    String RelojHora = nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/NiconAgujaHora.png").toString();
    Image agujahora= new Image(RelojHora,230,230, false, false);
    
    Hora.setImage(agujahora);
    
    //Definiendo Aguja de Segundos
    AnchorPane.setBottomAnchor(Sec, 5.0);
    AnchorPane.setLeftAnchor(Sec, 5.0);
    AnchorPane.setRightAnchor(Sec, 5.0);
    AnchorPane.setTopAnchor(Sec, 5.0);
    Sec.setVisible(true);
    Sec.setStyle("-fx-background-color:rgba(0,0,0,0)");
    
    secundary.getChildren().add(Sec);
    String RelojSec = nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/NiconAgujaSec.png").toString();
    Image agujaSec= new Image(RelojSec,230,230, false, false);
    
    Sec.setImage(agujaSec);
    
    
    //Configurando reloj digital
    
    
    }    
}
