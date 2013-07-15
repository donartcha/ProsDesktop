/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.object;

import java.io.Serializable;

/**
 *
 * @author Dony
 */
public class PluginColor implements Serializable{

    private int R,G,B;
    private double A;
    
public PluginColor(){

}    
public PluginColor(int r,int g,int b, double a){
R = r;
G = g;
B = b;
A = a;
}    
public int getRed(){
return R;
}
public int getGreen(){
return G;
}
public int getBlue(){
return B;
}
public double getAlpha(){
return A;
}
}
