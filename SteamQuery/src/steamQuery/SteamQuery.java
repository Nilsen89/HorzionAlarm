package steamQuery;
import java.net.*;

public class SteamQuery {
	
	private InetSocketAddress socketAdr;
	private DatagramSocket datagramSock;
	private DatagramPacket datagramPacketSend;
	private DatagramPacket datagramPacketRecieve;
		
	public String getServerQuery(String ip, int port) {
		try {
			datagramSock = new DatagramSocket(null);
			socketAdr = new InetSocketAddress(ip, port);
			datagramSock.connect(socketAdr);
			
			byte[] header = new byte[54];
			for(int i = 0; i < 4; i++) {
				header[i] = -1;
			}
			byte[] requestBytes = ("T"+"Source Engine Query").getBytes("ISO-8859-1");
			System.arraycopy(requestBytes, 0, header, 4, requestBytes.length);
			
			byte[] buffer = new byte[12288];
			
			datagramPacketSend = new DatagramPacket(header, header.length);
			datagramPacketRecieve = new DatagramPacket(buffer, buffer.length);

			datagramSock.send(datagramPacketSend);
			datagramSock.receive(datagramPacketRecieve);
			
			datagramSock.close();

			return (new String(buffer, "UTF-8"));
		} catch(Exception e) {
			System.out.println("ERROR: "+ e);
		}
		return "COULD NOT GET SERVER PACKET";
	}
}