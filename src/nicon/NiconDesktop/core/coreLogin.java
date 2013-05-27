/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.core;
import java.util.logging.Level;
import java.util.logging.Logger;
import nicon.NiconDesktop.guifx.DesktopController;
/**
 *
 * @author Dony
 */
public class coreLogin {
private String user, pass;    
private String userprueba, passprueba;

public coreLogin(String a, String b, int intento){
user = a;
pass = b;


//Usuario de prueba
userprueba = "nicon";
passprueba = "naranja";

if (intento < 3){
checkUSER();
}else{
System.exit(0);
}
}

private void checkUSER(){
if(user.equals(userprueba)){
checkPASS();

}else{
DesktopController.Loginbug("Nicon ID no existe");
DesktopController.addIntento();
}    
}

private void checkPASS(){
if(pass.equals(passprueba)){
    try {
        nicon.NiconDesktop.main.OpenDesktopViewer();
    } catch (Exception ex) {
    System.out.println("Imposible abrir DesktopViewer");
    }

}else{
DesktopController.Loginbug("Contraseña Incorrecta");
DesktopController.addIntento();
}    
    
    
}

}
