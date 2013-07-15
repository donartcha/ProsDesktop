/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import nicon.NiconDesktop.core.coreFiles;
import nicon.Recursos.PCData;



/**
 *
 * @author Dony
 */
public class main extends Application {
public static Parent login;
public static Parent Desktop;
public static Parent clock;
public static Scene DesktopScene;
public static Scene scene;
public static Stage stage;
public static Stage stageDesktop;

public static String CarpetaSistema;
public static String InicioBoolean;
public static String ConfigCuenta;
public static String ConfigZone;
public static String ConfigBGRuta;
public static String ConfigPluginColor;
public static String ConfigPluginActives;
public static String ImageTemp;

    @Override
    public void start(Stage sta) throws Exception {

    this.CreateFolders();
    coreFiles Loader = new coreFiles();
    Loader.Save(CarpetaSistema);
    stage = new Stage(StageStyle.UNDECORATED);
    login = FXMLLoader.load(nicon.NiconDesktop.guifx.DesktopController.class.getResource("Desktop.fxml"));
    scene = new Scene(login);
    stage.setScene(scene);
    stage.show();
    stage.setFullScreen(true);
    
    }
    
    public static void OpenDesktopViewer() throws Exception{
    clock = FXMLLoader.load(nicon.NiconDesktop.clock.NiconClockController.class.getResource("NiconClock.fxml"));
    
    stageDesktop = new Stage();
    Desktop = FXMLLoader.load(nicon.NiconDesktop.guifx.DesktopViewer.DesktopViewerController.class.getResource("DesktopViewer.fxml"));
    DesktopScene = new Scene(Desktop);
    stageDesktop.setTitle("NiconDesktop");
    stageDesktop.setScene(DesktopScene);
    stageDesktop.show();
    stageDesktop.setFullScreen(true);
    
    stage.close();
    }
    
    public static void CloseSesion() throws Exception{
    stage = new Stage(StageStyle.UNDECORATED);
    login = FXMLLoader.load(nicon.NiconDesktop.guifx.DesktopController.class.getResource("Desktop.fxml"));
    scene = new Scene(login);
    stage.setScene(scene);
    stage.show();
    stage.setFullScreen(true);
    stageDesktop.close();
    }
    
    private void CreateFolders(){
    PCData info = new PCData();
    
    switch (info.So){
        
        case "Windows XP":
        CarpetaSistema = info.Home+"\\NiconApps\\NiconDesktop";
        InicioBoolean = CarpetaSistema+"\\InicioBoolean.cfg";
        ConfigCuenta = CarpetaSistema+"\\ConfigCuenta.cfg";
        ConfigZone = CarpetaSistema+"\\ConfigZone.cfg";
        ConfigBGRuta = CarpetaSistema+"\\ConfigBGRuta.cfg";
        ConfigPluginColor = CarpetaSistema+"\\ConfigPluginColor.cfg";
        ConfigPluginActives = CarpetaSistema+"\\ConfigPluginActives.cfg";
        ImageTemp = CarpetaSistema+"\\background";
        break;
           
            
        case "Windows 7":
        CarpetaSistema = info.Home+"\\NiconApps\\NiconDesktop";
        InicioBoolean = CarpetaSistema+"\\InicioBoolean.cfg";
        ConfigCuenta = CarpetaSistema+"\\ConfigCuenta.cfg";
        ConfigZone = CarpetaSistema+"\\ConfigZone.cfg";
        ConfigBGRuta = CarpetaSistema+"\\ConfigBGRuta.cfg";
        ConfigPluginColor = CarpetaSistema+"\\ConfigPluginColor.cfg";
        ConfigPluginActives = CarpetaSistema+"\\ConfigPluginActives.cfg";
        ImageTemp = CarpetaSistema+"\\background";
        break;
            
            
        default: 
        CarpetaSistema = info.Home+"/NiconApps/NiconDesktop";
        InicioBoolean = CarpetaSistema+"/InicioBoolean.cfg";
        ConfigCuenta = CarpetaSistema+"/ConfigCuenta.cfg";
        ConfigZone = CarpetaSistema+"/ConfigZone.cfg";
        ConfigBGRuta = CarpetaSistema+"/ConfigBGRuta.cfg";
        ConfigPluginColor = CarpetaSistema+"/ConfigPluginColor.cfg";
        ConfigPluginActives = CarpetaSistema+"/ConfigPluginActives.cfg";
        ImageTemp = CarpetaSistema+"/background";
        break;
            
    }}

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}