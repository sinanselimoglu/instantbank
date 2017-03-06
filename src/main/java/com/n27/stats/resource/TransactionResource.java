package com.n27.stats.resource;

import com.n27.stats.dto.TransactionStorage;
import com.n27.stats.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("transactions")
@Produces("application/json")
@Consumes("application/json")
public class TransactionResource {

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionResource.class);

    private volatile TransactionStorage transactionStorage;

    public TransactionResource(TransactionStorage transactionStorage) {

        this.transactionStorage = transactionStorage;

    }

    @POST
    public Response create(Transaction transaction) {

        LOGGER.info("Transaction : {}", transaction);

        Response response;

        try {

            transactionStorage.putIfAbsent(transaction.getTimestamp(), transaction);

            response = Response.status(201).build();

        } catch (Exception e) {

            LOGGER.error("Exception occurred while creating transaction", e);

            response = Response.status(500).entity(e.getMessage()).build();
        }

        return response;

    }


}
