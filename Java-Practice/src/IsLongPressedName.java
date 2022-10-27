import java.util.Arrays;
import java.util.HashMap;


class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {

        int position = -1;
        for(int i = 0 ; i< name.length(); i++){
            Boolean charMatched = false;
            for (int j = position + 1 ; j < typed.length(); j++){
                if(name.charAt(i) == typed.charAt(j)){
                    charMatched = true;
                    position = j;
                    break;
                }
            }

            if(!charMatched){
                return false;
            }
        }
        
        int i = position;
        while(i != typed.length()){
            if(typed.charAt(position) != typed.charAt(i)){
                return false;
            }
             i = i + 1;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String name = "alex", typed = "aaleex";


        System.out.println(new IsLongPressedName().isLongPressedName(name, typed));
    }
}