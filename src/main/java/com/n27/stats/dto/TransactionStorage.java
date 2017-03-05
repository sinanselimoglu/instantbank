package com.n27.stats.dto;

import com.n27.stats.model.Transaction;

import java.util.Collection;
import java.util.SortedMap;

/**
 * Keeps transaction data
 * ordered by SortedMap Key value.
 */
public class TransactionStorage {

    private SortedMap<Long, Transaction> transactionTreeMap;

    public TransactionStorage(SortedMap<Long, Transaction> transactionTreeMap) {
        this.transactionTreeMap = transactionTreeMap;
    }

    public synchronized void putIfAbsent(Long timestamp, Transaction transaction) {
        transactionTreeMap.putIfAbsent(timestamp, transaction);
    }

    /**
     * Finds collection of transactions between two given parameters
     * @param from Include this value
     * @param to exclude this value
     * @return
     */
    public Collection<Transaction> findBetween(Long from, Long to) {
        return transactionTreeMap.subMap(from,to).values();
    }

}
