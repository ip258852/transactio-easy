package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.model.po.TransactionPo;
import org.example.model.query.TransactionQuery;

import java.util.List;

@Mapper
public interface TransactionLogMapper {

    @Select("<script>" +
            "select t.* from " +
            "public.\"user\" u left join transaction_log t on u.account_number  = t.from_account_number " +
            "where from_account_number = #{fromAccountNumber} " +
            " <if test = \"txId != null\">" +
            "   and t.tx_id = #{txId}" +
            " </if>"+
            " <if test = \"type != null\">" +
            "   and t.transaction_type = #{type}" +
            " </if>"+
            " <if test = \"status != null\">" +
            "   and t.status = #{status}" +
            " </if>"+
            "offset #{offset} limit #{limit};" +
            "</script>")
    @Results(value = {
            @Result(property = "txId",column = "tx_id"),
            @Result(property = "fromUsername",column = "from_user_name"),
            @Result(property = "toUserName",column = "to_user_name"),
            @Result(property = "fromAccountNumber",column = "from_account_number"),
            @Result(property = "toAccountNumber",column = "to_account_number"),
            @Result(property = "transactionType",column = "transaction_type"),
    })
    List<TransactionPo> search(TransactionQuery query);
}