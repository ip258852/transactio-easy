package com.example.valid;

import org.example.App;
import org.example.model.req.TransactionSearchReq;
import org.example.valid.TransactionLogValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionLogValidatorTest {

    @Autowired
    private TransactionLogValidator transactionLogValidator;

    @Test
    public void giveNoneFromAccountNumberReq_thenValidate_returnHasError() {
        var req = new TransactionSearchReq();
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isTrue();
    }

    @Test
    public void giveAFromAccountNumberReq_thenValidate_returnHasNoError() {
        var req = new TransactionSearchReq();
        req.setFromAccountNumber(666);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isFalse();
    }

    @Test
    public void giveNoneEmptyTxIdAndMatchRegex_thenValidate_returnHasNoError() {
        var req = new TransactionSearchReq();
        req.setTxId("tx-12345");
        req.setFromAccountNumber(666);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isFalse();
    }

    @Test
    public void giveNoneEmptyTxIdAndNoneMatchRegex_thenValidate_returnHasError() {
        var req = new TransactionSearchReq();
        req.setTxId("tx3-12345");
        req.setFromAccountNumber(666);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isTrue();
    }

    @Test
    public void giveNullLimit_thenValidate_returnHasError() {
        var req = new TransactionSearchReq();
        req.setTxId("tx-12345");
        req.setFromAccountNumber(666);
        req.setLimit(null);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isTrue();
    }

    @Test
    public void giveLessLimit_thenValidate_returnHasError() {
        var req = new TransactionSearchReq();
        req.setTxId("tx-12345");
        req.setFromAccountNumber(666);
        req.setLimit(-1);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isTrue();
    }

    @Test
    public void giveOverLimit_thenValidate_returnHasError() {
        var req = new TransactionSearchReq();
        req.setTxId("tx-12345");
        req.setFromAccountNumber(666);
        req.setLimit(51);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isTrue();
    }

    @Test
    public void giveNullOffset_thenValidate_returnHasError() {
        var req = new TransactionSearchReq();
        req.setTxId("tx-12345");
        req.setFromAccountNumber(666);
        req.setOffset(null);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isTrue();
    }

    @Test
    public void giveLessOffset_thenValidate_returnHasError() {
        var req = new TransactionSearchReq();
        req.setTxId("tx-12345");
        req.setFromAccountNumber(666);
        req.setOffset(-1);
        var ex = new BindException("TransactionSearchReq","TransactionSearchReq");
        transactionLogValidator.validate(req, ex);

        assertThat(ex.hasErrors()).isTrue();
    }
}
