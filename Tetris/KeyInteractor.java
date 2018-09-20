//source code for KeyInteractor:

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class KeyInteractor extends AbstractAction {

    public static final String COMMAND_PREFIX = "KeyInteractor";

   public KeyInteractor (JComponent comp, int keyCode, int mod) { 
	super();
	// a name that identifies this action
	String actionID = COMMAND_PREFIX + keyCode + "." + mod;

	//map the keystroke to the actionID in the InputMap
	InputMap imap = comp.getInputMap();
	imap.put(KeyStroke.getKeyStroke(keyCode,mod), actionID);

	//map the action key to this
	ActionMap amap = comp.getActionMap();
	amap.put(actionID, this);
    }

    public KeyInteractor (JComponent comp, int keyCode) { 
	this(comp,keyCode,0);  // default--no CTRL-SHIFT-etc modifier
    }

    public abstract void actionPerformed (ActionEvent e);

}
