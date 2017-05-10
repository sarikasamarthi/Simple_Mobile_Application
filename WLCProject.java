import javax.microedition.lcdui.CommandListener;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;
import javax.microedition.io.*;
import java.util.*;
import java.lang.*;

/**
 * @author SARIKA
 */
public class WLCProject extends MIDlet implements CommandListener{
    private Command exitCommand,backCommand,goCommand;
    private Display display;
    private Form screen,screen1;
    private List choice;
    private drawCircle circle;
    private TextField tf1;
    
    public WLCProject(){
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit",Command.EXIT,2);
        //backCommand = new Command("Back",Command.BACK,0);
       goCommand = new Command("Ok",Command.OK,2);
        
        //screen = new Form("WIRELESS PROJECT");       
        
        choice = new List("USER MENU",List.IMPLICIT);
        choice.append("1.Enter URL", null);
        choice.append("2.Draw Circle",null);
        choice.append("3.Draw Rectangle",null);
        choice.append("4.Calc Float Product",null);
        
         
         screen = new Form("Circle Drawing");
         
         tf1 = new TextField("Enter circle radius","10",50,0);
         screen.append(tf1);
        
        circle = new drawCircle(tf1);
        
        screen.addCommand(exitCommand);
        //screen.addCommand(backCommand);
        //screen.addCommand(goCommand);
        screen.setCommandListener(this);
        
    }

    public void startApp() throws MIDletStateChangeException {
        display.setCurrent(choice);
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
       /* else if(c == goCommand){
            display.setCurrent(screen);
        }*/
       else {
             List selected = (List)display.getCurrent();
             
             switch(selected.getSelectedIndex()){
                 
                 case 0: 
                         display.setCurrent(screen);
                         break;
             }
        }
    }
    
    
}
class drawCircle extends Canvas {
      private int radius=0;
       drawCircle(TextField tf1){
           //TextField tf=tf1;
           radius = Integer.parseInt(tf1.getString());
       }
        public void paint(Graphics g){
            g.setColor(255,255,255);
            g.fillRect(0,0,getWidth(),getHeight());   
            //int radius = Integer.parseInt(tf1.getString());
            g.setColor(0,255,0);
            g.drawArc(getWidth()/2,getHeight()/2,radius,radius,0,360);
            g.fillArc(getWidth()/2,getHeight()/2,radius,radius,0,360);
        }
}
