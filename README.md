# TestSpringboot_healthcare
healthcare enrollee using spring boot

--------------- mysql
CREATE DATABASE enrollee;

show databases;

create table enrolleenorm(
	id INT PRIMARY KEY AUTO_INCREMENT,
   enrollee_id VARCHAR(20) DEFAULT '' NOT NULL,
   name VARCHAR(40) NOT NULL,
   active_status boolean DEFAULT FALSE NOT NULL,
   has_dependents boolean DEFAULT TRUE,
   birth_date DATE DEFAULT '1000-01-01' NOT NULL,
   phone_num VARCHAR(20)
)
----------- test data
{
    "enrolleeId" : "aa",
   "name" : "John",
   "birthDate":"1989-09-04",
   "activeStatus": true,
   "hasDependents": true
}

{
    "enrolleeId" : "bb",
   "name" : "Peter",
   "birthDate":"1994-07-10",
   "activeStatus": true,
   "hasDependents": true
}

{
    "enrolleeId" : "cc",
   "name" : "Suz",
   "birthDate":"1993-12-25",
   "activeStatus": true,
   "phoneNum":"222-333-4444",
   "hasDependents": true
}

