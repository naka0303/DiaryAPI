CREATE TABLE IF NOT EXISTS users (
	user_id SERIAL NOT NULL PRIMARY KEY
	, username VARCHAR (255) NOT NULL
	, age INTEGER
	, email VARCHAR (255) NOT NULL
	, password VARCHAR (255) NOT NULL
	, auth VARCHAR (255)
	, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	, updated_at TIMESTAMP DEFAULT NULL
	, deleted_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS diaries (
  diary_id INTEGER NOT NULL PRIMARY KEY
  , diary_title VARCHAR (255)
  , diary_content TEXT
  , created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	, updated_at TIMESTAMP DEFAULT NULL
	, deleted_at TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS diaries_linked_users (
	diary_id SERIAL NOT NULL PRIMARY KEY
	, user_id INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS comments_and_replies (
  diary_id INTEGER NOT NULL
  , comment_no INTEGER
  , comment_from INTEGER
  , reply_no INTEGER
  , reply_to INTEGER
  , reply_from INTEGER
  , content TEXT NOT NULL
  , created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  , updated_at TIMESTAMP DEFAULT NULL
  , deleted_at TIMESTAMP DEFAULT NULL
);
