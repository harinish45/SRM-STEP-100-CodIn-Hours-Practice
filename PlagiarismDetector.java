import java.util.*;

public class PlagiarismDetector {
    private Map<String, Set<String>> ngramMap;
    private final int N = 5; // 5-grams

    public PlagiarismDetector() {
        ngramMap = new HashMap<>();
        // Pre-populate with some documents
        addDocument("essay_089.txt", "The quick brown fox jumps over the lazy dog and runs away.");
        addDocument("essay_092.txt", "To be or not to be that is the question whether 'tis nobler in the mind.");
    }

    public void addDocument(String docId, String content) {
        List<String> ngrams = generateNgrams(content, N);
        for (String ngram : ngrams) {
            ngramMap.computeIfAbsent(ngram, k -> new HashSet<>()).add(docId);
        }
    }

    private List<String> generateNgrams(String content, int n) {
        List<String> ngrams = new ArrayList<>();
        String[] words = content.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

        if (words.length < n)
            return ngrams;

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j > 0)
                    sb.append(" ");
                sb.append(words[i + j]);
            }
            ngrams.add(sb.toString());
        }
        return ngrams;
    }

    public void analyzeDocument(String docId, String content) {
        System.out.println("analyzeDocument(\"" + docId + "\")");
        List<String> ngrams = generateNgrams(content, N);
        System.out.println("→ Extracted " + ngrams.size() + " n-grams");

        Map<String, Integer> matchCounts = new HashMap<>();
        for (String ngram : ngrams) {
            if (ngramMap.containsKey(ngram)) {
                for (String matchDocId : ngramMap.get(ngram)) {
                    if (!matchDocId.equals(docId)) {
                        matchCounts.put(matchDocId, matchCounts.getOrDefault(matchDocId, 0) + 1);
                    }
                }
            }
        }

        if (matchCounts.isEmpty()) {
            System.out.println("→ No significant matches found.");
            return;
        }

        // Find matches
        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {
            String matchDoc = entry.getKey();
            int count = entry.getValue();
            // Simple similarity calculation: (matches / total_ngrams) * 100
            double similarity = (double) count / ngrams.size() * 100;

            System.out.println("→ Found " + count + " matching n-grams with \"" + matchDoc + "\"");
            System.out.printf("→ Similarity: %.1f%%", similarity);
            if (similarity > 50) {
                System.out.println(" (PLAGIARISM DETECTED)");
            } else {
                System.out.println(" (suspicious)");
            }
        }
    }

    public static void main(String[] args) {
        PlagiarismDetector detector = new PlagiarismDetector();

        // Exact copy of essay_092
        String suspiciousContent = "To be or not to be that is the question whether 'tis nobler in the mind.";
        detector.analyzeDocument("essay_123.txt", suspiciousContent);

        // Partial copy
        String partialContent = "The quick brown fox jumps over the lazy dog but then stops.";
        detector.analyzeDocument("essay_124.txt", partialContent);
    }
}
