package admin;

import java.awt.EventQueue;

public class AdminMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdminFrame clientFrame = new AdminFrame();
				new AdminFrameManager(clientFrame);
				clientFrame.showClientFrame();
			}
		});
	}
}