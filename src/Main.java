import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        String sourceText = sc.next();
        if(sourceText.contains(","))sourceText = sourceText.replace(',','.');
        System.out.println(sourceText);

            if(!(sourceText.contains("\\.")))sourceText+=".0";
            String firstPart ="";
            if(!sourceText.contains("-")){//дробное число, не включающее минус

                //github?

                String d[] = sourceText.split("\\.");
                String integerPart = d[0];
                String floatPart = d[1];

                String binaryIntegerPart = positiveToBinary(Long.parseLong(integerPart));
                String binaryFloatPart = PositiveFloatBinary(floatPart);
                String sourceTextInBinary = binaryIntegerPart+"."+ binaryFloatPart;
                //System.out.println(sourceTextInBinary);
                int positionOftochka=-2;
                int positionOfEdinica=-2;
                for (int i = 0;;i++){
                    if(sourceTextInBinary.charAt(i) == '0') {}
                    if(sourceTextInBinary.charAt(i) == '1'){if(positionOfEdinica==-2){positionOfEdinica=i;
                        }}
                    if(sourceTextInBinary.charAt(i) == '.'){if(positionOftochka==-2){positionOftochka=i;}}
                    if(positionOftochka!=-2&&positionOfEdinica!=-2)break;

                }
                System.out.println(sourceTextInBinary);
                int ur=0;
                if(positionOftochka-positionOfEdinica>=0){ur = -1;}

                int sdvig = positionOftochka-positionOfEdinica+ur;
                System.out.println(127+sdvig);

                String poriadokOfFloat = new String(new char[8 - positiveToBinary(127+sdvig).length()]).replace("\0", "0") +positiveToBinary(127+sdvig);
                String poriadokOfDouble = new String(new char[11 - positiveToBinary(1023+sdvig).length()]).replace("\0", "0")+positiveToBinary(1023+sdvig);
                //System.out.println(sdvig);
                sourceTextInBinary = binaryIntegerPart+ binaryFloatPart;
                for(int i = 0; ;i++){

                    if(sourceTextInBinary.charAt(i)==0)sourceTextInBinary=sourceTextInBinary.substring(1);
                    else { sourceTextInBinary=sourceTextInBinary.substring(1); break;}
                }
                sourceTextInBinary+=new String(new char[53]).replace("\0", "0");
                System.out.println("Float: 0 "+ poriadokOfFloat + " " + sourceTextInBinary.substring(0,23));
                System.out.println("Double 0 "+ poriadokOfDouble + " " + sourceTextInBinary.substring(0,52) );
            }
            else {//дробное число, включающее минус
                String d[] = sourceText.split("\\.");
                String integerPart = d[0].substring(1);
                String floatPart = d[1];

                String binaryIntegerPart = positiveToBinary(Long.parseLong(integerPart));
                String binaryFloatPart = PositiveFloatBinary(floatPart);
                String sourceTextInBinary = binaryIntegerPart+"."+ binaryFloatPart;
                System.out.println(sourceTextInBinary);
                int positionOftochka=-2;
                int positionOfEdinica=-2;
                for (int i = 0;;i++){
                    if(sourceTextInBinary.charAt(i) == '0') {}
                    if(sourceTextInBinary.charAt(i) == '1'){if(positionOfEdinica==-2){positionOfEdinica=i;
                    }}
                    if(sourceTextInBinary.charAt(i) == '.'){if(positionOftochka==-2){positionOftochka=i;}}
                    if(positionOftochka!=-2&&positionOfEdinica!=-2)break;

                }

                int ur=0;
                if(positionOftochka-positionOfEdinica>=0){ur = -1;}

                int sdvig = positionOftochka-positionOfEdinica+ur;
                System.out.println(127+sdvig);

                String poriadokOfFloat = new String(new char[8 - positiveToBinary(127+sdvig).length()]).replace("\0", "0") +positiveToBinary(127+sdvig);
                String poriadokOfDouble = new String(new char[11 - positiveToBinary(1023+sdvig).length()]).replace("\0", "0")+positiveToBinary(1023+sdvig);

                sourceTextInBinary = binaryIntegerPart+ binaryFloatPart;
                for(int i = 0; ;i++){

                    if(sourceTextInBinary.charAt(i)==0)sourceTextInBinary=sourceTextInBinary.substring(1);
                    else { sourceTextInBinary=sourceTextInBinary.substring(1); break;}
                }
                sourceTextInBinary+=new String(new char[53]).replace("\0", "0");
                System.out.println("Float: 1 "+ poriadokOfFloat + " " + sourceTextInBinary.substring(0,23));
                System.out.println("Double 1 "+ poriadokOfDouble + " " + sourceTextInBinary.substring(0,52) );
            }

        if(!(sourceText.split("\\.")[1].replace("0","")=="")){
        }
        else {
            long i;
            double f;
            sourceText = sourceText.split("\\.")[0];
                i = Long.parseLong(sourceText);
                long i1 = i;
                if (!sourceText.contains("-")) {
                    String c = positiveToBinary(i);

                    positiveOutInteger(i1,c);

                } else {
                    StringBuilder sb = new StringBuilder(sourceText);
                    sb.delete(0, 1);
                    sourceText = sb.toString();
                    i = Long.parseLong(sourceText);

                    String d = "";
                    for (; i >= 2; ) {
                        d += i % 2;
                        i /= 2;
                    }

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


        String binaryFloatPart = "";
         long floatPartinteger =Long.parseLong(floatPart);
         long lenght = (long) Math.pow(10, floatPart.length());

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



        }
        return binaryFloatPart;
    }


    public static String negativeFloatBinary(String floatPart) {

        //System.out.println(floatPart);
        String binaryFloatPart = "";
        long floatPartinteger =Long.parseLong(floatPart);
        long lenght = (long) Math.pow(10, floatPart.length());

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

