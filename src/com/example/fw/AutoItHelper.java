package com.example.fw;

import java.io.File;

import autoitx4java.AutoItX;

import com.jacob.com.ComThread;
import com.jacob.com.LibraryLoader;

public class AutoItHelper extends HelpersBase {

    static {
        File jacob = new File("./lib/jacob-1.15-M4-x86.dll");
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, jacob.getAbsolutePath());
    }

    public AutoItHelper(ApplicationManager manager) {
        super(manager);
        ComThread.InitMTA();
        aux = new AutoItX();
    }

    private String winTitle;
    private String winText;

    private final AutoItX aux;

    public AutoItHelper winWaitAndActivate(String winTitle, String winText, int timeout) {
        
    	this.winTitle = winTitle;
        this.winText = winText;
        aux.winWait(winTitle, winText, timeout);
        aux.winActivate(winTitle, winText);
        aux.winWaitActive(winTitle, winText, timeout);
        System.out.println("Windows activated: " + winTitle);
        return this;
    }

    public AutoItHelper click(String controlID) {
        aux.controlClick(winTitle, winText, controlID);
        System.out.println("Control clicked: " + controlID);
        return this;
    }

    public AutoItHelper focus(String controlID) {
        aux.controlFocus(winTitle, winText, controlID);
        System.out.println("Control focused: " + controlID);
        return this;
    }

    public AutoItHelper send(String text) {
        aux.send(text, false);
        return this;
    }
    
    public AutoItHelper send(String controlID, String text) {
        focus(controlID);
        aux.send(text, false);
        return this;
    }

	public String getText(String controlID) {
		return aux.controlGetText(winTitle, winText, controlID);
	}
}
