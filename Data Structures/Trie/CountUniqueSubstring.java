public class CountUniqueSubstring extends Trie {
    public static int  countUniqueSubstring(String s) {
        for(int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            Trie.insert(suffix);
        }
        return Trie.countNodes(Trie.root);
    }
    public static void main(String[] args) {
        System.out.println(CountUniqueSubstring.countUniqueSubstring("apple"));
    }
}
