package net.modding.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import net.modding.main.modding;

public class UpdateChecker {

	private static final String Update_File = "https://www.dropbox.com/s/rv8zhgin6zp4xhs/ModUpdate.txt?dl=1";
	private static boolean newVersionAvailable = false;
	
	public static void checkForUpdates() {
		new Thread("Update-Checker") {
			
			public void run() {
				try {
					URL url = new URL(Update_File);
					Scanner scanner = new Scanner(url.openStream());
					String latestVersion = scanner.nextLine();
					scanner.close();
					
					if(!modding.VERSION.equals(latestVersion)) {
						setNewVersionAvailable();
					}
				} catch (MalformedURLException e) {
					System.err.println("Wrong URL!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
			
		}.start();
	  }
	
	private static synchronized void setNewVersionAvailable() {
		newVersionAvailable = true;
	}
	
	public static synchronized boolean isNewVersionAvailable() {
		return newVersionAvailable;
	}
	
}
