public class LongestWordWithAllPrefixes extends Trie {
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder current) {
        if(root == null) {
            return;
        }
        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].endOfWord == true) {
                current.append((char)(i + 'a'));
                if(current.length() > ans.length()) {
                    ans = current.toString();
                }
                longestWord(root.children[i], current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        String[] words = {"a", "banana", "apple", "appl", "ap", "app", "apply"};
        for(String word : words) {
            Trie.insert(word);
        }
        longestWord(Trie.root, new StringBuilder(""));
        System.out.println(ans);
    }
}
