

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class Howdy extends MIDlet implements CommandListener {
private Command exitCommand;
private Display display;
private Form screen;
public Howdy() {
// Get the Display object for the MIDlet
display = Display.getDisplay(this);
// Create the Exit command
exitCommand = new Command("Exit", Command.EXIT, 2);
// Create the main screen form
screen = new Form("Howdy");
// Create a string item and add it to the screen
StringItem strItem = new StringItem("hello there", "Howdy pardner!");
screen.append(strItem);
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