/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.guifx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import nicon.NiconDesktop.core.coreFiles;
import nicon.NiconDesktop.core.coreLogin;
import nicon.NiconDesktop.object.Cuenta;

/**
 *
 * @author Dony
 */
public class DesktopController implements Initializable {
    private coreLogin login;
    private static int intento = 0;
    private coreFiles Loader = new coreFiles();
    private Boolean remember;
    
    @FXML
    private static Label userbug;
    @FXML
    private Label Shutdown;
    @FXML
    private TextField User;
    @FXML
    private PasswordField Pass;
    @FXML
    private Button Login;
    @FXML
    private CheckBox Remember;
    
    
    @FXML
    private void ActionUser(MouseEvent event) {
    User.setText("");
    }
    @FXML
    private void ActionPass(MouseEvent event) {
    Pass.setText("");
    }
    @FXML
    private void ActionLogin(ActionEvent event) {
        
    Loader.Save(nicon.NiconDesktop.main.InicioBoolean, remember);
    Cuenta usuario = new Cuenta(User.getText(),Pass.getText());
    Loader.Save(nicon.NiconDesktop.main.ConfigCuenta, usuario);
    login = new coreLogin(User.getText(),Pass.getText(),intento);
        
    }
    @FXML
    private void ActionShutdown(MouseEvent event) {
    System.exit(0);
    }
    
    @FXML
    private void ActionRemember(ActionEvent event) {
    remember = Remember.isSelected();
    }
    public static void Loginbug(String a){
    userbug.setText(a);
    }
    public static void addIntento(){
    intento++;
    }
    
    
    
    @FXML
    private void KeyEnter(KeyEvent event){
    if (event.getCode()==KeyCode.ENTER){
    this.ActionLogin(null);
    
    }
    }

    
    
    
    private void addToolTip(){
    Tooltip tooltip1 = new Tooltip();
    tooltip1.setText("Introduce tu Nicon ID");
    User.setTooltip(tooltip1);
    
    Tooltip tooltip2 = new Tooltip();
    tooltip2.setText("Introduce tu Contraseña");
    Pass.setTooltip(tooltip2);
    
    Tooltip tooltip3 = new Tooltip();
    tooltip3.setText("Apaga NiconDesktop");
    Shutdown.setTooltip(tooltip3);
    
    Tooltip tooltip4 = new Tooltip();
    tooltip4.setText("Inicia sesión en NiconDesktop");
    Login.setTooltip(tooltip4);
    
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    this.addToolTip();
    userbug.setText("");
    try{
    Boolean inicio = (Boolean) Loader.Load(nicon.NiconDesktop.main.InicioBoolean);
    if (inicio == true){
    Remember.setSelected(true);
    remember = true;
    Cuenta usuario = (Cuenta) Loader.Load(nicon.NiconDesktop.main.ConfigCuenta);
    User.setText(usuario.getUser());
    Pass.setText(usuario.getPass());
    }
    else{    
    Remember.setSelected(false);
    remember = false;
    }
    }catch(Exception e){
    Remember.setSelected(false);
    remember = false;
    }    
    }
}
