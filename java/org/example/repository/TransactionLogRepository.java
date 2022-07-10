package org.example.repository;

import org.example.mapper.TransactionLogMapper;
import org.example.model.po.TransactionPo;
import org.example.model.query.TransactionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class TransactionLogRepository {

    @Autowired
    private TransactionLogMapper transactionLogMapper;

    public List<TransactionPo> FindTransactionLogs(TransactionQuery query) {
        return transactionLogMapper.search(query);
    }
}
