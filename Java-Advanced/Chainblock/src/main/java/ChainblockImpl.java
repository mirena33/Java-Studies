import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new HashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (!this.contains(transaction)) {
            this.transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        } else {
            this.transactions.get(id).setStatus(newStatus);
        }
    }

    public void removeTransactionById(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        } else {
            this.transactions.remove(id);
        }
    }

    public Transaction getById(int id) {

        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        } else {
            return this.transactions.get(id);
        }
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions =
                this.transactions.
                        entrySet().
                        stream().
                        filter(entry -> entry.getValue().getStatus().equals(status))
                        .map(Map.Entry::getValue)
                        .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                        .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Iterable<Transaction> transactions = this.getByTransactionStatus(status);

        List<String> senders = new ArrayList<>();

        for (Transaction transaction : transactions) {
            senders.add(transaction.getFrom());
        }
        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        Iterable<Transaction> transactions = this.getByTransactionStatus(status);

        List<String> receivers = new ArrayList<>();

        for (Transaction transaction : transactions) {
            receivers.add(transaction.getTo());
        }
        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactions
                .values()
                .stream()
                .sorted((f, s) -> {
                    int comp = Double.compare(s.getAmount(), f.getAmount());
                    if (comp == 0) {
                        comp = f.getId() - s.getId();
                    }
                    return comp;
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
