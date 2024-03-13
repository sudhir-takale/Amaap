package org.amaap.task.creditcard.transactions;

import org.amaap.task.creditcard.domain.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import static org.amaap.task.creditcard.domain.Customer.transactions;

public class ProcessTransactions {
    private Customer customer;

    ProcessTransactions(Customer customer) {
        this.customer = customer;
    }

    public List<Transaction> getAllTransactions() {

        return transactions;
    }


    public int getTotalAmountSpentOnCurrentMonth() {

        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);

        LocalDate lastDayOfMonth = firstDayOfMonth.plus(Period.ofMonths(1)).minusDays(1);

        int totalAmount = transactions.stream()
                .filter(transaction ->
                        !transaction.getDateOfTransaction().isBefore(firstDayOfMonth) &&
                                !transaction.getDateOfTransaction().isAfter(lastDayOfMonth))
                .mapToInt(Transaction::getAmount)
                .sum();

        return totalAmount;
    }

    public int getTotalAmountSpentOnLastMonth() {
        LocalDate currentDate = LocalDate.now();

        LocalDate firstDayOfLastMonth = currentDate.minus(Period.ofMonths(1)).withDayOfMonth(1);

        LocalDate lastDayOfLastMonth = currentDate.minus(Period.ofMonths(1));

        int totalAmount = transactions.stream()
                .filter(transaction ->
                        !transaction.getDateOfTransaction().isBefore(firstDayOfLastMonth) &&
                                !transaction.getDateOfTransaction().isAfter(lastDayOfLastMonth))
                .mapToInt(Transaction::getAmount)
                .sum();

        return totalAmount;
    }
    public List<Transaction> getCurrrentMonthTransactions() {
        return transactions.stream().filter((x) -> x.getDateOfTransaction().getMonth() ==
                LocalDate.now().getMonth()).collect(Collectors.toList());
    }
    public List<Transaction> getTransactionsOfLastMonth() {
        return transactions.stream().filter((x) -> x.getDateOfTransaction().getMonth()
                        == LocalDate.now().minusMonths(1).getMonth()).
                collect(Collectors.toList());
    }
}

