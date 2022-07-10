package org.example.valid;

import org.apache.commons.lang3.StringUtils;
import org.example.model.enums.ErrorCode;
import org.example.model.req.TransactionSearchReq;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class TransactionLogValidator extends BaseSearchValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TransactionSearchReq.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var req = (TransactionSearchReq) target;
        Pattern txIdPattern = Pattern.compile("tx-\\d{5}");
        if (StringUtils.isNotBlank(req.getTxId()) && !txIdPattern.matcher(req.getTxId()).matches()) {
            errors.reject(ErrorCode.REQUEST_INVALID.getCode(), "txId is invalid !");
        }

        if (req.getFromAccountNumber() == null) {
            errors.reject(ErrorCode.REQUEST_INVALID.getCode(), "fromAccountNumber is invalid !");
        }

        super.validate(target, errors);
    }
}