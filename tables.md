## students
```sql
CREATE TABLE students (
	student_id int primary key,
	student_name varchar(255) not null,
	course_id int not null	
)

INSERT INTO STUDENT VALUES (1,'大原　太郎',1);
INSERT INTO STUDENT VALUES (2,'大原　次郎',2);
INSERT INTO STUDENT VALUES (3,'大原　花子',1);
```

## managers
```sql
CREATE TABLE managers (
  id varchar(255) primary key,
  name varchar(255) not null,
  password varchar(255) not null
);

INSERT INTO managers VALUES ('teacher1', '山崎由好','IThinkPeopleLikeMe');
INSERT INTO managers VALUES ('teacher2', '晴彦猿彦','password123');
INSERT INTO managers VALUES ('teacher3', '検見川浜','GreatestTeacher');
```

## courses
```sql
CREATE TABLE courses (
  id int primary key,
  name varchar(255) not null
);

INSERT INTO courses VALUES (1, 'システム開発');
INSERT INTO courses VALUES (2, '高度システム開発');
INSERT INTO courses VALUES (3, 'ネットワークセキュリティ');
```

## student_details
```sql
CREATE TABLE student_details (
    number int PRIMARY KEY REFERENCES students(student_id),
    password varchar(255) not null,
    comment varchar(255)
);

INSERT INTO student_details VALUES (1, 'password', 'やっほー');
INSERT INTO student_details VALUES (2, 'password', '営業中');
INSERT INTO student_details VALUES (4, 'password',  'テスト用アカウント');
```