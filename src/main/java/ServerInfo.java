package main.java;

public class ServerInfo {
	
	private String[] serverIP = {
								"192.223.29.148", 
								"192.223.29.148",
								"74.91.120.144",
								"192.223.29.148",
								"74.91.120.144",
								"31.186.250.77",
								"31.186.250.77",
								"31.186.250.77",
								"74.91.120.159",
								"31.186.250.77"
	};
	private int[] serverPORT = {
								27015,
								27016,
								27015,
								27017,
								27016,
								27015,
								27016,
								27017,
								27016,
								27018
	};
	private String[] serverName = {
									"Beginner Surf (US)",
									"Easy Surf 1 (US)",
									"Easy Surf 2 (US)",
									"Medium Surf (US)",
									"Hard Surf (US)",
									"Easy Surf (EU)",
									"Medium Surf(EU)",
									"Hard Surf (EU)",
									"Donator(US)",
									"Donator(EU)"
	};
	
	public String getServerIP(int index) {
		return serverIP[index];
	}
	public int getServerPORT(int index) {
		return serverPORT[index];
	}
	public String getServerName(int index) {
		return serverName[index];
	}
	public int getServerSize() {
		return serverName.length;
	}
}
