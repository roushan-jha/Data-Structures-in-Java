public class Trie {
    static class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            endOfWord = false;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curNode = root;
        for (int j = 0; j < word.length(); j++) {
            int idx = word.charAt(j) - 'a';

            if (curNode.children[idx] == null) {
                curNode.children[idx] = new Node();
            }
            curNode = curNode.children[idx];
        }
        curNode.endOfWord = true;
    }

    public static boolean search(String key) {
        Node currNode = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (currNode.children[idx] == null) {
                return false;
            }
            currNode = currNode.children[idx];
        }
        return currNode.endOfWord;
    }

    public static boolean delete(String word) {
        return delete(root, word, 0);
    }

    private static boolean delete(Node currentNode, String word, int index) {
        if (currentNode == null) {
            return false;
        }

        if (index == word.length()) {
            if (!currentNode.endOfWord) {
                return false;
            }
            currentNode.endOfWord = false;

            return isEmpty(currentNode);
        }

        int idx = word.charAt(index) - 'a';
        boolean shouldDeleteChildNode = delete(currentNode.children[idx], word, index + 1);

        if (shouldDeleteChildNode) {
            currentNode.children[idx] = null;

            return !currentNode.endOfWord && isEmpty(currentNode);
        }

        return false;
    }

    private static boolean isEmpty(Node node) {
        for (Node child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String[] words = {"i", "like", "sam", "samsung", "mobile"};

        for (String word : words) {
            insert(word);
        }

        System.out.println("Search 'sam': " + search("sam"));
        System.out.println("Search 'samsung': " + search("samsung"));
        System.out.println("Search 'mobile': " + search("mobile"));

        delete("samsung");
        System.out.println("Search 'samsung' after delete: " + search("samsung"));
       
        System.out.println("Search 'sam': " + search("sam"));

        System.out.println("Count of nodes: " + countNodes(root));
    }
}
