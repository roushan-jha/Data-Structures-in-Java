
public class Trie {
    static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            for(int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curNode = root;
        for(int j = 0; j < word.length(); j++) {
            int idx = word.charAt(j) - 'a';

            if(curNode.children[idx] == null) {
                curNode.children[idx] = new Node();
            }
            curNode = curNode.children[idx];
        }
        curNode.endOfWord = true;
    }

    public static boolean search(String key) {
        Node currNode = root;
        for(int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if(currNode.children[idx] == null) {
                return false;
            }
            if(i == key.length() - 1 && currNode.endOfWord == false) {
                return false;
            }
            currNode = currNode.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile"};

        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("sam"));
        System.out.println(search("mobile"));
        System.out.println(search("sung"));

        System.out.println(countNodes(root));
    }
    
}
