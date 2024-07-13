public class WordBreakDown extends Trie {
    public static boolean breakDown(String s, String[] wordDict) {
        for(int i = 0; i < wordDict.length; i++) {
            insert(wordDict[i]);
        }

        return breakDown(s);
    }
    
    public static boolean breakDown(String s) {
        if(s.length() == 0) {
            return true;
        }
        for(int i = 1; i <= s.length(); i++) {
            String leftPart = s.substring(0, i);
            String rightPart = s.substring(i, s.length());

            if(search(leftPart) && breakDown(rightPart)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // String[] words = {"i", "like", "sam", "samsung", "mobile"};
        // String s = "ilikesamsung";

        String[] words = {"leet", "code"};
        String s = "leetcode";

        System.out.println(WordBreakDown.breakDown(s, words));
    }
}
