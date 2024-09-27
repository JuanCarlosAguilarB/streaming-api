-- 1. Insertar usuarios
INSERT INTO public.user_entity (user_id, email, "password")
VALUES
    ('11111111-1111-1111-1111-111111111111', 'user1@example.com', 'password1'),
    ('22222222-2222-2222-2222-222222222222', 'user2@example.com', 'password2');

INSERT INTO public.catalog_item_type_entity (name, description)
VALUES
    ('Movie', 'A motion picture'),
    ('Series', 'A television series');

INSERT INTO public.catalog_item_genre_entity (name, description)
VALUES
    ('Action', 'Action-packed movies'),
    ('Drama', 'Dramatic movies or series'),
    ('Comedy', 'Comedic movies or series');

INSERT INTO public.catalog_item_entity (id, title, description, genre_id, type_id, image_url, "views", creation_order)
VALUES
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Action Movie 1', 'An exciting action movie', 1, 1, 'http://example.com/action1.jpg', 0, 1),
    ('bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Drama Series 1', 'A captivating drama series', 2, 2, 'http://example.com/drama1.jpg', 0, 2),
    ('ccccccc3-cccc-cccc-cccc-cccccccccccc', 'Comedy Movie 1', 'A funny comedy movie', 3, 1, 'http://example.com/comedy1.jpg', 0, 3);
