import java.util.ArrayList;
import java.util.List;

class AddDigits {
    public int addDigits(int num) {
        String s = Integer.toString(num);

        while(s.length() != 1){
            int sum = 0;
            for (int i = 0 ; i < s.length(); i++){
                sum = sum + Integer.parseInt(Character.toString(s.charAt(i)));
            }

            s = Integer.toString(sum);
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        AddDigits s = new AddDigits();
        s.addDigits(38);
    }
}
