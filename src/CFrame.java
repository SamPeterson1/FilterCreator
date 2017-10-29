

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CFrame {
	private Frame frame;
	public CFrame() {
		frame = new Frame();
		frame.setTitle("Filter Creator");
		frame.setSize(800, 800);
		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent event) {
				return;
			}

			@Override
			public void windowClosed(WindowEvent event) {
				return;
			}

			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent event) {
				return;
			}

			@Override
			public void windowDeiconified(WindowEvent event) {
				return;
			}

			@Override
			public void windowIconified(WindowEvent event) {
				return;
			}

			@Override
			public void windowOpened(WindowEvent event) {
				return;
			}
		});
	}
	public void addCanvas(Canvas canvas) {
		frame.add(canvas);
		frame.setVisible(true);
		frame.setFocusable(true);
	}
	
}
