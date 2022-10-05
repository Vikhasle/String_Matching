import java.util.List;
import java.util.LinkedList;

class Node {
    Node(char data){
        this.data = data;
    }

    Node find(char c){
        for (Node child : children)
            if(child.data == c)
                return child;
        return null;

    }

    char data;
    List<Node> children = new LinkedList<Node>();
}

class Trie{
    Node root = new Node(' ');

    boolean match(String pattern){
        Node i = root;
        for(int j = 0; j < pattern.length(); j++){
            i = i.find(pattern.charAt(j));
            if(i == null)
                return false;
        }
        return true;
    }

    void add(String s){
        Node i = root;
        for (int j = 0; j < s.length(); j++) {
            Node child = i.find(s.charAt(j));
            if(child == null){
                child = new Node(s.charAt(j));
                i.children.add(child);
                i = child;
            }
        }
    }
}

class TestTrie{
    public static void main(String[] args) {
        Trie test = new Trie();
        test.add("sofa");
        test.add("socrates");
        test.add("alfabet");
        System.out.println(test.match("so"));
        System.out.println(test.match("alfabet"));
        System.out.println(test.match("sol"));
    }
}

