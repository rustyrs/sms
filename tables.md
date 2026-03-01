## students
```
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
```managers
CREATE TABLE managers (
  id varchar(255) primary key,
  password varchar(255) not null
);

INSERT INTO managers VALUES ('teacher1','IThinkPeopleLikeMe');
INSERT INTO managers VALUES ('teacher2','password123');
INSERT INTO managers VALUES ('teacher3','GreatestTeacher');
```

## courses
```courses
CREATE TABLE courses (
  id int primary key,
  name varchar(255) not null
);

INSERT INTO courses VALUES (1, 'システム開発');
INSERT INTO courses VALUES (2, '高度システム開発');
INSERT INTO courses VALUES (3, 'ネットワークセキュリティ');
```