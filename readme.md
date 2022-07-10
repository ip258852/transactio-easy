## Introduction
交易查詢-Easy

## Request
```
{ 
    "txId": "tx-12345",
    "fromAccountNumber": 123,
    "type": "STOCK",
    "status": "SUCCESS",
    "offset": 0,
    "limit": 50
}
```

## Request Explain
- txId : 選填,字串,格式 tx-/d{5}
- fromAccountNumber : 必填,數字
- type : 選填,字串,交易種類 [STOCK,FUTURES_CONTRACT]
- status : 選填,字串,交易狀態 [INIT,SUCCESS,FAIL]
- offset : 分頁
- limit : 分頁數量

## Response
```
[
    {
        "txId": "tx-12345",
        "fromUsername": "123",
        "toUserName": "456",
        "fromAccountNumber": 123,
        "toAccountNumber": 456,
        "amount": 50,
        "memo": null,
        "txDate": "2022-07-10T07:06:56.281+00:00",
        "transactionType": "STOCK",
        "status": "SUCCESS"
    },
    {
        "txId": "tx-12346",
        "fromUsername": "123",
        "toUserName": "456",
        "fromAccountNumber": 123,
        "toAccountNumber": 456,
        "amount": 34,
        "memo": null,
        "txDate": "2022-07-10T08:38:01.288+00:00",
        "transactionType": "FUTURES_CONTRACT",
        "status": "FAIL"
    }
]
```

## 查詢

```
curl --location --request GET '127.0.0.1:8080/transactionLog?txId=tx-12345&fromAccountNumber=123&type=STOCK&status=SUCCESS&offset=0&limit=50' \
--header 'Content-Type: application/json'
```

## 查詢最低參數請求

```
curl --location --request GET '127.0.0.1:8080/transactionLog?fromAccountNumber=123&offset=0&limit=50' \
--header 'Content-Type: application/json'
```