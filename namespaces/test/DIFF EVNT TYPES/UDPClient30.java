import java.io.*;
import java.net.*;
import java.util.logging.*;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;
import java.util.Date;
import java.util.concurrent.*;

class UDPClient30
{
//private static Logger logger = Logger.getLogger(UDPClient.class.getName());
//private static FileHandler fh = null; 


    public static void main(String args[]) throws Exception
    {
//FileHandler fh =  new FileHandler("/usr/src/cep/client.txt");  
int counter = 1;
int val = 0;
//logger.addHandler(fh);
//logger.setLevel(Level.ALL);
//logger.setUseParentHandlers(false);


      ArrayList<String> list = new ArrayList<String>(){{
                add("A");
                add("AA");
                add("AAA");
                add("AAAA"); 
                add("AAAAA");  
                add("AAAAAA"); 
                add("AAAAAAA"); 
                add("AAAAAAAA");    
                add("AAAAAAAAA"); 
                add("TEST");
                add("B");
                add("BB");
                add("BBB");
                add("BBBB"); 
                add("BBBBB");  
                add("AAAAAA"); 
                add("BBBBBBB"); 
                add("BBBBBBBB");    
                add("BBBBBBBBB"); 
                add("BEST");
                add("C");
                add("CC");
                add("CCC");
                add("CCCC"); 
                add("CCCCC");  
                add("CCCCCC"); 
                add("CCCCCCC"); 
                add("CCCCCCCC");    
                add("CCCCCCCCC"); 
                add("CEST");
                        }}; 
      while(counter <= 100000){ 
        

	BufferedReader inFromUser =
          new BufferedReader(new InputStreamReader(System.in));
       DatagramSocket clientSocket = new DatagramSocket();
       InetAddress IPAddress = InetAddress.getByName("10.1.1.3");
       byte[] sendData = new byte[1024];
      // byte[] receiveData = new byte[1024];


//        Date date = new Date();
        //String s = catalogue.get(2);
         //StringBuilder sentence = new StringBuilder(list.get(new Random().nextInt(list.size()))); //new Random().nextInt(list.size())
        StringBuilder sentence = new StringBuilder("CEP");
         sentence.append(",");
	sentence.append(list.get(new Random().nextInt(list.size())));
sentence.append(",");
         sentence.append(new Random().nextInt(10));//sentence.append(new Random().nextInt(2000));
         sentence.append(",");
         sentence.append(new Date().getTime());

         //date.getTime()

       sendData = sentence.toString().getBytes();
       DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9877);

//       System.out.println("Sending packet: "+sentence);
      //logger.info("Sending packet");

       clientSocket.send(sendPacket);
       counter ++;
       val ++;
       val=val%10;

       //DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
       //clientSocket.receive(receivePacket);
       //String modifiedSentence = new String(receivePacket.getData());
       //System.out.println("FROM SERVER:" + modifiedSentence);
       clientSocket.close();
	       Thread.sleep(1);

    }
}
}
