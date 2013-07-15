/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nicon.NiconDesktop.object;

import java.io.Serializable;

/**
 *
 * @author donaldo
 */
public class Cuenta implements Serializable{
private String User;
private String Pass;
public Cuenta(){
}
public Cuenta(String a, String b){
User=a;
Pass=b;
}
public void setName(String a){
User = a;
}
public void setPass(String a){
Pass = a;
}
public String getUser(){
return User;
}
public String getPass(){
return Pass;
}
}
