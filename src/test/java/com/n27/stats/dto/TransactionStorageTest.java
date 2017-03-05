package com.n27.stats.dto;

import com.n27.stats.model.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.TreeMap;

/**
 * Created by sinan on 06.03.2017.
 */
public class TransactionStorageTest {

    private TransactionStorage transactionStorage
            = new TransactionStorage(new TreeMap<>());

    @Before
    public void init() {

        for (long i = 0; i <= 60; i++) {

            transactionStorage.putIfAbsent(i, new Transaction(i, i));

        }

    }

    @Test
    public void findBetweenTest() {

        Collection<Transaction> between = transactionStorage.findBetween(30L, 61L);

        assert between.size() == 31;
    }
}
