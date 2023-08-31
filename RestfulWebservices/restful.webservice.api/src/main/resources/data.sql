
insert into user_details (user_Id,name,dob)
values (1001,'Manoj',current_date());

insert into user_details (user_Id,name,dob)
values (1003,'Shashwat',current_date());

insert into user_details (user_Id,name,dob)
values (1004,'Ravi',current_date());

insert into user_details (user_Id,name,dob)
values (1005,'Anil',current_date());

insert into post(post_Id,description,user_user_id)
values (2001,'I want to learn AWS',1001);

insert into post (post_Id,description,user_user_id)
values (2002,'Learn Docker',1001);

insert into post (post_Id,description,user_user_id)
values (2003,'Learn DevOps',1003);

insert into post (post_Id,description,user_user_id)
values (2005,'Learn Jenkins',1003);

insert into post (post_Id,description,user_user_id)
values (2006,'Learn Multi Cloud',1004);