package org.example.model.req;

import org.example.model.enums.TransactionStatus;
import org.example.model.enums.TransactionType;

import javax.validation.constraints.NotNull;

public class TransactionSearchReq extends BaseSearchReq {

    private String txId;
    private Integer fromAccountNumber;
    private TransactionType type;
    private TransactionStatus status;

    public TransactionSearchReq() {
    }

    public String getTxId() {
        return txId;
    }

    public Integer getFromAccountNumber() {
        return fromAccountNumber;
    }

    public TransactionType getType() {
        return type;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public void setFromAccountNumber(Integer fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
