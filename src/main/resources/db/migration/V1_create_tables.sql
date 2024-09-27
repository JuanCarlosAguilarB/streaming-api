
CREATE TABLE public.user_entity (
    user_id uuid NOT NULL,
    email varchar(255) NULL,
    "password" varchar(255) NULL,
    CONSTRAINT user_entity_pkey PRIMARY KEY (user_id)
);

CREATE TABLE public.catalog_item_type_entity (
     id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
     description varchar(255) NULL,
     "name" varchar(255) NULL,
     CONSTRAINT catalog_item_type_entity_pkey PRIMARY KEY (id)
);


CREATE TABLE public.catalog_item_genre_entity (
      id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
      description varchar(255) NULL,
      "name" varchar(255) NULL,
      CONSTRAINT catalog_item_genre_entity_pkey PRIMARY KEY (id)
);



CREATE TABLE public.catalog_item_entity (
    id uuid NOT NULL,
    average_score float8 NULL,
    creation_order int8 NULL,
    description varchar(255) NULL,
    genre_id int4 NOT NULL,
    image_url varchar(255) NULL,
    title varchar(255) NULL,
    type_id int4 NOT NULL,
    "views" int4 NULL,
    CONSTRAINT catalog_item_entity_pkey PRIMARY KEY (id)
);


-- public.catalog_item_entity foreign keys

ALTER TABLE public.catalog_item_entity ADD CONSTRAINT fkirxamyqdisnbtebim9q6y27fo FOREIGN KEY (genre_id) REFERENCES public.catalog_item_genre_entity(id);
ALTER TABLE public.catalog_item_entity ADD CONSTRAINT fknyhvea3v9re2q9afn6rtaca6c FOREIGN KEY (type_id) REFERENCES public.catalog_item_type_entity(id);

-----
CREATE TABLE public.user_catalog_item_views_entity (
       id uuid NOT NULL,
       catalog_item_id uuid NOT NULL,
       user_id uuid NOT NULL,
       viewed_at timestamp(6) NOT NULL,
       CONSTRAINT user_catalog_item_views_entity_pkey PRIMARY KEY (id),
       CONSTRAINT fk3ckm24xfs07t57yogs1d8evm0 FOREIGN KEY (user_id) REFERENCES public.user_entity(user_id),
       CONSTRAINT fko5ep73r9nyk1j0ceu758xgra3 FOREIGN KEY (catalog_item_id) REFERENCES public.catalog_item_entity(id)
);

CREATE TABLE public.user_rating_entity (
       id uuid NOT NULL,
       rated_at timestamp(6) NOT NULL,
       rating int4 NOT NULL,
       catalog_item_id uuid NOT NULL,
       user_id uuid NOT NULL,
       CONSTRAINT user_rating_entity_pkey PRIMARY KEY (id),
       CONSTRAINT fk4ltlvqt6q3y8wv1q238cfjg8t FOREIGN KEY (catalog_item_id) REFERENCES public.catalog_item_entity(id),
       CONSTRAINT fki1sif19h6iaux57234jks1m0d FOREIGN KEY (user_id) REFERENCES public.user_entity(user_id)
);


