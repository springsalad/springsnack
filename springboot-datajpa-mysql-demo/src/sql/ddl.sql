create schema `demo` ;


create table `author` (
                        `id` int not null  auto_increment comment  'auther id',
                        `name` varchar(45) null comment  'name',
                        `create_time` timestamp null comment  'create time',
                            primary key (`id`)
)
    engine = InnoDB COMMENT = 'author' char set  = utf8mb4 collate utf8mb4_unicode_ci;

create table `user` (
  `id` int not null  auto_increment comment  'user id',
  `name` varchar(45) null comment  'user name',
  `create_time` timestamp null comment  'create time',
  primary key (`id`)
)
engine = InnoDB COMMENT = 'User' char set  = utf8mb4 collate utf8mb4_unicode_ci;


create table `mygroup` (
                        `id` int not null  auto_increment comment  'group id',
                        `name` varchar(45) null comment  'group name',
                        `create_time` timestamp null comment  'create time',
                        primary key (`id`)
)
    engine = InnoDB COMMENT = 'group' char set  = utf8mb4 collate utf8mb4_unicode_ci;


create table `member` (
                         `id` int not null  auto_increment comment  'internal id',
                         `user_id` int not null comment 'user id',
                         `group_id` int not null comment 'group id',
                         `create_time` timestamp null comment  'create time',
                         primary key (`id`)
)
    engine = InnoDB COMMENT = 'member' char set  = utf8mb4 collate utf8mb4_unicode_ci;