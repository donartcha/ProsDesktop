/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx.Plugins;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import nicon.NiconDesktop.core.coreFiles;
import nicon.NiconDesktop.guifx.DesktopViewer.DesktopViewerController;
import nicon.NiconDesktop.guifx.Plugins.Buscador.BuscadorController;
import nicon.NiconDesktop.guifx.Plugins.Reloj.RelojController;
import nicon.NiconDesktop.main;
import nicon.NiconDesktop.object.PluginActives;
import nicon.NiconDesktop.object.PluginColor;

/**
 * FXML Controller class
 *
 * @author Dony
 */
public class PluginsController implements Initializable {
private coreFiles Loader = new coreFiles();    
private Parent BuscadorPlugin;
private Parent RelojPlugin;
private PluginActives Active;
    
@FXML
private AnchorPane primary;

@FXML
private AnchorPane secundary;

@FXML
private AnchorPane config;

@FXML
private Button configurar;

@FXML
private Button aceptar;

@FXML
private Button AceptarPlugins;

@FXML
private Button cancelar;

@FXML
private Slider Opacidad;

@FXML
private ColorPicker Color;

@FXML
private CheckBox Buscador;

@FXML
private CheckBox Barra;

@FXML
private CheckBox RelojCheck;

@FXML
private void Action1(ActionEvent event){
config.setVisible(true); 


BuscadorPlugin.setVisible(false);
RelojPlugin.setVisible(false);

}

@FXML
private void Action2(ActionEvent event){
Color c = this.Color.getValue();

int R = (int) (c.getRed()*255);
int G = (int) (c.getGreen()*255);
int B= (int) (c.getBlue()*255);
Double A = Opacidad.getValue();
  
PluginColor color = new PluginColor(R,G,B,A);
Loader.Save(main.ConfigPluginColor, color);

System.out.println("Color es: "+R+","+G+","+B+","+A);
secundary.setStyle(
        
       "-fx-background-radius: 8px 8px 8px 8px,  8px 8px 8px 8px,  8px 8px 8px 8px,  8px 8px 8px 8px;" 
       +"-fx-background-color: rgba(255,255,255,"+A+"),rgba("+R+","+G+","+B+","+A+");"
       +"-fx-background-insets: 1,2;"
        
        );
    
    
config.setVisible(false);
if(Active.getSearcher() == true){
BuscadorPlugin.setVisible(true);
}
}

@FXML
private void Action3(ActionEvent event){
config.setVisible(false);    
if(Active.getSearcher() == true){
BuscadorPlugin.setVisible(true);
}else{
BuscadorPlugin.setVisible(false);
}
if(Active.getReloj() == true){
RelojPlugin.setVisible(true);
}else{
RelojPlugin.setVisible(false);
}
}

@FXML
private void Action4(ActionEvent event){

if (Buscador.isSelected()==true){    
BuscadorPlugin.setVisible(true);
}else{
BuscadorPlugin.setVisible(false);
}
if (RelojCheck.isSelected()==true){    
RelojPlugin.setVisible(true);
}else{
RelojPlugin.setVisible(false);
}

if (Barra.isSelected()==true){
DesktopViewerController.setBarra(true);
}else{
DesktopViewerController.setBarra(false);
}



Active = new PluginActives(Buscador.isSelected(),Barra.isSelected(),RelojCheck.isSelected());

Loader.Save(main.ConfigPluginActives,Active);
config.setVisible(false);
if(Active.getSearcher() == true){
BuscadorPlugin.setVisible(true);
}else{
BuscadorPlugin.setVisible(false);
}
if(Active.getReloj() == true){
RelojPlugin.setVisible(true);
}else{
RelojPlugin.setVisible(false);
}
}

private void IniPlugins(){
try {
    BuscadorPlugin = FXMLLoader.load(BuscadorController.class.getResource("Buscador.fxml"));
    AnchorPane.setBottomAnchor(BuscadorPlugin, 30.0);
    AnchorPane.setLeftAnchor(BuscadorPlugin,4.0);
    AnchorPane.setRightAnchor(BuscadorPlugin, 4.0);
    secundary.getChildren().add(BuscadorPlugin);
    } catch (Exception e) {
   
    }
try{
    RelojPlugin = FXMLLoader.load(RelojController.class.getResource("Reloj.fxml"));
    AnchorPane.setTopAnchor(RelojPlugin, 4.0);
    AnchorPane.setLeftAnchor(RelojPlugin,4.0);
    AnchorPane.setRightAnchor(RelojPlugin, 4.0);
    secundary.getChildren().add(RelojPlugin);
    }catch(Exception e){}
    



    try{
    Active = (PluginActives) Loader.Load(main.ConfigPluginActives);
    BuscadorPlugin.setVisible(Active.getSearcher());
    Buscador.setSelected(Active.getSearcher());
    RelojPlugin.setVisible(Active.getReloj());
    RelojCheck.setSelected(Active.getReloj());
    Barra.setSelected(Active.getVisible());
   
    }catch(Exception e){
    RelojPlugin.setVisible(true);
    RelojCheck.setSelected(true);
    BuscadorPlugin.setVisible(true);
    Buscador.setSelected(true);
    Barra.setSelected(false);
    
    }


    
 
    

}






    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        config.setVisible(false);
        
        try{
        PluginColor color = (PluginColor) Loader.Load(main.ConfigPluginColor);
        
        secundary.setStyle(
        
       "-fx-background-radius: 8px 8px 8px 8px,  8px 8px 8px 8px,  8px 8px 8px 8px,  8px 8px 8px 8px;" 
       +"-fx-background-color: rgba(255,255,255,"+color.getAlpha()+"),rgba("+color.getRed()+","+color.getGreen()+","+color.getBlue()+","+color.getAlpha()+");"
       +"-fx-background-insets: 1,2;"
        
        );}catch(Exception e){
            System.out.println(e);
        }
        
        IniPlugins();
        
    }    
}
