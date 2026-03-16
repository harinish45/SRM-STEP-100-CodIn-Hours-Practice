import java.util.*;

public class TransactionAnalyzer {
    static class Transaction {
        int id;
        int amount;
        String merchant;
        String time; // "HH:MM"

        public Transaction(int id, int amount, String merchant, String time) {
            this.id = id;
            this.amount = amount;
            this.merchant = merchant;
            this.time = time;
        }

        @Override
        public String toString() {
            return "id:" + id;
        }
    }

    private List<Transaction> transactions;

    public TransactionAnalyzer() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(int id, int amount, String merchant, String time) {
        transactions.add(new Transaction(id, amount, merchant, time));
    }

    public List<String> findTwoSum(int target) {
        List<String> results = new ArrayList<>();
        Map<Integer, Transaction> map = new HashMap<>();

        for (Transaction t : transactions) {
            int complement = target - t.amount;
            if (map.containsKey(complement)) {
                Transaction partner = map.get(complement);
                results.add("(" + partner + ", " + t + ")");
            }
            map.put(t.amount, t);
        }
        return results;
    }

    public List<String> detectDuplicates() {
        List<String> duplicates = new ArrayList<>();
        // Key: amount + "|" + merchant, Value: List of Transactions
        Map<String, List<Transaction>> map = new HashMap<>();

        for (Transaction t : transactions) {
            String key = t.amount + "|" + t.merchant;
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
        }

        for (Map.Entry<String, List<Transaction>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                String[] parts = entry.getKey().split("\\|");
                duplicates.add(
                        "{amount:" + parts[0] + ", merchant:\"" + parts[1] + "\", accounts:" + entry.getValue() + "}");
            }
        }
        return duplicates;
    }

    public List<String> findKSum(int k, int target) {
        List<String> results = new ArrayList<>();
        findKSumRecursive(k, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void findKSumRecursive(int k, int target, int start, List<Transaction> current, List<String> results) {
        if (k == 0) {
            if (target == 0) {
                results.add(current.toString());
            }
            return;
        }

        for (int i = start; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            // Optimization: if t.amount > target (assuming positive amounts), skip?
            // Problems didn't specify distinct or positive, assume standard K-Sum
            current.add(t);
            findKSumRecursive(k - 1, target - t.amount, i + 1, current, results);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        TransactionAnalyzer analyzer = new TransactionAnalyzer();
        analyzer.addTransaction(1, 500, "Store A", "10:00");
        analyzer.addTransaction(2, 300, "Store B", "10:15");
        analyzer.addTransaction(3, 200, "Store C", "10:30");

        System.out.println("findTwoSum(target=500) -> " + analyzer.findTwoSum(500));

        analyzer.addTransaction(4, 500, "Store A", "11:00"); // Duplicate of 1
        System.out.println("detectDuplicates() -> " + analyzer.detectDuplicates());

        System.out.println("findKSum(k=3, target=1000) -> " + analyzer.findKSum(3, 1000));
    }
}
