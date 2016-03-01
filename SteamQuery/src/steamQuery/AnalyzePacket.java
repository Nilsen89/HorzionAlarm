package steamQuery;

public class AnalyzePacket {
	public static String getMap(String packet, String name) {
		int indexOfMap = packet.indexOf("surf_");
		int indexAfterMap = packet.indexOf("csgo") - 1;
		return  name+" "+packet.substring(indexOfMap, indexAfterMap);
	}
}