package Demopack;
import org.apache.poi.sl.usermodel.ObjectMetaData;

import java.security.Timestamp;
import java.util.Date;

public class Demotimestamp {
    public static void  main(String[] args) {

           // Date date = new Date();
           // System.out.println(date.toString().replace(" ","_").replace(":","_"));
        //____________________________________________________________

          //System.getProperties().list(System.out);
//        System.out.println(System.getProperty("os.name"));
//        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("java.version"));
//        }
        //print fabonci numbers
  int num1 =0;
  int num2=1;

  for(int i=0;i<=18; i++){
      int newfeb=num1+num2;
      num2=num1;
      num1=newfeb;
      System.out.println(newfeb);

  }
}}
