package com.example.aed.numberbases;

/**
 * Created by aed on 27.10.2015.
 */
public class Mathematic {

    public static void main(String[] args) {
       // System.out.println(round(56776));
        //System.out.println(power(3,3));
    }

    static int round(long number){
        int round = 1;
        while(number / 10 != 0){
            round++;
            number /= 10;
        }
        return round;
    }



    static long power(int base,int pow){
        long result = 1;
        for(int i = 0; i < pow; i++){
            result *= base;
        }
        return result;
    }

    static String[] threeBitsGroups(String binaryS){
        if(binaryS.length() % 3 == 2){
            binaryS = "0".concat(binaryS);
        }
        else if(binaryS.length() % 3 == 1){
            binaryS = "00".concat(binaryS);
        }
        String[] groups = new String[binaryS.length()/3];
        for (int i = 0; i < groups.length; i++){
            groups[i] = binaryS.substring(0,3);
            binaryS = binaryS.substring(3);
        }
        return groups;
    }

    static String[] fourBitsGroups(String binaryS){
        if(binaryS.length() % 4 == 3){
            binaryS = "0".concat(binaryS);
        }
        else if(binaryS.length() % 4 == 2){
            binaryS = "00".concat(binaryS);
        }
        else if(binaryS.length() % 4 == 1){
            binaryS = "000".concat(binaryS);
        }
        String[] groups = new String[binaryS.length()/4];
        for (int i = 0; i < groups.length; i++){
            groups[i] = binaryS.substring(0,4);
            binaryS = binaryS.substring(4);
        }
        return groups;
    }

    static String cleanFromZeros(String string){
        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == '0'){
                string = string.substring(i);
            }else{break;}
        }
        return string;
    }

    static String reverse(String string){
        String reversed = "";
        for (int i = string.length()-1; i >= 0; i--){
            reversed = reversed.concat(string.charAt(i)+"");
        }
        return reversed;
    }


}
