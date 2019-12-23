package pers.li.streams.$1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 从一系列订单里挑选出想要的订单
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(1, 100, "batch"));
        transactions.add(new Transaction(3, 80, "grocery"));
        transactions.add(new Transaction(6, 120, "grocery"));
        transactions.add(new Transaction(7, 40, "batch"));
        transactions.add(new Transaction(10, 50, "grocery"));

        // 采用传统方法
        traditionalMethod(transactions);
        streamMethod(transactions);
    }

    public static void traditionalMethod(List<Transaction> transactions) {
        // 过滤保留type = "grocery"的记录
        List<Transaction> groceryTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType().equals("grocery")) {
                groceryTransactions.add(t);
            }
        }

        // 根据value对符合的记录排序,从高到低
        Collections.sort(groceryTransactions, new Comparator<Transaction>() {
            public int compare(Transaction t1, Transaction t2) {
                return t2.getValue().compareTo(t1.getValue());
            }
        });

        // 获取记录中的id字段
        List<Integer> transactionIds = new ArrayList<>();
        for (Transaction t : groceryTransactions) {
            transactionIds.add(t.getId());
        }

        // 输出结果
        transactionIds.forEach(System.out::println);
    }

    public static void streamMethod(List<Transaction> transactions) {
        transactions.stream()
                //过滤类型为 type=grocery的数据
				.filter(t -> t.getType().equals("grocery"))
				//降序排列，value
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
				//仅取出订单编号值得流
                .map(Transaction::getId)
				//将流换为集合list
                .collect(Collectors.toList())
				//打印输出
                .forEach(System.out::println);
    }
}

class Transaction {
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

}
