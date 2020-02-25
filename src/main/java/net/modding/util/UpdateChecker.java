package net.modding.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
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
					scanner.findWithinHorizon(modding.BUILDED_MC_VERSION, 0);
					String lastestVersion = scanner.nextLine();
					scanner.close();
					lastestVersion = lastestVersion.substring(lastestVersion.indexOf(lastestVersion.charAt(2)));
					
					if(!modding.VERSION.equals(lastestVersion)) {
						setNewVersionAvailable();
					}
				} catch (MalformedURLException e) {
					System.err.println("Wrong URL!");
				} catch (UnknownHostException e) {
					System.err.println("Impossible to enter the Internet!");
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
