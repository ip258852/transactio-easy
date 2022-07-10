package org.example.model.query;

import org.example.model.enums.TransactionStatus;
import org.example.model.enums.TransactionType;
import org.example.model.req.TransactionSearchReq;

public class TransactionQuery {

    private String txId;
    private Integer fromAccountNumber;
    private TransactionType type;
    private TransactionStatus status;
    private Integer limit;
    private Integer offset;

    public TransactionQuery() {
    }

    public TransactionQuery(TransactionSearchReq req) {
        this.txId = req.getTxId();
        this.fromAccountNumber = req.getFromAccountNumber();
        this.type = req.getType();
        this.status = req.getStatus();
        this.limit = req.getLimit();
        this.offset = req.getOffset();
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Integer getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Integer fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public int getLimit() {
        return limit;
    }

    public void setCount(int count) {
        this.limit = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
