package client;

import java.awt.EventQueue;

public class ClientMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ClientFrame clientFrame = new ClientFrame();
				new ClientFrameManager(clientFrame);
				clientFrame.showClientFrame();
			}
		});
	}
}