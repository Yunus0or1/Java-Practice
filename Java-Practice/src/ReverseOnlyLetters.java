import java.util.Arrays;
import java.util.HashMap;


class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {

        int i = 0;
        int j = s.length() - 1;

        StringBuilder result = new StringBuilder(s);
        
        while (i<=j){
            if(Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(j))){
                result.setCharAt(i, s.charAt(j));
                result.setCharAt(j, s.charAt(i));
                i++ ;
                j-- ;
                continue;
            }
            if(!Character.isLetter(s.charAt(i))){
                result.setCharAt(i, s.charAt(i));
                i++ ;
            }
            if(!Character.isLetter(s.charAt(j))){
                result.setCharAt(j, s.charAt(j));
                j-- ;
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String name = "al-ex-";


        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters(name));
    }
}