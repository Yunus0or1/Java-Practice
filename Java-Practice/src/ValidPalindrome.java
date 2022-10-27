import java.util.*;


class ValidPalindrome {
    public boolean isPalindrome(String s) {
        ArrayList<Character> array = new ArrayList<>();
        for (int i = 0 ; i < s.length(); i++){
            Character c = Character.toLowerCase(s.charAt(i));

            if(c>='a' && c<= 'z' || Character.isDigit(c)){
                array.add(c);
            }

        }

        int i = 0;
        int j = array.size() - 1;

        while(i < j){
            if(array.get(i) != array.get(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s ="A man, a plan, a canal: Panama";
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome(s));
    }
}