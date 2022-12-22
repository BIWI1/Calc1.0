import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("hello, i'm calc");
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        System.out.println(calc(line));
        System.out.println("Goodbye my friend");
    }
    public static String calc(String input){
        String [] symbols = input.split(" ");
        if (symbols.length != 3){
            throw new InputMismatchException("incorrect equation input! example: 6 * 6");
        }
        int res = 0;
        if(Romani.isRoma(symbols[0]) && Romani.isRoma(symbols[2])){
            if(symbols[0].equals("0") || symbols[2].equals("0")){
                throw new InputMismatchException("you can't use zero");
            }
            RomanNum x1 = RomanNum.valueOf(symbols[0]);
            RomanNum y1 = RomanNum.valueOf(symbols[2]);
            int x = x1.getRoma();
            int y = y1.getRoma();
            if(x<1 || x>10 || y<1 || y>10){
                throw new InputMismatchException("enter a number from 1 to 10");
            }
            String oper = symbols[1];
            switch (oper) {
                case "+":
                    res = x + y;
                    break;
                case "-":
                    res = x - y;
                    break;
                case "*":
                    res = x * y;
                    break;
                case "/":
                    res = x / y;
                    break;
            }
            if(res <= 0){
                throw new InputMismatchException("you can't get zero or less than zero");
            }
            String result = inRoma(res);
            return result;
        } else if(!Romani.isRoma(symbols[0]) && !Romani.isRoma(symbols[2])){
            int x = Integer.parseInt(symbols[0]);
            int y = Integer.parseInt(symbols[2]);
            if(x<1 || x>10 || y<1 || y>10){
                throw new InputMismatchException("enter a number from 1 to 10");
            }
            String oper = symbols[1];
            switch (oper) {
                case "+":
                    res = x + y;
                    break;
                case "-":
                    res = x - y;
                    break;
                case "*":
                    res = x * y;
                    break;
                case "/":
                    res = x / y;
                    break;
            }
            return Integer.toString(res);
        } else {
            throw new InputMismatchException("numbers are in different systems of calculus");
        }
    }
    public static String inRoma (int res){
        String [] inRoma = {"0", "I", "II", "III",
                "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII",
                "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI",
                "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = inRoma[res];
        return s;
    }
}
enum RomanNum {
    C(100), XCIX(99), XCVIII(98), XCVII(97), XCVI(96), XCV(95),XCIV(94), XCIII(93),
    XCII(92), XCI(91), XC(90), LXXXIX(89), LXXXVIII(88), LXXXVII(87), LXXXVI(86),
    LXXXV(85), LXXXIV(84), LXXXIII(83), LXXXII(82), LXXXI(81), LXXX(80), LXXIX(79),
    LXXVIII(78), LXXVII(77), LXXVI(76), LXXV(75), LXXIV(74), LXXIII(73), LXXII(72),
    LXXI(71), LXX(70), LXIX(69), LXVIII(68), LXVII(67), LXVI(66), LXV(65), LXIV(64),
    LXIII(63), LXII(62), LXI(61), LX(60), LIX(59), LVIII(58), LVII(57), LVI(56), LV(55),
    LIV(54), LIII(53),LII(52), LI(51), L(50), XLIX(49), XLVIII(48), XLVII(47), XLVI(46),
    XLV(45), XLIV(44),XLIII(43), XLII(42), XLI(41), XL(40), XXXIX(39), XXXVIII(38),
    XXXVII(37), XXXVI(36), XXXV(35), XXXIV(34), XXXIII(33), XXXII(32), XXXI(31), XXX(30),
    XXIX(29), XXVIII(28), XXVII(27), XXVI(26), XXV(25), XXIV(24), XXIII(23), XXII(22),
    XXI(21), XX(20), XIX(19), XVIII(18), XVII(17), XVI(16), XV(15), XIV(14), XIII(13),
    XII(12), XI(11), X(10), IX(9), VIII(8), VII(7), VI(6), V(5), IV(4), III(3), II(2), I(1);
    private int roma;
    RomanNum (int roma){
        this.roma = roma;
    }
    public int getRoma() {
        return roma;
    }
}
class Romani {
    static String[] romaArray = {"0", "I", "II", "III",
            "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
            "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII",
            "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI",
            "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    public static boolean isRoma (String num){
        for (int i = 0; i < romaArray.length; i++){
            if(num.equals(romaArray[i])) {
                return true;
            }
        }
        return false;
    }
}
