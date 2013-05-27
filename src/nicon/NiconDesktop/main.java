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

/**
 *
 * @author Dony
 */
public class main extends Application {
public static Parent login;
public static Parent Desktop;
public static Scene DesktopScene;
public static Scene scene;
public static Stage stage;
public static Stage stageDesktop;

    @Override
    public void start(Stage sta) throws Exception {
    stage = new Stage(StageStyle.UNDECORATED);
    login = FXMLLoader.load(nicon.NiconDesktop.guifx.DesktopController.class.getResource("Desktop.fxml"));
    scene = new Scene(login);
    stage.setScene(scene);
    stage.show();
    stage.setFullScreen(true);
    
    }
    
    public static void OpenDesktopViewer() throws Exception{
    stageDesktop = new Stage();
    Desktop = FXMLLoader.load(nicon.NiconDesktop.guifx.DesktopViewer.DesktopViewerController.class.getResource("DesktopViewer.fxml"));
    DesktopScene = new Scene(Desktop);
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