class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        Trie trie = new Trie();
        for(String str : strs) {
            trie.insert(str);
        }
        return trie.search(strs[0], strs.length);
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strs = { "flower", "flow", "flight" };
        String ans = obj.longestCommonPrefix(strs);
        System.out.println(ans);
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
    int count = 0;

    public boolean containsKey(char ch) {
        return (children[ch - 'a'] != null);
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void setEnd() {
        endOfWord = true;
    }

    public boolean isEnd() {
        return endOfWord;
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!currNode.containsKey(ch)) {
                currNode.put(ch, new TrieNode());
            }
            currNode.get(ch).count++;
            currNode = currNode.get(ch);
        }
        currNode.setEnd();
    }

    public String search(String word, int n) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(currNode.get(ch) != null && currNode.get(ch).count == n) {
                currNode = currNode.get(ch);
            } else {
                return word.substring(0, i);
            }
        }
        return word;
    }
}
