
import java.util.Scanner;
import java.util.Arrays;



class Main {
    public static String intToRoman(int input){

        String str=""+input;


        String[] dec_1  = new String[]{"1","2","3","4","5","6","7","8","9"};
        String[] roman_1  = new String[]{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};

        String[] dec_2  = new String[]{"1","2","3","4","5","6","7","8","9"};
        String[] roman_2  = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX"};



        switch(str.length()){
            case 1:{
                for (int counter=0;counter<dec_2.length;counter++){
                    if(dec_2[counter].equals(str))return roman_2[counter];
                }
            }
            break;

            case 2:{
                String f=str.substring(0,1);
                String s=str.substring(1,2);


                String output="";
                for (int counter=0;counter<dec_1.length;counter++){
                    if(dec_1[counter].equals(f))output+= roman_1[counter];
                }
                for (int counter=0;counter<dec_2.length;counter++){
                    if(dec_2[counter].equals(s))output+= roman_2[counter];
                }


                return output;
            }



            case 3:return "C";
            default:return "Out range";
        }
        return "Неверное значение.";

    }


    public static String calc(String input) {

        if (input.matches(".*[IVXLC].*[0-9].*") || input.matches(".*[0-9].*[IVXLC].*")) {
            throw new IllegalArgumentException("Неверный формат выражения");
        }


        String[] parts = input.split(" ");
        if (parts.length != 3) throw new IllegalArgumentException("Неверный формат выражения");

        String number1 = parts[0];
        String operator = parts[1];
        String number2 = parts[2];


        if (isNumberValid(number1) && isNumberValid(number2)) {
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);

            int result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Неверный оператор");
            }

            return String.valueOf(result);
        }
        else if(isRomanNumberValid(number1) && isRomanNumberValid(number2)) {
            String[] roman  = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
            int numb_1=0 ;
             int numb_2=0;

            for (int counter=0;counter<roman.length;counter++)if(number1.equals(roman[counter]))numb_1=counter+1;
            for (int counter=0;counter<roman.length;counter++)if(number2.equals(roman[counter]))numb_2=counter+1;

            int result=0;
            switch (operator){
                case "+": result=numb_1+numb_2;break;

                case "-":
                    if (numb_1-numb_2>0)result=numb_1-numb_2;
                    //else throw new ArithmeticException("В римской систеие счисления нет отрицательных чисел и нуля");

                break;

                case "*":result=numb_1*numb_2;break;

                case "/":result=numb_1/numb_2;break;

                default:throw new IllegalArgumentException("Неверный оператор");

            }
            return intToRoman(result);


        }
        return null;

    }

    private static boolean isRomanNumberValid(String number) {
        String[] roman  = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        return Arrays.asList(roman).contains(number);
    }
    private static boolean isNumberValid(String number) {
        try {
            int num = Integer.parseInt(number);
            return num >= 1 && num <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        /* System.out.println("Input : ");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();


        System.out.println("Output:\n" + calc(str));*/
        String[] roman  = new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        for (String counter_0:roman){
            for (String counter_1:roman){
                System.out.println("input : "+counter_0 + " * "+counter_1 + "\n" +"Output:"  );
                System.out.println(calc(counter_0+ " * " +counter_1));
            }
        }



    }
}