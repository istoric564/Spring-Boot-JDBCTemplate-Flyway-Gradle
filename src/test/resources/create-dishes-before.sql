DELETE FROM likes;

INSERT INTO likes (dish, count)
VALUES('4223faa2-5f50-4c1d-904f-c71e88d08db7',1)
ON CONFLICT (dish)
DO UPDATE
SET count = likes.count + 1;