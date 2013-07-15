/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.clock;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;
import nicon.NiconDesktop.core.coreFiles;

/**
 *
 * @author Dony
 */
public class DigitalClock extends Label {
public static String zone = "Europe/Madrid";
private Calendar time;
private static coreFiles Loader = new coreFiles();
public DigitalClock() {
    try{
    zone = (String) Loader.Load(nicon.NiconDesktop.main.ConfigZone);
    
    }catch(Exception e){}
    
  /**
      time =  GregorianCalendar.getInstance();

  TimeZone zone = time.getTimeZone();
  String[] zonas = TimeZone.getAvailableIDs();
  int zero = 0;
  while(zero < zonas.length){
  System.out.println("zona: "+zonas[zero]);
  zero++;
  }
  
  zone.setID("Pacific/Auckland");
  time.setTimeZone(zone);
  *
  *
  * 
  */
 
  
bindToTime();
  }

  public static void setZone(String a){
         
  zone = a;
  Loader.Save(nicon.NiconDesktop.main.ConfigZone, zone);
  }
  // the digital clock updates once a second.
  private void bindToTime() {
    Timeline timeline;
    timeline = new Timeline(
new KeyFrame(Duration.seconds(0),
new EventHandler<ActionEvent>() {
 @Override public void handle(ActionEvent actionEvent) {
   time =  GregorianCalendar.getInstance();

 
   TimeZone tz = TimeZone.getTimeZone(zone);
   time.setTimeZone(tz);
  
   time = Calendar.getInstance(tz);
         
              
  
int dia = time.get(Calendar.DAY_OF_MONTH); 
int diad = time.get(Calendar.DAY_OF_WEEK);
String diat ="";
switch(diad){
   
    case 2: diat = "Lunes";break;
    case 3: diat = "Martes";break;
    case 4: diat = "Miércoles";break;    
    case 5: diat = "Jueves";break;    
    case 6: diat = "Viernes";break;
    case 7: diat = "Sabado";break; 
    case 1: diat = "Domingo";break;    
}


int mes = (time.get(Calendar.MONTH) + 1); 
String mest = "";
switch(mes){
    case 1: mest = "Enero";break;
    case 2: mest = "Febrero";break;
    case 3: mest = "Marzo";break;    
    case 4: mest = "Abril";break;    
    case 5: mest = "Mayo";break;
    case 6: mest = "Junio";break; 
    case 7: mest = "Julio";break;
    case 8: mest = "Agosto";break;
    case 9: mest = "Septiembre";break;    
    case 10: mest = "Octubre";break;    
    case 11: mest = "Noviembre";break;
    case 12: mest = "Diciembre";break; 

}
int año = time.get(Calendar.YEAR); 
int hora = time.get(Calendar.HOUR_OF_DAY); 
int minutos = time.get(Calendar.MINUTE); 
int segundos = time.get(Calendar.SECOND); 
String hour = String.format("%02d : %02d : %02d", hora, minutos, segundos); 
String date = diat+" "+dia +" de "+mest +" de "+año ;
        
   
        
  //StringUtilities.pad(2, ' ', time.get(GregorianCalendar.HOUR) == 0 ? "12" : time.get(GregorianCalendar.HOUR) + "");
  // String minuteString = StringUtilities.pad(2, '0', time.get(GregorianCalendar.MINUTE) + "");
  // String secondString = StringUtilities.pad(2, '0', time.get(GregorianCalendar.SECOND) + "");
  // String ampmString = time.get(GregorianCalendar.AM_PM) == GregorianCalendar.AM ? "AM" : "PM";
   nicon.NiconDesktop.clock.NiconClockController.setclock(hour+ " - " + date);
   nicon.NiconDesktop.guifx.Plugins.Reloj.RelojController.setHour(hora,minutos,segundos,hour);
 }
}
),
new KeyFrame(Duration.seconds(1))
);
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
  }
}
