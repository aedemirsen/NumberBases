package com.example.aed.numberbases;


/**
 * Created by aed on 29.10.2015.
 */
public class BaseConverter {

    public int binaryToDecimal(String binaryS){
        long binary = Long.parseLong(binaryS);
        int decimal = 0;
        long rem, div = binary;
        int round = Mathematic.round(binary);
        for (int i = 0; i < round; i++ ){
            rem = div % 10;
            div = div / 10;
            decimal += Mathematic.power(2,i)*rem;
        }
        return decimal;
    }

    public int binaryToOctal(String binaryS){
        String octalS = "";
        String[] groups = Mathematic.threeBitsGroups(binaryS);
        for (int i = 0; i < groups.length; i++){
            octalS = octalS.concat(binaryToDecimalS(groups[i]));
        }
        int octal = Integer.parseInt(octalS);
        return octal;
    }

    public String binaryToHexaDecimal(String binaryS){
        String hexaDec = "";
        String[] groups = Mathematic.fourBitsGroups(binaryS);
        for (int i = 0; i < groups.length; i++){
            hexaDec = hexaDec.concat(binaryToHexaDecimalS(groups[i]));
        }
        Mathematic.cleanFromZeros(hexaDec);
        return hexaDec;
    }



    public String binaryToDecimalS(String binaryS){
        int binary = Integer.parseInt(binaryS);
        int decimal = 0;
        String decimalS = "";
        int rem, div = binary;
        int round = Mathematic.round(binary);
        for (int i = 0; i < round; i++ ){
            rem = div % 10;
            div = div / 10;
            decimal += Mathematic.power(2,i)*rem;
        }
        decimalS = decimal+"";
        return decimalS;
    }

    public String binaryToHexaDecimalS(String binaryS){
        int binary = Integer.parseInt(binaryS);
        int hexDecimal = 0;
        String hexDecimalS = "";
        int rem, div = binary;
        int round = Mathematic.round(binary);
        for (int i = 0; i < round; i++ ){
            rem = div % 10;
            div = div / 10;
            hexDecimal += Mathematic.power(2,i)*rem;
        }
        switch (hexDecimal){
            case 10 : hexDecimalS = "A";break;
            case 11 : hexDecimalS = "B";break;
            case 12 : hexDecimalS = "C";break;
            case 13 : hexDecimalS = "D";break;
            case 14 : hexDecimalS = "E";break;
            case 15 : hexDecimalS = "F";break;
            default : hexDecimalS = hexDecimal+"";break;
        }
        return hexDecimalS;
    }


    public String decimalToBinary(long dec){
        long rem ;
        String reversed = "";
        long div = dec;
        while(div != 0){
            rem = div % 2;
            reversed = reversed.concat(rem+"");
            div = div / 2;
        }
        reversed = Mathematic.reverse(reversed);
        return reversed;
    }


    public int decimalToOctal(int dec){
        int decimal,rem = 0;
        String reversed = "";
        int div = dec;
        while(div != 0){
            rem = div % 8;
            reversed = reversed.concat(rem+"");
            div = div / 8;
        }
        reversed = Mathematic.reverse(reversed);
        decimal = Integer.parseInt(reversed);
        return decimal;
    }

    public String decimalToHexadecimal(int dec){
        int rem ;
        String reversed = "";
        String remL;
        int div = dec;
        while(div != 0){
            rem = div % 16;
            switch (rem){
                case 10 : remL = "A";break;
                case 11 : remL = "B";break;
                case 12 : remL = "C";break;
                case 13 : remL = "D";break;
                case 14 : remL = "E";break;
                case 15 : remL = "F";break;
                default : remL = rem+"";break;
            }
            reversed = reversed.concat(remL+"");
            div = div / 16;
        }
        reversed = Mathematic.reverse(reversed);
        return reversed;
    }

    public String octalToBinary(int octal){
        String binary = decimalToBinary(octalToDecimal(octal));
        return binary;
    }

    public int octalToDecimal(int octal){
        int decimal = 0;
        int rem, div = octal;
        int round = Mathematic.round(octal);
        for (int i = 0; i < round; i++ ){
            rem = div % 10;
            div = div / 10;
            decimal += Mathematic.power(8,i)*rem;
        }
        return decimal;
    }

    public String octalToHexadecimal(int octal){
        String hex;
        hex = decimalToHexadecimal(octalToDecimal(octal));
        return hex;
    }

    public int hexaToDecimal(String hex){
        int decimal = 0;
        int num;
        int j = 0;
        for (int i = hex.length()-1; i >= 0; i--,j++){
            if(hex.charAt(i) == 'A'||hex.charAt(i) == 'B'||hex.charAt(i) == 'C' ||
               hex.charAt(i) == 'D'||hex.charAt(i) == 'E'||hex.charAt(i) == 'F' ){
                num = whichNum(hex.charAt(i));
            }else{
                num = hex.charAt(i);
            }
            decimal += Mathematic.power(16,j)*num;
        }
        return decimal;
    }

    public int hexaToOctal(String hex){
        int octal = 0;
        octal = decimalToOctal(hexaToDecimal(hex));
        return octal;
    }

    public String hexaToBinary(String hex){
        String binary = "";
        binary = decimalToBinary(hexaToDecimal(hex));
        return binary;
    }

    int whichNum(char c){
        int num = 0;
        switch (c){
            case 'A' : num = 10;break;
            case 'B' : num = 11;break;
            case 'C' : num = 12;break;
            case 'D' : num = 13;break;
            case 'E' : num = 14;break;
            case 'F' : num = 15;break;
            default  : num = 0;break;
        }
        return num;
    }









}
