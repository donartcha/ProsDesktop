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
public class PluginActives implements Serializable{
    private boolean Buscador,BarraLateral,Reloj;
    public PluginActives(){}
    public PluginActives(boolean searcher, boolean bar,boolean reloj){
    Buscador = searcher;
    BarraLateral = bar;
    Reloj = reloj;
    }
    
    public boolean getSearcher(){
    return Buscador;
    }
    
    public boolean getVisible(){
    return BarraLateral;
    }
    
    public boolean getReloj(){
    return Reloj;
    }
}
