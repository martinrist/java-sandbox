CREATE TABLE public.spitter
(
    spitter_id SERIAL PRIMARY KEY,
    firstname VARCHAR(30),
    lastname VARCHAR(30),
    username VARCHAR(16),
    password VARCHAR(25)
)