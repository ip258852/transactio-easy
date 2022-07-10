package com.example.service;

import org.example.App;
import org.example.model.enums.TransactionStatus;
import org.example.model.enums.TransactionType;
import org.example.model.po.TransactionPo;
import org.example.model.query.TransactionQuery;
import org.example.model.req.TransactionSearchReq;
import org.example.repository.TransactionLogRepository;
import org.example.service.TransactionLogService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionLogServiceTest {

    @Autowired
    private TransactionLogService transactionLogService;
    @MockBean
    private TransactionLogRepository transactionLogRepository;

    @Test
    public void giveADummyEntityData_thenSearch_returnResObjIsEqualEntityData(){
        var entity = new TransactionPo(){
            {
                setTxId("tx-12345");
                setFromUsername("123");
                setToUserName("456");
                setFromAccountNumber(123);
                setToAccountNumber(456);
                setAmount(BigDecimal.TEN);
                setTxDate(Timestamp.from(Instant.now()));
                setTransactionType(TransactionType.STOCK);
                setStatus(TransactionStatus.FAIL);
            }
        };

        Mockito.when(transactionLogRepository.FindTransactionLogs(Mockito.any()))
                .thenReturn(List.of(entity));

        var query = new TransactionSearchReq();

        var resList = transactionLogService.GetTransactionLog(query);
        assertThat(resList.size()).isEqualTo(1);

        var res = resList.get(0);
        assertThat(res.getTxId()).isNotBlank();
        assertThat(res.getTxId()).isEqualTo(entity.getTxId());

        assertThat(res.getFromUsername()).isNotBlank();
        assertThat(res.getFromUsername()).isEqualTo(entity.getFromUsername());

        assertThat(res.getToUserName()).isNotBlank();
        assertThat(res.getToUserName()).isEqualTo(entity.getToUserName());

        assertThat(res.getFromAccountNumber()).isNotNull();
        assertThat(res.getFromAccountNumber()).isEqualTo(entity.getFromAccountNumber());

        assertThat(res.getToAccountNumber()).isNotNull();
        assertThat(res.getToAccountNumber()).isEqualTo(entity.getToAccountNumber());

        assertThat(res.getAmount()).isNotNull();
        assertThat(res.getAmount()).isEqualTo(entity.getAmount());

        assertThat(res.getMemo()).isBlank();

        assertThat(res.getTxDate()).isNotNull();
        assertThat(res.getTxDate()).isEqualTo(entity.getTxDate());

        assertThat(res.getTransactionType()).isNotNull();
        assertThat(res.getTransactionType()).isEqualTo(entity.getTransactionType());

        assertThat(res.getStatus()).isNotNull();
        assertThat(res.getStatus()).isEqualTo(entity.getStatus());

    }

    @Test
    public void giveThreeEntityData_thenSearch_returnCntIsEqualEntityDataSize() {

        var exceptResList = List.of(
                new TransactionPo(),
                new TransactionPo(),
                new TransactionPo()
        );

        Mockito.when(transactionLogRepository.FindTransactionLogs(Mockito.any()))
                .thenReturn(exceptResList);

        var query = new TransactionSearchReq();

        var res = transactionLogService.GetTransactionLog(query);

        assertThat(res.size()).isEqualTo(exceptResList.size());
    }

    @Test
    public void giveNoneEntityData_thenSearch_returnCntIsEqualZero() {

        Mockito.when(transactionLogRepository.FindTransactionLogs(Mockito.any()))
                .thenReturn(List.of());

        var query = new TransactionSearchReq();

        var res = transactionLogService.GetTransactionLog(query);

        assertThat(res.size()).isZero();
    }
}
