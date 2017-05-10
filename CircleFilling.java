/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;
import javax.microedition.io.*;
import java.util.*;
import java.lang.*;
 
public class CircleFilling extends MIDlet implements CommandListener{
    private Command exitCommand,goCommand,backCommand;
    private Display display;
    private Form screen1;
    private DrawCircle circle;
    public  TextField tf1;
    public int r;
        
    public CircleFilling(){
        
        //circle = new drawCircle(tf1); 
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit",Command.EXIT,2);
        goCommand = new Command("Draw",Command.OK,2);
         backCommand = new Command("Back",Command.BACK,1);
           
                     
         screen1 = new Form("Circle Drawing");
         
          
        screen1.addCommand(exitCommand);
        screen1.addCommand(goCommand);
        screen1.addCommand(backCommand);
        screen1.setCommandListener(this);
         
         tf1 = new TextField("Enter circle radius","10",50,0);
         screen1.append(tf1);
           
          
         //screen2 = new Form("circle");
         }

    public void startApp() throws MIDletStateChangeException {
        display.setCurrent(screen1);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    public void commandAction(Command c,Displayable d){
        if(c == exitCommand){
            destroyApp(false);
            notifyDestroyed();
        }
        else if( c == goCommand ){
            r=Integer.parseInt(tf1.getString());
          circle = new DrawCircle(r);
         display.setCurrent(circle);
         screen1.setCommandListener(this);
        }
        else if(c == backCommand){
            screen1.setCommandListener(this);
        }
      
    }
    
}
class DrawCircle extends Canvas {
      
     int radius=0;
     //Command back;
       public DrawCircle(int r){
           radius=r;
          // back = new Command("Back",Command.BACK,1);
           //addCommand(back);
           //setCommandListener(this);
       }
        public void paint(Graphics g){
            g.setColor(255,255,255);
            g.drawArc(getWidth()/2,getHeight()/2,radius,radius,0,360);
        }
}
