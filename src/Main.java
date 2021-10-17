import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        if(a.contains(","))a = a.replace(',','.');
        System.out.println(a);

            if(!(a.contains("\\.")))a+=".0";
            String firstPart ="";
            if(!a.contains("-")){//дробное число, не включающее минус

                //github?

                String d[] = a.split("\\.");
                String integerPart = d[0];
                String floatPart = d[1];

                String binaryIntegerPart = positiveToBinary(Long.parseLong(integerPart));
                String binaryFloatPart = PositiveFloatBinary(floatPart);
                String aInBinary = binaryIntegerPart+"."+ binaryFloatPart;
                System.out.println(aInBinary);
                int positionOftochka=-2;
                int positionOfEdinica=-2;
                for (int i = 0;;i++){
                    if(aInBinary.charAt(i) == '0') {}
                    if(aInBinary.charAt(i) == '1'){if(positionOfEdinica==-2){positionOfEdinica=i;
                        }}
                    if(aInBinary.charAt(i) == '.'){if(positionOftochka==-2){positionOftochka=i;}}
                    if(positionOftochka!=-2&&positionOfEdinica!=-2)break;

                }
                //System.out.println(aInBinary);
                int ur=0;
                if(positionOftochka-positionOfEdinica>=0){ur = -1;}

                int sdvig = positionOftochka-positionOfEdinica+ur;
                System.out.println(127+sdvig);

                String poriadokOfFloat = new String(new char[8 - positiveToBinary(127+sdvig).length()]).replace("\0", "0") +positiveToBinary(127+sdvig);
                String poriadokOfDouble = new String(new char[11 - positiveToBinary(1023+sdvig).length()]).replace("\0", "0")+positiveToBinary(1023+sdvig);
                //System.out.println(sdvig);
                aInBinary = binaryIntegerPart+ binaryFloatPart;
                for(int i = 0; ;i++){

                    if(aInBinary.charAt(i)==0)aInBinary=aInBinary.substring(1);
                    else { aInBinary=aInBinary.substring(1); break;}
                }
                aInBinary+=new String(new char[53]).replace("\0", "0");
                System.out.println("Float: 0 "+ poriadokOfFloat + " " + aInBinary.substring(0,23));
                System.out.println("Double 0 "+ poriadokOfDouble + " " + aInBinary.substring(0,52) );
            }
            else {//дробное число, включающее минус
                String d[] = a.split("\\.");
                String integerPart = d[0].substring(1);
                String floatPart = d[1];

                String binaryIntegerPart = positiveToBinary(Long.parseLong(integerPart));
                String binaryFloatPart = PositiveFloatBinary(floatPart);
                String aInBinary = binaryIntegerPart+"."+ binaryFloatPart;
                System.out.println(aInBinary);
                int positionOftochka=-2;
                int positionOfEdinica=-2;
                for (int i = 0;;i++){
                    if(aInBinary.charAt(i) == '0') {}
                    if(aInBinary.charAt(i) == '1'){if(positionOfEdinica==-2){positionOfEdinica=i;
                    }}
                    if(aInBinary.charAt(i) == '.'){if(positionOftochka==-2){positionOftochka=i;}}
                    if(positionOftochka!=-2&&positionOfEdinica!=-2)break;

                }
                //System.out.println(aInBinary);
                int ur=0;
                if(positionOftochka-positionOfEdinica>=0){ur = -1;}

                int sdvig = positionOftochka-positionOfEdinica+ur;
                System.out.println(127+sdvig);

                String poriadokOfFloat = new String(new char[8 - positiveToBinary(127+sdvig).length()]).replace("\0", "0") +positiveToBinary(127+sdvig);
                String poriadokOfDouble = new String(new char[11 - positiveToBinary(1023+sdvig).length()]).replace("\0", "0")+positiveToBinary(1023+sdvig);
                //System.out.println(sdvig);
                aInBinary = binaryIntegerPart+ binaryFloatPart;
                for(int i = 0; ;i++){

                    if(aInBinary.charAt(i)==0)aInBinary=aInBinary.substring(1);
                    else { aInBinary=aInBinary.substring(1); break;}
                }
                aInBinary+=new String(new char[53]).replace("\0", "0");
                System.out.println("Float: 1 "+ poriadokOfFloat + " " + aInBinary.substring(0,23));
                System.out.println("Double 1 "+ poriadokOfDouble + " " + aInBinary.substring(0,52) );
            }




            /*if(!a.contains("-")) {
                String d[] = a.split("\\.");
                String integerPart = d[0];
                String floatPart = d[1];
                String binaryIntegerPart = positiveToBinary(Long.parseLong(integerPart));
                floatPart = "0."+floatPart;
                String binaryFloatPart = "";
                float floatPartinteger = Float.parseFloat(floatPart);
                for(;;){
                    if(floatPartinteger==0)break;
                    floatPartinteger*=2;
                    binaryFloatPart+=Float.toString(floatPartinteger).charAt(0);
                    if (Float.toString(floatPartinteger).charAt(0)=='1'){
                        floatPartinteger--;
                    }
                }
                //float out
                int poriadok = binaryIntegerPart.length()-1;
                String fierstPart = "0";
                String secondPart = positiveToBinaryFloat(poriadok, 1);
                String thirdPart = (binaryIntegerPart+binaryFloatPart).substring(1);
                System.out.println(thirdPart);
                //thirdPart = thirdPart.substring(0,23);
                System.out.println(fierstPart+" "+secondPart+" "+thirdPart.substring(0,23) + new String(new char[23 - thirdPart.substring(0,23).length()]).replace("\0", "0"));
                secondPart = positiveToBinaryFloat(poriadok, 0);

                if(thirdPart.length() > 52)thirdPart = thirdPart.substring(0,52);
                System.out.println(fierstPart+" "+secondPart+" "+thirdPart + new String(new char[52 - thirdPart.length()]).replace("\0", "0"));
            }
            else{
                String d[] = a.split("\\.");
                String integerPart = d[0];
                String floatPart = d[1];
                String binaryIntegerPart = negativeToBinary(integerPart);
                floatPart = "0."+floatPart;
                String binaryFloatPart = "";
                float floatPartinteger = Float.parseFloat(floatPart);
                for(;;){
                    if(floatPartinteger==0)break;
                    floatPartinteger*=2;
                    binaryFloatPart+=Float.toString(floatPartinteger).charAt(0);
                    if (Float.toString(floatPartinteger).charAt(0)=='1'){
                        floatPartinteger--;
                    }
                }
                //float out
                int poriadok = binaryIntegerPart.length()-1;
                String fierstPart = "1";
                String secondPart = negativeToBinaryFloat(Long.toString(poriadok), 1);
                String thirdPart = (binaryIntegerPart+binaryFloatPart).substring(1);
                System.out.println(thirdPart);
                //thirdPart = thirdPart.substring(0,23);
                System.out.println(fierstPart+" "+secondPart+" "+thirdPart.substring(0,23) + new String(new char[23 - thirdPart.substring(0,23).length()]).replace("\0", "0"));
                secondPart = negativeToBinaryFloat(Long.toString(poriadok), 0);
                thirdPart = thirdPart.substring(0,52);
                System.out.println(fierstPart+" "+secondPart+" "+thirdPart + new String(new char[52 - thirdPart.length()]).replace("\0", "0"));*/
            //}
        if(!(a.split("\\.")[1].replace("0","")=="")){
        }
        else {
            long i;
            double f;
            a = a.split("\\.")[0];
                i = Long.parseLong(a);
                long i1 = i;
                if (!a.contains("-")) {
                    String c = positiveToBinary(i);

                    positiveOutInteger(i1,c);

                } else {
                    StringBuilder sb = new StringBuilder(a);
                    sb.delete(0, 1);
                    a = sb.toString();
                    i = Long.parseLong(a);

                    String d = "";
                    for (; i >= 2; ) {
                        d += i % 2;
                        i /= 2;
                    }
                    ////

                    ////
                    String c;
                    //переворот строки
                    c = revolution(d);
                    c = "1" + c;


                    c = c.replace('0', '2');
                    c = c.replace('1', '0');
                    c = c.replace('2', '1');

                    String cv = "";
                    //переворот
                    cv = revolution(c);


                    for (int m = 0; m < c.length(); m++) {

                        if (cv.charAt(m) == '0') {
                            cv = cv.replaceFirst("0", "1");

                            cv = cv.replace('2', '0');
                            break;
                        } else {
                            cv = cv.replaceFirst("1", "2");

                        }
                    }

                    //переворот
                    c = revolution(cv);
                    if (i1 < Byte.MIN_VALUE) {
                        if (i1 < Short.MIN_VALUE) {
                            if(i1 < Integer.MIN_VALUE){
                                if(i1 < Long.MIN_VALUE){

                                }
                                else{
                                    System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "1") + c);
                                }
                            }
                            else{
                                System.out.println("Integer: " + new String(new char[32 - c.length()]).replace("\0", "1") + c);
                                System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "1") + c);
                            }
                        }
                        else{
                            System.out.println("Short: " + new String(new char[16 - c.length()]).replace("\0", "1") + c);
                            System.out.println("Integer: " + new String(new char[32 - c.length()]).replace("\0", "1") + c);
                            System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "1") + c);
                        }
                    }
                    else{
                        System.out.println("Byte: " + new String(new char[8 - c.length()]).replace("\0", "1") + c);
                        System.out.println("Short: " + new String(new char[16 - c.length()]).replace("\0", "1") + c);
                        System.out.println("Integer: " + new String(new char[32 - c.length()]).replace("\0", "1") + c);
                        System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "1") + c);
                    }



                }



        }
        System.out.println();
    }

    public static String revolution(String startString){
        String endString = "";
        for(int x = startString.length()-1;x>=0;x--){
            endString+=startString.charAt(x);
        }
        return endString;
    }

    public static String positiveToBinary(long i){
        if(i==0)return "0";
        String d = "";
        for (; i >= 2; ) {
            d += i % 2;
            i /= 2;
        }

        String c;
        //переворот строки
        c = revolution(d);
        c = "1" + c;
        //System.out.println(c);
        return c;
    }

    public static void positiveOutInteger(long i1, String c){
        if (i1 > Byte.MAX_VALUE) {
            if (i1 > Short.MAX_VALUE) {
                if(i1 > Integer.MAX_VALUE){
                    if(i1 > Long.MAX_VALUE){

                    }
                    else{
                        System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "0") + c);
                    }
                }
                else{
                    System.out.println("Integer: " + new String(new char[32 - c.length()]).replace("\0", "0") + c);
                    System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "0") + c);
                }
            }
            else{
                System.out.println("Short: " + new String(new char[16 - c.length()]).replace("\0", "0") + c);
                System.out.println("Integer: " + new String(new char[32 - c.length()]).replace("\0", "0") + c);
                System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "0") + c);
            }
        }
        else{
            System.out.println("Byte: " + new String(new char[8 - c.length()]).replace("\0", "0") + c);
            System.out.println("Short: " + new String(new char[16 - c.length()]).replace("\0", "0") + c);
            System.out.println("Integer: " + new String(new char[32 - c.length()]).replace("\0", "0") + c);
            System.out.println("Long: " + new String(new char[64 - c.length()]).replace("\0", "0") + c);
        }

    }


    public static String negativeToBinary(String a){
        long i = Long.parseLong(a);
        StringBuilder sb = new StringBuilder(a);
        sb.delete(0, 1);
        a = sb.toString();
        i = Long.parseLong(a);

        String d = "";
        for (; i >= 2; ) {
            d += i % 2;
            i /= 2;
        }
        ////

        ////
        String c;
        //переворот строки
        c = revolution(d);
        c = "1" + c;


        c = c.replace('0', '2');
        c = c.replace('1', '0');
        c = c.replace('2', '1');

        String cv = "";
        //переворот
        cv = revolution(c);


        for (int m = 0; m < c.length(); m++) {

            if (cv.charAt(m) == '0') {
                cv = cv.replaceFirst("0", "1");

                cv = cv.replace('2', '0');
                break;
            } else {
                cv = cv.replaceFirst("1", "2");

            }
        }

        //переворот
        c = revolution(cv);
        return c;
    }



    public static String PositiveFloatBinary(String floatPart) {

        //System.out.println(floatPart);
        String binaryFloatPart = "";
         long floatPartinteger =Long.parseLong(floatPart);
         long lenght = (long) Math.pow(10, floatPart.length());
        //System.out.println(floatPartinteger);
        for (int i = 0; ; i++) {
            if (floatPartinteger == 0) break;
            System.out.println(floatPartinteger);
            if(i==60) break;
            floatPartinteger *= 2;

            if(floatPartinteger-lenght <= 0){
                binaryFloatPart += "0";

            }
            else{
                binaryFloatPart += ((floatPartinteger*1.0/lenght+"").charAt(0));floatPartinteger-=lenght;}


            //System.out.println(binaryFloatPart);
        }
        return binaryFloatPart;
    }


    public static String negativeFloatBinary(String floatPart) {

        //System.out.println(floatPart);
        String binaryFloatPart = "";
        long floatPartinteger =Long.parseLong(floatPart);
        long lenght = (long) Math.pow(10, floatPart.length());
        //System.out.println(floatPartinteger);
        for (int i = 0; ; i++) {
            if (floatPartinteger == 0) break;
            System.out.println(floatPartinteger);
            if(i==60) break;
            floatPartinteger *= 2;

            if(floatPartinteger-lenght <= 0){
                binaryFloatPart += "0";

            }
            else{
                binaryFloatPart += ((floatPartinteger*1.0/lenght+"").charAt(0));floatPartinteger-=lenght;}


            //System.out.println(binaryFloatPart);
        }
        String c;
        //переворот строки
        c = revolution(binaryFloatPart);

        c = c.replace('0', '2');
        c = c.replace('1', '0');
        c = c.replace('2', '1');

        String cv = "";
        //переворот
        cv = revolution(c);


        for (int m = 0; m < c.length(); m++) {

            if (cv.charAt(m) == '0') {
                cv = cv.replaceFirst("0", "1");

                cv = cv.replace('2', '0');
                break;
            } else {
                cv = cv.replaceFirst("1", "2");

            }
        }

        //переворот
        c = revolution(cv);
        return c;
    }
}

