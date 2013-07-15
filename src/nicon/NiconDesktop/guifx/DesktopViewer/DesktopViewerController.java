/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx.DesktopViewer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import nicon.NiconDesktop.core.coreAppWindow;
import nicon.NiconDesktop.core.coreFiles;
import nicon.NiconDesktop.guifx.Plugins.PluginsController;
import nicon.NiconDesktop.main;
import nicon.NiconDesktop.object.PluginActives;


/**
 * FXML Controller class
 *
 * @author Dony
 */
public class DesktopViewerController implements Initializable {
private Button FullScreen;
private static ImageView wall = new ImageView();
private static String BGRuta;
private static Image BGImage;
private static coreFiles Loader = new coreFiles();
private static boolean Barra;
private static Parent Plugin;

@FXML
private AnchorPane primary;

@FXML
private static AnchorPane desktop;

@FXML 
private AnchorPane plugin;

@FXML
private AnchorPane clockzone;

@FXML
private AnchorPane clock;

@FXML
private static HBox BarPane;



@FXML
private Button NavigatorIcon;
@FXML
private Button ImageFXIcon;


@FXML
private MenuBar DashBar = new MenuBar();

    
@FXML
private void ActionPluginEntred(MouseEvent event){
Plugin.setVisible(true);
}

@FXML
private void ActionPluginEsited(MouseEvent event){
if (Barra == true){
Plugin.setVisible(true);
}else{
Plugin.setVisible(false);}
}
    
    
    @FXML
    private void ActionSesiondown(ActionEvent event){
        try {
            nicon.NiconDesktop.main.CloseSesion();
        } catch (Exception ex) {
            Logger.getLogger(DesktopViewerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void ActionShutdown(ActionEvent event){
    System.exit(0);
    }
    
    
    @FXML
    private void OpenNiconNavigator(){
    try {
        Parent Navigator;
        Navigator = FXMLLoader.load(nicon.NiconDesktop.guifx.NiconNavigator.NavegadorController.class.getResource("Navegador.fxml"));
        addApp("NiconNavigator", Navigator);
    } catch (IOException ex) {
        Logger.getLogger(DesktopViewerController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    public static void OpenSearcher(){
    try {
        Parent Navigator;
        Navigator = FXMLLoader.load(nicon.NiconDesktop.guifx.NiconNavigator.NavegadorController.class.getResource("Navegador.fxml"));
        addStaticApp("NiconNavigator", Navigator);
    } catch (IOException ex) {
        Logger.getLogger(DesktopViewerController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    
    @FXML
    private void OpenWallControler(){
    try {
        Parent Waller;
        Waller = FXMLLoader.load(nicon.NiconDesktop.guifx.Wall.WallController.class.getResource("wall.fxml"));
        addApp("Fondo de Pantalla", Waller);
    } catch (IOException ex) {
        Logger.getLogger(DesktopViewerController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    @FXML
    private void OpenNiconImage(){
    try {
        Parent NiconImage;
        NiconImage = FXMLLoader.load(nicon.NiconDesktop.guifx.NiconImage.NiconImageFXMLController.class.getResource("NiconImageFXML.fxml"));
        addApp("NiconImageFX Experimental", NiconImage);
    } catch (IOException ex) {
        Logger.getLogger(DesktopViewerController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
  @FXML
  private void showClock(){
  final ComboBox lista = new ComboBox();  
  lista.getItems().clear();
  lista.setPrefSize(250, 25);
  
  AnchorPane.setTopAnchor(lista, 25.0);
  AnchorPane.setLeftAnchor(lista, 10.0);
  AnchorPane.setRightAnchor(lista, 10.0);
  lista.getItems().add("Lista de Zonas Horarias");
  String[] zonas = TimeZone.getAvailableIDs();
  int zero = 0;
  while(zero < zonas.length){
  String zona = zonas[zero];
  lista.getItems().add(zona);
  zero++;
  }
  lista.setVisibleRowCount(30);
  lista.setVisible(true);
  lista.setValue("Lista de Zonas Horarias");
  lista.setCursor(Cursor.HAND);
  Button Aplicar = new Button();
  Button Cancelar = new Button();
  Aplicar.setPrefSize(100, 25);
  Cancelar.setPrefSize(100, 25);
  Aplicar.setText("Aplicar"); 
  Cancelar.setText("Cancelar");
  Aplicar.setCursor(Cursor.HAND);
  Cancelar.setCursor(Cursor.HAND);
  Aplicar.setOnMouseClicked(new EventHandler<MouseEvent>() {
    
        @Override 
    public void handle(MouseEvent evnt){
            
    String zone = (String) lista.getSelectionModel().getSelectedItem();
    
    if ("Lista de Zonas Horarias".equals(zone)){}else{
    nicon.NiconDesktop.clock.NiconClockController.setzone(zone);
    shutdownClock();}
    }
    });

  Cancelar.setOnMouseClicked(new EventHandler<MouseEvent>() {
    
        @Override 
    public void handle(MouseEvent evnt){
    shutdownClock();
   
        }
    });
  
  Aplicar.setVisible(true);
  Cancelar.setVisible(true);
  AnchorPane.setLeftAnchor(Aplicar, 10.0);
  AnchorPane.setBottomAnchor(Aplicar, 25.0);
  AnchorPane.setRightAnchor(Cancelar, 10.0);
  AnchorPane.setBottomAnchor(Cancelar, 25.0);
  
  
  clock.getChildren().add(lista);
  clock.getChildren().add(Aplicar);
  clock.getChildren().add(Cancelar);
    clock.setVisible(true);
    clock.toFront();
   
    
    
    
    }
  
  private void shutdownClock(){
  clock.getChildren().clear();
  clock.setVisible(false);
  
  }
  
  /**
   * Método que crea la zona de reloj
   */
  
  private void iniRelojZone(){
    AnchorPane.setBottomAnchor(nicon.NiconDesktop.main.clock, 0.0);
    AnchorPane.setRightAnchor(nicon.NiconDesktop.main.clock, 0.0);
    clockzone.getChildren().add(nicon.NiconDesktop.main.clock);
    nicon.NiconDesktop.main.clock.setVisible(true);
    clockzone.setCursor(Cursor.HAND);
    clock = new AnchorPane();
    AnchorPane.setRightAnchor(clock, 0.0);
    AnchorPane.setBottomAnchor(clock, 0.0);
    desktop.getChildren().add(clock);
    clock.setStyle("-fx-background-color:linear-gradient(#000000, #FF7700);");
    clock.setPrefSize(300, 150);
    clock.setMinSize(300, 150);
    clock.setMaxSize(300, 150);
    clock.setVisible(false);
    
   
  }
  
  /**
   * Método que Inicializa el control de Pantalla Completa
   */
  private void iniFullScreenButton(){
  FullScreen = new Button();
  FullScreen.getStyleClass().add("FullScreen");    
  FullScreen.setMaxSize(50, 50);
  FullScreen.setMinSize(50, 50);
  FullScreen.setPrefSize(50, 50);
  FullScreen.setCursor(Cursor.HAND);
  
   Tooltip tooltip1 = new Tooltip();
   tooltip1.setText("Pasar a Panatalla Completa");
   FullScreen.setTooltip(tooltip1);
    
  AnchorPane.setRightAnchor(FullScreen, 5.0);
  AnchorPane.setTopAnchor(FullScreen, 5.0);
  
  desktop.getChildren().add(FullScreen);
  FullScreen.setOnMouseClicked(new EventHandler<MouseEvent>() {
    
        @Override 
    public void handle(MouseEvent evnt){
    if (nicon.NiconDesktop.main.stageDesktop.isFullScreen()==false){
    nicon.NiconDesktop.main.stageDesktop.setFullScreen(true);}
    }
    });
  
  nicon.NiconDesktop.main.stageDesktop.fullScreenProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
              System.out.println("viejo ="+ oldValue+"nuevo = "+newValue);
              if (newValue == false){
              FullScreen.setVisible(true);
              nicon.NiconDesktop.main.stageDesktop.setWidth(800);
              nicon.NiconDesktop.main.stageDesktop.setHeight(600);
              FullScreen.toFront();
              }
              if (newValue == true){
              FullScreen.setVisible(false);
              
              }
              
            }
        });  
  }
    
private void iniBackground(){
AnchorPane.setTopAnchor(wall, 0.0);
AnchorPane.setLeftAnchor(wall, 0.0);
AnchorPane.setRightAnchor(wall, 0.0);
AnchorPane.setBottomAnchor(wall, 0.0);
wall.setVisible(true);

wall.toBack();
System.out.println(BGRuta);

if ("".equals(BGRuta)){
BGRuta = nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/NiconSystemWall1.png").toString();
}

Image img= new Image(BGRuta,0,desktop.getHeight(), false, false);

wall.setImage(img);
wall.setCache(false);
wall.setSmooth(true);
desktop.getChildren().add(wall);

//Objetos a enviar encima del fondo:
NavigatorIcon.toFront();
ImageFXIcon.toFront();
plugin.toFront();

     

            
            
       desktop.widthProperty().addListener(new ChangeListener<Number>() {
       @Override
       public void changed(ObservableValue<? extends Number> ov, Number oldv, Number newv)
       {
       
       Image img= new Image(BGRuta,
               desktop.getWidth(),desktop.getHeight(), false, false);
       wall.setImage(img);
           
          

       }});
       desktop.heightProperty().addListener(new ChangeListener<Number>() {
       @Override
       public void changed(ObservableValue<? extends Number> ov, Number oldv, Number newv)
       {
       Image img= new Image(BGRuta,
               desktop.getWidth(),desktop.getHeight(), false, false);
       wall.setImage(img);    
           
       }});

        


}    
  
private void IniPlugin(){
    try {
       
    Plugin = FXMLLoader.load(PluginsController.class.getResource("Plugins.fxml"));
    
    AnchorPane.setTopAnchor(Plugin, 0.0);
    AnchorPane.setBottomAnchor(Plugin, 0.0);
    AnchorPane.setLeftAnchor(Plugin, 0.0);
    AnchorPane.setRightAnchor(Plugin, 0.0);
    
    plugin.getChildren().add(Plugin);
    try {
    PluginActives Actives = (PluginActives) Loader.Load(main.ConfigPluginActives);
    
    Plugin.setVisible(Actives.getVisible());
    Barra = Actives.getVisible();
    }catch(Exception e){
    Plugin.setVisible(false);
    }
    plugin.setVisible(true);
    
    } catch (IOException ex) {
        Logger.getLogger(DesktopViewerController.class.getName()).log(Level.SEVERE, null, ex);
    }
}


public static void setBGRuta(String ruta){
BGRuta = ruta;
Loader.Save(nicon.NiconDesktop.main.ConfigBGRuta,ruta);
BGImage= new Image(BGRuta,desktop.getWidth(),desktop.getHeight(), false, false);
wall.setImage(BGImage); 


}

public static void setBarra(boolean bar){
Barra = bar;
Plugin.setVisible(Barra);
}


  
  private void addApp(String Name, Parent App){
      
  final coreAppWindow app = new coreAppWindow(Name, App);
  final Parent gate = app.getGate();
  final Button dash = new Button();
  dash.setText(Name);
 
  dash.setStyle(
            
           "-fx-text-fill: #ffffff;"
          
          
          );
  dash.setVisible(true);
  BarPane.setAlignment(Pos.CENTER_LEFT);
  BarPane.getChildren().add(dash);
  
  dash.setOnAction(new EventHandler<ActionEvent>() {
  @Override 
    public void handle(ActionEvent evnt){
      app.setActive();
      gate.toFront();
 
    }});//Fin de set OnAction
  
  AnchorPane.setTopAnchor(gate, 0.0);
  AnchorPane.setBottomAnchor(gate, 0.0);
  AnchorPane.setLeftAnchor(gate, 0.0);
  AnchorPane.setRightAnchor(gate, 0.0);
  desktop.getChildren().add(gate);
  
  
          
          
  gate.toFront();
  
  app.getClose().setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override 
    public void handle(MouseEvent evnt){
    BarPane.getChildren().remove(dash);
    desktop.getChildren().remove(gate);
    
    }});//Fin de set On MouseClicked
  
  }
  
  private static void addStaticApp(String Name, Parent App){
      
  final coreAppWindow app = new coreAppWindow(Name, App);
  final Parent gate = app.getGate();
  final Button dash = new Button();
  dash.setText(Name);
 
  dash.setStyle(
            
           "-fx-text-fill: #ffffff;"
          
          
          );
  dash.setVisible(true);
  BarPane.setAlignment(Pos.CENTER_LEFT);
  BarPane.getChildren().add(dash);
  
  dash.setOnAction(new EventHandler<ActionEvent>() {
  @Override 
    public void handle(ActionEvent evnt){
      app.setActive();
      gate.toFront();
 
    }});//Fin de set OnAction
  
  AnchorPane.setTopAnchor(gate, 0.0);
  AnchorPane.setBottomAnchor(gate, 0.0);
  AnchorPane.setLeftAnchor(gate, 0.0);
  AnchorPane.setRightAnchor(gate, 0.0);
  desktop.getChildren().add(gate);
  
  
          
          
  gate.toFront();
  
  app.getClose().setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override 
    public void handle(MouseEvent evnt){
    BarPane.getChildren().remove(dash);
    desktop.getChildren().remove(gate);
    
    }});//Fin de set On MouseClicked
  
  }
  
  
  
  
  
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    //Inicializando Reloj
    this.iniRelojZone();
  
    //Codigos control de FullScreen
    this.iniFullScreenButton();
    
    //Precargando Imagen de Fondo
    try{
    BGRuta = (String) Loader.Load(nicon.NiconDesktop.main.ConfigBGRuta);
    if (BGRuta.contains("/nicon")==true){
    int a = BGRuta.lastIndexOf("/nicon");
    BGRuta = BGRuta.substring(a, BGRuta.length());}
    
    }catch(Exception e){
        System.out.println("se produce error al cargar fondo");
    BGRuta = "";
    }        
    
    //Inicializando Fondo de Pantalla;
    this.iniBackground();
    setBGRuta(BGRuta);
    
    //Inicializando Barra Lateral
    IniPlugin();

    
    }    
}
