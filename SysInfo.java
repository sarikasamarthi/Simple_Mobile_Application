package wirelessproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.util.*;
public class SysInfo extends MIDlet implements CommandListener {
private Command exitCommand;
private Display display;
private Form screen;
public SysInfo() {
// Get the Display object for the MIDlet
display = Display.getDisplay(this);
// Create the Exit command
exitCommand = new Command("Exit", Command.EXIT, 2);
// Create the main screen form
screen = new Form("SysInfo");
// Obtain the current time
Calendar calendar = Calendar.getInstance();
String time = Integer.toString(calendar.get(Calendar.HOUR)) + ":" +
Integer.toString(calendar.get(Calendar.MINUTE)) + ":" + Integer.toString(calendar.get(Calendar.SECOND));
// Obtain the total and free memory, and convert them to strings
Runtime runtime = Runtime.getRuntime();
String totalMem = Long.toString(runtime.totalMemory());
String freeMem = Long.toString(runtime.freeMemory());
// Obtain the display properties
String isColor = display.isColor() ? "Yes" : "No";
String numColors = Integer.toString(display.numColors());
// Create string items and add them to the screen
screen.append(new StringItem("", "Time: " + time));
screen.append(new StringItem("", "Total mem: " + totalMem));
screen.append(new StringItem("", "Free mem: " + freeMem));
screen.append(new StringItem("", "Color: " + isColor));
screen.append(new StringItem("", "# of colors: " + numColors));
// Set the Exit command
screen.addCommand(exitCommand);
screen.setCommandListener(this);
}
public void startApp() throws MIDletStateChangeException {
// Set the current display to the screen
display.setCurrent(screen);
}
public void pauseApp() {
}
public void destroyApp(boolean unconditional) {
}
public void commandAction(Command c, Displayable s) {
        if (c == exitCommand) {
                destroyApp(false);
                notifyDestroyed();
        }
}
}
