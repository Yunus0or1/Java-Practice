import java.util.ArrayList;

class Reformat {
    public String reformat(String s) {
        ArrayList<Character> letters = new ArrayList<Character>();
        ArrayList<Character> numbers = new ArrayList<Character>();

        for (int i = 0 ; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                letters.add(s.charAt(i));
            }
            if(Character.isDigit(s.charAt(i))){
                numbers.add(s.charAt(i));
            }
        }

        if(Math.abs(letters.size() - numbers.size()) > 2){
            return "";
        }

        String result = "";

        for(int i =  0; i < letters.size(); i++){
            result = result + letters.get(i);
            result = result + numbers.get(i);
        }


        return result;

    }

    public static void main(String[] args) {
        String s = "covid2019";

        
        System.out.println(new Reformat().reformat(s));
    }
}