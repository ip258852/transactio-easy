package org.example.controller;

import org.example.model.req.TransactionSearchReq;
import org.example.model.res.TransactionRes;
import org.example.service.TransactionLogService;
import org.example.valid.TransactionLogValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TransactionLogController {

    @Autowired
    private TransactionLogService transactionLogService;
    @Autowired
    private TransactionLogValidator transactionLogValidator;

    @InitBinder()
    public void InitBinder(WebDataBinder binder){
        binder.setValidator(transactionLogValidator);
    }

    @GetMapping("/transactionLog")
    public List<TransactionRes> GetTransactionLog(@Valid TransactionSearchReq req){
        return transactionLogService.GetTransactionLog(req);
    }
}
