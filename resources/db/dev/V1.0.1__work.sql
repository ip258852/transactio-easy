-- public.transaction_log definition

-- Drop table

-- DROP TABLE public.transaction_log;

CREATE TABLE public.transaction_log (
	tx_id varchar NOT NULL,
	from_user_name varchar NOT NULL,
	to_user_name varchar NOT NULL,
	from_account_number int4 NOT NULL,
	to_account_number int4 NOT NULL,
	amount numeric NOT NULL,
	memo varchar NULL,
	txdate timestamptz NOT NULL DEFAULT now(),
	status varchar NOT NULL DEFAULT 'INIT'::character varying,
	transaction_type varchar NOT NULL,
	CONSTRAINT transactionlog_pk PRIMARY KEY (tx_id)
);
CREATE INDEX transactionlog_from_account_number_idx ON public.transaction_log USING btree (from_account_number, status);
CREATE INDEX transactionlog_from_account_number_idx_type ON public.transaction_log USING btree (from_account_number, transaction_type);

-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	user_id varchar NOT NULL,
	"name" varchar NOT NULL,
	"password" varchar NOT NULL,
	account_number int4 NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (user_id)
);
CREATE INDEX user_account_number_idx ON public."user" USING btree (account_number);

INSERT INTO public."user"
(user_id, "name", "password", account_number)
VALUES('123', '123', '123', 123);
INSERT INTO public."user"
(user_id, "name", "password", account_number)
VALUES('456', '456', '456', 456);


INSERT INTO public.transaction_log
(tx_id, from_user_name, to_user_name, from_account_number, to_account_number, amount, memo, txdate, status, transaction_type)
VALUES('tx-12345', '123', '456', 123, 456, 50, NULL, '2022-07-10 15:06:56.281', 'SUCCESS', 'STOCK');
INSERT INTO public.transaction_log
(tx_id, from_user_name, to_user_name, from_account_number, to_account_number, amount, memo, txdate, status, transaction_type)
VALUES('tx-12346', '123', '456', 123, 456, 34, NULL, '2022-07-10 16:38:01.288', 'FAIL', 'FUTURES_CONTRACT');
INSERT INTO public.transaction_log
(tx_id, from_user_name, to_user_name, from_account_number, to_account_number, amount, memo, txdate, status, transaction_type)
VALUES('tx-45678', '456', '123', 456, 123, 50, NULL, '2022-07-10 15:07:50.192', 'INIT', 'STOCK');

