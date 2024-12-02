package appiumutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerInitializer {

	static AppiumDriverLocalService service = null;

	public static void startAppiumServer(int port) {
//		if (isPortInUse(0000)) {
//			System.out.println("Port " + port + " is already in use,killing & restarting it");
//			killAppiumServer(port);
//		} else {
			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder.withIPAddress("127.0.0.1");
			builder.usingPort(port);
			builder.withArgument(() -> "--allow-cors");
			builder.withArgument(() -> "--use-plugins=element-wait,gestures,device-farm");
			builder.withArgument(() -> "--plugin-device-farm-platform=android");
			service = AppiumDriverLocalService.buildService(builder);
			service.start();
		//}
	}

	private static boolean isPortInUse(int port) {
		try (ServerSocket socket = new ServerSocket(port)) {
			return false; // Port is free
		} catch (IOException e) {
			return true; // Port is in use
		}
	}

	public static void killAppiumServer(int port) {
		if (isPortInUse(port)) {
			System.out.println("Port " + port + " is not in use");
		} else {
			try {
				ProcessBuilder findPid = new ProcessBuilder("cmd.exe", "/c", "netstat -ano | findstr: " + port);
				Process process = findPid.start();
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String clop;
				while ((clop = reader.readLine()) != null) {
					if (clop != null && !clop.isEmpty()) {
						String pid[] = clop.split("\\s+");
						System.out.println("Found PID: " + pid[pid.length - 1]);
						ProcessBuilder killProcess = new ProcessBuilder("taskkill", "/f", "/pid", pid[pid.length - 1]);
						killProcess.start();
						System.out.println("Process with PID " + pid[pid.length - 1] + " has been killed.");
					} else {
						System.out.println("No process found listening on port " + port);
					}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	  public static int findFreePort(int startingPort) {
	        int port = startingPort;
	        while (true) {
	            try (ServerSocket socket = new ServerSocket(port)) {
	                // If we reach this point, the port is free
	                return port;
	            } catch (IOException e) {
	                // Port is in use, try the next one
	                port++;
	            }
	        }
	    }

}
