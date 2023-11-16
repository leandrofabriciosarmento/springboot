create table public.TB_PRODUCTS (
    idProduct uuid default random_uuid() primary key not null,
    name varchar(254) not null,
    unitValue decimal not null
    );

INSERT INTO TB_PRODUCTS (name, unitValue) VALUES ('Coca-Cola', 5.00);
