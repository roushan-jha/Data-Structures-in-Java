public class StartsWith extends Trie {
    public static boolean startsWith(String prefix) {
        Node currNode = root;
        for(int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(currNode.children[idx] == null) return false;
            currNode = currNode.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};
        for(String s : words) {
            Trie.insert(s);
        }
        System.out.println(StartsWith.startsWith("wom"));
    }
}
