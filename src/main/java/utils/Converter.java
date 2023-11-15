package utils;

public class Converter {

    public static String[] splitByDelimiter(String input, String delimiter){
        return input.split(delimiter);
    }

    public static int stringToInteger(String input){
        return Integer.parseInt(input);
    }
    public static String IntegerToString(int input){ return String.valueOf(input);}
}
