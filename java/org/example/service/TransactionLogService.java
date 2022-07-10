package org.example.service;

import org.example.model.po.TransactionPo;
import org.example.model.query.TransactionQuery;
import org.example.model.req.TransactionSearchReq;
import org.example.model.res.TransactionRes;
import org.example.repository.TransactionLogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionLogService {

    @Autowired
    private TransactionLogRepository transactionLogRepository;

    public List<TransactionRes> GetTransactionLog(TransactionSearchReq req) {
        var query = new TransactionQuery(req);
        var poList = transactionLogRepository.FindTransactionLogs(query);
        return poList.stream().map(po -> convert(po)).toList();
    }

    private TransactionRes convert(TransactionPo po){
        var res = new TransactionRes();
        BeanUtils.copyProperties(po, res);
        return res;
    }
}
