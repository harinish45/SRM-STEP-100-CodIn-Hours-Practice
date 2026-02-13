import java.util.*;

public class AutocompleteSystem {
    static class TrieNode {
        Map<Character, TrieNode> children;
        int frequency; // End of word frequency, 0 if not end
        String word;

        public TrieNode() {
            children = new HashMap<>();
            frequency = 0;
            word = null;
        }
    }

    private TrieNode root;

    private class SearchResult implements Comparable<SearchResult> {
        String word;
        int frequency;

        public SearchResult(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(SearchResult o) {
            // Higher freq first
            return Integer.compare(o.frequency, this.frequency);
        }
    }

    public AutocompleteSystem() {
        root = new TrieNode();
    }

    public void updateFrequency(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.frequency++;
        curr.word = word;
        System.out.println("updateFrequency(\"" + word + "\") -> Frequency: " + curr.frequency);
    }

    public List<String> search(String prefix) {
        System.out.println("search(\"" + prefix + "\")");
        List<String> results = new ArrayList<>();

        // Navigate to end of prefix
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return results; // Empty
            }
            curr = curr.children.get(c);
        }

        // Collect all words from here
        PriorityQueue<SearchResult> pq = new PriorityQueue<>();
        collectWords(curr, pq);

        // Extract Top 10
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            SearchResult res = pq.poll();
            results.add(res.word + " (" + res.frequency + " searches)");
            count++;
        }
        return results;
    }

    private void collectWords(TrieNode node, PriorityQueue<SearchResult> pq) {
        if (node.frequency > 0) {
            pq.add(new SearchResult(node.word, node.frequency));
        }
        for (TrieNode child : node.children.values()) {
            collectWords(child, pq);
        }
    }

    public static void main(String[] args) {
        AutocompleteSystem auto = new AutocompleteSystem();

        auto.updateFrequency("java tutorial");
        auto.updateFrequency("java tutorial"); // 2
        auto.updateFrequency("javascript");
        auto.updateFrequency("java download");

        List<String> suggestions = auto.search("jav");
        for (int i = 0; i < suggestions.size(); i++) {
            System.out.println((i + 1) + ". " + suggestions.get(i));
        }
    }
}
