package admin;

import java.awt.EventQueue;

public class AdminMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdminFrame adminFrame = new AdminFrame();
				new AdminFrameManager(adminFrame);
				adminFrame.showAdminFrame();
			}
		});
	}
}