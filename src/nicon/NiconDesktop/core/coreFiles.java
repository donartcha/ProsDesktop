/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import nicon.NiconDesktop.main;

/**
 *
 * @author donaldo
 */
public class coreFiles {
private String camino;
private Boolean status = true;  
public coreFiles(){

}
public Boolean getStatus(){
return status;
}
public String getRuta(){
return camino;
}

public void Save(String a){
System.out.println("Creando carpeta en: "+a);
File archivo = new File(a);
if (archivo.exists()==false){
archivo.mkdirs();
}
}

public void Save(String a, Object b){
System.out.println("Guardando Objeto: "+b+" \tEn: "+a);
File archivo = new File(a);
try{
    FileOutputStream salida;
    salida = new FileOutputStream(a); 
    ObjectOutputStream dos;
    dos = new ObjectOutputStream(salida);
    dos.writeObject(b);
    salida.close();
    dos.close();
System.out.println("Archivo guardado con exito.");
}catch(Exception e){
System.out.println("Fallo al guardar objeto");
}
}//Fin del método save  


public Object Load(String a){
System.out.println("Guardando fichero: "+a);
Object readed = "";
File archivo = new File(a);
if (archivo.exists()==false){
System.out.println("No existe fichero");
}else{
try{    
        
        FileInputStream entrada;
        entrada = new FileInputStream(archivo); 
        ObjectInputStream in;
        in = new ObjectInputStream(entrada);
        
        readed = in.readObject();
        
        entrada.close();
        in.close();
        System.out.println("Fichero se cargó con exito.");
        }catch(IOException | ClassNotFoundException e){
        System.out.println("Fallo al cargar fichero");
        }
    }
    return readed;

    
}

public void Download(final String link) {
    status = true;
    Thread download = new Thread(new Runnable(){
    @Override
    public void run(){
    try{
URL url = new URL(link);
URLConnection urlCon = url.openConnection();
String name = url.getFile();
System.out.println(name);
String tipo = urlCon.getContentType();
System.out.println(tipo);

String camino = main.CarpetaSistema+File.separator+name;
File Ruta = new File(camino);
if (Ruta.exists()){

int i1 = name.lastIndexOf(".");
        
String Name = name.substring(0, i1-1);
String Extencion = name.substring(i1,name.length());

int c = 1;
String Newname = Name+"("+c+")"+Extencion;
Ruta = new File(main.CarpetaSistema+File.separator+Newname);
while(Ruta.exists()==true){
Newname = Name+"("+c+")"+Extencion;
Ruta = new File(main.CarpetaSistema+File.separator+Newname); 
c++;
}

}

                       int tmax1 = urlCon.getContentLength();
                        System.out.println("Tmax1= " + tmax1);
                       float tmax = (float) tmax1/1000000;
                       int tdes = 0;
                       float t = tmax1/100;
                      
                       int cero = 0;
                       
            FileOutputStream fos;
            try (InputStream is = urlCon.getInputStream()) {
                fos = new FileOutputStream(Ruta);
                byte[] array = new byte[1000];
                int leido = is.read(array);
                while (leido > 0) {
                        fos.write(array, 0, leido);
                        leido = is.read(array);
                        tdes = tdes + leido;
                              
                }
                System.out.println("DescargaCompletada");
                fos.close();
                is.close();
                status = false;
		
            }
			

}catch(Exception e){}
    }
    });
    download.start();
 }                   
    

public void Download(final String link, final String ruta) {  
status = true;
Thread download = new Thread(new Runnable(){
@Override
public void run(){

try{
URL url = new URL(link);
URLConnection urlCon = url.openConnection();
String filename = url.getFile();
int num = filename.lastIndexOf("/");
String name = filename.substring(num+1, filename.length());
System.out.println(name);
String tipo = urlCon.getContentType();
System.out.println(tipo);

int i1 = name.lastIndexOf(".");

String Tipe = name.substring(i1,name.length());

camino = ruta+Tipe;
File Ruta = new File(camino);


                       int tmax1 = urlCon.getContentLength();
                        System.out.println("Tmax1= " + tmax1);
                       float tmax = (float) tmax1/1000000;
                       int tdes = 0;
                       float t = tmax1/100;
                      
                       int cero = 0;
                       
            FileOutputStream fos;
            try (InputStream is = urlCon.getInputStream()) {
                fos = new FileOutputStream(Ruta);
                byte[] array = new byte[1000];
                int leido = is.read(array);
                while (leido > 0) {
                        fos.write(array, 0, leido);
                        leido = is.read(array);
                        tdes = tdes + leido;
                              
                }
                System.out.println("DescargaCompletada");
                fos.close();
                is.close();
                status = false;
  
            }
			

}catch(Exception e){}
        
}  
});
download.start();
  
}


}



