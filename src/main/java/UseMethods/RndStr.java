package UseMethods;

import java.util.Random;

public class RndStr{
    public static void main(String[] args) throws InterruptedException {
        System.out.println(generateRndStr());
        String emailGen = generateRndStr() + "@gmail.com";
        System.out.println(emailGen);
        //Thread.sleep(5);
    }

    public static String generateRndStr() {
        String useChars = "abczxefb0134";
        StringBuilder rstr = new StringBuilder();
        Random rnd = new Random();

        while (rstr.length()<9){
            int index = (int)(rnd.nextFloat()*useChars.length());
            rstr.append(useChars.charAt(index));
        }
        String newStr = rstr.toString();
        return newStr;
    }
}
