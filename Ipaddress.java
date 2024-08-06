// 4.	Write a program to check IPv4 and IPv6 Address.

import java.net.*;

public class Ipaddress{
        public static void main(String[] args) {
            try {
            InetAddress ads=InetAddress.getByName("192.168.1.1");
            byte[] address=ads.getAddress();
            if(address.length==4){
                System.out.println("Ip address is IPV4");
                }
                else 
                    System.out.println("Ip address is IPV6");   
            }
    
                    catch(UnknownHostException ex)
                    {
                        System.out.println("error:"+ex);
                    }
    
        }
    
    }
    