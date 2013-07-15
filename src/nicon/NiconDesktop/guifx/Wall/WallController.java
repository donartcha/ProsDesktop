/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx.Wall;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import nicon.NiconDesktop.core.coreFiles;
import nicon.NiconDesktop.core.coreImageChooser;
import nicon.NiconDesktop.core.coreOption;
import nicon.NiconDesktop.guifx.DesktopViewer.DesktopViewerController;
import nicon.NiconDesktop.main;
import nicon.NiconDesktop.object.Icono;

/**
 * FXML Controller class
 *
 * @author Dony
 */
public class WallController implements Initializable {
private coreFiles Loader = new coreFiles();   
  

@FXML
private AnchorPane viewer;
@FXML
private ScrollPane viewerParent;
@FXML
private Button Aplicar1;
@FXML
private Button Aplicar2;
@FXML
private TextField Field1;
@FXML
private TextField Field2;

@FXML
private void ActionAplicar1(ActionEvent event){
coreImageChooser openImage = new coreImageChooser();
System.out.println(openImage.path);
if (openImage.path==null){}else{
DesktopViewerController.setBGRuta("file:"+openImage.path);
}
}

@FXML
private void ActionAplicar2(ActionEvent event){
Loader.Download(Field2.getText(), nicon.NiconDesktop.main.ImageTemp);
while(true){
if (Loader.getStatus()==false){
DesktopViewerController.setBGRuta("file:"+Loader.getRuta()); 
break;
} 
}
       


}

    private void DefaultImages(){
        
        Icono img1 = new Icono();
        img1.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/NiconSystemWall1.png").toString());
    
        Icono img2 = new Icono();
        img2.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall1.jpg").toString());
      
        Icono img3 = new Icono();
        img3.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall2.jpg").toString());
        
        Icono img4 = new Icono();
        img4.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall3.jpg").toString());
        
        Icono img5 = new Icono();
        img5.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall4.jpg").toString());
        
        Icono img6 = new Icono();
        img6.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall5.jpg").toString());
        
        Icono img7 = new Icono();
        img7.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall6.jpg").toString());
        
        Icono img8 = new Icono();
        img8.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall7.jpg").toString());
        
        Icono img9 = new Icono();
        img9.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall8.jpg").toString());
        
        Icono img10 = new Icono();
        img10.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall9.jpg").toString());
        
        Icono img11 = new Icono();
        img11.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall10.jpg").toString());
        
        Icono img12 = new Icono();
        img12.setImagen(nicon.NiconDesktop.guifx.DesktopController.class.getResource("view/Wallpapers/wall11.jpg").toString());
        
        List imagenes = new ArrayList();
        imagenes.add(img1);
        imagenes.add(img2);
        imagenes.add(img3);
        imagenes.add(img4);
        imagenes.add(img5);
        imagenes.add(img6);
        imagenes.add(img7);
        imagenes.add(img8);
        imagenes.add(img9);
        imagenes.add(img10);
        imagenes.add(img11);
        imagenes.add(img12);
        
        
        
        
int zero1 = 0;
int zero2 = 0;
while(zero1 < imagenes.size()){
int cantidadx = (int) (800/160);
Icono[][] matriz = new Icono[1000][cantidadx];
matriz[zero1][zero2] = (Icono)imagenes.get(zero1);
final Icono IMG = (Icono)imagenes.get(zero1);

Double alto = Double.valueOf((zero1/cantidadx));
if (alto == 0.0){
AnchorPane.setTopAnchor(IMG, 5.0);
}else{
AnchorPane.setTopAnchor(IMG, 160.0*alto);}
if (zero2 == 0){
AnchorPane.setLeftAnchor(IMG, 5.0);
}else{
AnchorPane.setLeftAnchor(IMG, 160.0*zero2);}
IMG.setVisible(true);
IMG.setCursor(Cursor.HAND);
IMG.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                //Evento de establecer imagen de fondo...

coreOption md = new coreOption(main.stageDesktop, IMG);
                
  
            }
        });



viewer.getChildren().add(IMG);

zero1++;
zero2++;
if (zero2 == cantidadx){zero2 = 0;}
}    
        
        
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    viewer.setMinSize(viewerParent.getWidth(),viewerParent.getHeight());
   
    this.DefaultImages();
    }    
}
