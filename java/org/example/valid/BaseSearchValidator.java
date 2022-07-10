package org.example.valid;

import org.example.model.enums.ErrorCode;
import org.example.model.req.BaseSearchReq;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class BaseSearchValidator implements Validator {

    @Override
    public void validate(Object target, Errors errors) {
        var req = (BaseSearchReq)target;

        if (req.getLimit() == null || req.getLimit() <=0 || req.getLimit() > 50){
            errors.reject(ErrorCode.REQUEST_INVALID.getCode(), "limit is invalid !");
        }

        if (req.getOffset() == null || req.getOffset() <0){
            errors.reject(ErrorCode.REQUEST_INVALID.getCode(), "offset is invalid !");
        }
    }
}
