public class SearchInString {
    public static void main(String[] args) {
        String username = "JavaCode";
        char target = 'f';
        boolean var = Search(username, target);
        System.out.println(var);
    }
    static boolean Search(String s, char target) {
        if(s.length() == 0) {
            return false;
        } 
        for(int i = 0; i < s.length(); i++) {
            if(target == s.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
