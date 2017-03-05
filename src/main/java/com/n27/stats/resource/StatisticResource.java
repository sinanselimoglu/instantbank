package com.n27.stats.resource;

import com.n27.stats.dto.TransactionStorage;
import com.n27.stats.function.StatisticReducer;
import com.n27.stats.model.Statistic;
import com.n27.stats.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Collection;

/**
 * Resource for getting statistics about last 60 second.
 */
@Path("statistic")
public class StatisticResource {

    private final static Logger LOGGER = LoggerFactory.getLogger(StatisticResource.class);

    private final static long SECONDS_60 = 60 * 1000;

    private TransactionStorage transactionStorage;

    public StatisticResource(TransactionStorage transactionStorage) {

        this.transactionStorage = transactionStorage;

    }

    /**
     * Returns statistic about last 60 seconds includes max, min, count, sum.
     *
     * @return Statistic
     */
    @GET
    public Statistic get() {

        LOGGER.info("Stats are called.");

        Long now = System.currentTimeMillis() + 1;

        Collection<Transaction> transactions = transactionStorage.findBetween(now - SECONDS_60, now);

        return transactions
                .stream()
                .reduce(new Statistic(0, 0, 0, 0, 0),
                        this::createStatisticFromTransaction,
                        new StatisticReducer()
                );
    }

    private Statistic createStatisticFromTransaction(Statistic statistic, Transaction transaction) {
        statistic.setMax(transaction.getAmount());
        statistic.setMin(transaction.getAmount());
        statistic.setAvg(transaction.getAmount());
        statistic.setSum(transaction.getAmount());
        statistic.setCount(1);
        return statistic;
    }
}
