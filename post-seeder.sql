USE spring_blog_db;


INSERT INTO posts(body, title) VALUES('This is a body one', 'title one'),
                                     ('This is a body two', 'title two'),
                                     ('This is a body three', 'title three'),
                                     ('This is a body four', 'title four'),
                                     ('This is post about cats', 'cats');

INSERT INTO post_details(history_of_post, is_awesome, topic_description) VALUES ('This is the history of the post, blah lahahbddhfldjfhafkjahfklhdfakhfsakjfhsalkfhjkasdfh', TRUE, 'This is a description'),
                                                                                ('This is the history of the post, blah lahahbddhfldjfhafkjahfklhdfakhfsakjfhsalkfhjkasdfh', TRUE, 'This is a description'),
                                                                                ('This is the history of sfdsfdsfsthe post, blah lahahbddhfldjfhafkjahfklhdfakhfsakjfhsalkfhjkasdfh', FALSE, 'This is a description'),
                                                                                ('This is the history of thdsfdsfdse post, blah lahahbddhfldjfhafkjahfklhdfakhfsakjfhsalkfhjkasdfh', TRUE, 'This is a description'),
                                                                                ('This is the history of Cats', TRUE, 'This is a description');

INSERT INTO post_image(image_title, url, post_id)
VALUES ('This is a cat image','https://media.istockphoto.com/photos/european-short-haired-cat-picture-id1072769156?s=612x612', 5)

