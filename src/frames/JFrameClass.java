package frames;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class JFrameClass {

	private String name;
	private int setSize1;
	private int setSize2;
	private int setLocation1;
	private int setLocation2;
	private JFrame f;
	
	public JFrame createJFrame(String name,int setSize1,int setSize2,int setLocation1,int setLocation2){
		f = new JFrame(name);
		f.setSize(setSize1, setSize2);
		f.setLocation(setLocation1, setLocation2);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		f.setVisible(true);
		
		return f;
	}
}
