package com.n27.stats;

import com.n27.stats.dto.TransactionStorage;
import com.n27.stats.resource.StatisticResource;
import com.n27.stats.resource.TransactionResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

public class BankApp extends Application<Configuration> {

    private static Logger LOGGER = LoggerFactory.getLogger(BankApp.class);

    public static void main(String[] args) {
        try {
            new BankApp().run(args);
        } catch (Exception e) {
            LOGGER.error("App exception occurred {}", e.getMessage());
        }
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

        TransactionStorage transactionStorage
                = new TransactionStorage(new TreeMap<>());

        environment.jersey().register(new StatisticResource(transactionStorage));

        environment.jersey().register(new TransactionResource(transactionStorage));
    }
}
