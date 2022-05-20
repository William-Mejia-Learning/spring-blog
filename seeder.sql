USE spring_blog_db;

INSERT INTO users(email, password, user_name)
VALUES ('email@email', 'password', 'user1'),
       ('email2@email', 'password', 'user2'),
       ('email3@email', 'password', 'user3');

INSERT INTO posts(body, title, user_id)
VALUES ('This is a body', 'Title 1', 1),
       ('This is a body for title 2', 'Title 2', 1),
       ('This is a body for title 3', 'Title 3', 2);

INSERT INTO tags(name) VALUES ('Silly'),
                              ('Funny'),
                              ('Humor');

INSERT INTO post_tag(post_id, tag_id) VALUES (1,2),
                                             (2,1),
                                             (2,3);
