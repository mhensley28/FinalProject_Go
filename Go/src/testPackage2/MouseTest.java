package testPackage2;

import java.awt.Component;
import java.awt.event.MouseEvent;

public class MouseTest extends MouseEvent{

	public MouseTest(Component source, int id, long when, int modifiers, int x, int y, int clickCount,
			boolean popupTrigger) {
		super(source, id, when, modifiers, x, y, clickCount, popupTrigger);
		// TODO Auto-generated constructor stub
	}
	
	static void MOUSE_CLICKED() {
		
	}
}
