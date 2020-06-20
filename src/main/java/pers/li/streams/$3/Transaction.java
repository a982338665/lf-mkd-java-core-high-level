package pers.li.streams.$3;

public class Transaction implements Comparable<Transaction> {
    int id;
    Integer value;
    String type;

    public Transaction(int id, int value, String type) {
        super();
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return id + "+" + type + "+" + value;
    }

    @Override
    public int hashCode() {
        return id + value + type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Transaction obj1 = (Transaction) obj;
        if (this.id == obj1.id
                && this.value == obj1.value && this.type.equals(obj1.type)) {
            return true;
        } else {
            return false;
        }
//        return super.equals(obj);
    }

    @Override
    public int compareTo(Transaction transaction) {
        return this.value - transaction.value;
    }
}
