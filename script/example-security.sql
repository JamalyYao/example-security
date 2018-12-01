drop table if exists t_browser_user;

/*==============================================================*/
/* Table: t_browser_user                                        */
/*==============================================================*/
create table t_browser_user
(
   id                   int(11)                        NOT NULL AUTO_INCREMENT COMMENT 'id',
   user_name            varchar(32)                    DEFAULT NULL COMMENT '姓名',
   user_nickname        varchar(100)                   DEFAULT NULL COMMENT '昵称',
   account              varchar(20)                    DEFAULT NULL COMMENT '登陆账号',
   password             varchar(128)                   NOT NULL COMMENT '登陆密码',
   mobile_no            varchar(16)                    DEFAULT NULL COMMENT '电话',
   sex                  char(1)                        DEFAULT NULL COMMENT '性别 0-男 1-女',
   photo                varchar(255)                   DEFAULT NULL COMMENT '头像',
   email                varchar(64)                    DEFAULT NULL COMMENT '邮箱',
   is_freeze            tinyint(4)                     NOT NULL DEFAULT '0' COMMENT '是否冻结 0--未冻结 1--冻结',
   last_login_ip        varchar(32)                    DEFAULT NULL COMMENT '最后登录IP',
   last_login_time      datetime(3)                    DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '最后登录时间',
   create_time          datetime(3)                    NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
   create_by            varchar(32)                    NOT NULL COMMENT '创建人',
   update_time          datetime(3)                    DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
   update_by            varchar(32)                    NOT NULL COMMENT '修改人',
   flag                 tinyint(4)                     NOT NULL DEFAULT '0' COMMENT '0：未删除，1：逻辑删除',
   PRIMARY KEY (`id`),
   UNIQUE KEY `udx_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='浏览器用户信息表';


drop table if exists t_browser_role;

/*==============================================================*/
/* Table: t_browser_role                                        */
/*==============================================================*/
create table t_browser_role
(
   id                   int(11)                        NOT NULL AUTO_INCREMENT COMMENT 'id',
   role_name            varchar(20)                    DEFAULT NULL COMMENT '角色名称',
   role_code            varchar(50)                    DEFAULT NULL COMMENT '角色编码',
   status               char(1)                        DEFAULT NULL COMMENT '状态  Y-启用 N-禁用',
   remark               varchar(500)                   DEFAULT NULL COMMENT '备注',
   create_time          datetime(3)                    NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
   update_time          datetime(3)                    DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
   flag                 tinyint(2)                     NOT NULL DEFAULT '0' COMMENT '0：未删除，1：逻辑删除',
   PRIMARY KEY (`id`),
   UNIQUE KEY `udx_role_code` (`role_code`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='浏览器角色信息表';


drop table if exists t_browser_permission;

/*==============================================================*/
/* Table: t_browser_permission                                  */
/*==============================================================*/
create table t_browser_permission
(
   id                   int(11)                        NOT NULL AUTO_INCREMENT COMMENT 'id',
   perm_name            varchar(64)                    NOT NULL COMMENT '资源名',
   remark               varchar(256)                   DEFAULT NULL COMMENT '描述',
   url                  varchar(1024)                  DEFAULT NULL COMMENT '菜单链接',
   icon                 varchar(64)                    DEFAULT NULL COMMENT '图标',
   permission           varchar(256)                   DEFAULT NULL COMMENT '关联资源（后台接口/权限字符串等）',
   p_id                 int(11)                        NOT NULL DEFAULT '0' COMMENT '所属上级',
   is_display           tinyint(4)                     NOT NULL DEFAULT '1' COMMENT '是否显示 0--显示 1--显示',
   sort                 int(11)                        NOT NULL DEFAULT '1' COMMENT '排序',
   type                 tinyint(4)                     NOT NULL COMMENT '类型 1--页面 2--动作',
   method               varchar(32)                    NOT NULL DEFAULT 'ALL' COMMENT '动作方法 ALL POST GET PUT',
   create_time          datetime(3)                    NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
   update_time          datetime(3)                    DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
   flag                 tinyint(4)                     NOT NULL DEFAULT '0' COMMENT '0：未删除，1：逻辑删除',
   update_by            varchar(32)                    NOT NULL COMMENT '修改人',
   create_by            varchar(32)                    NOT NULL COMMENT '创建人',
   PRIMARY KEY (`id`),
   UNIQUE KEY `udx_perm_name` (`perm_name`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='浏览器权限信息表';



drop table if exists t_browser_user_role;

/*==============================================================*/
/* Table: t_browser_user_role                                   */
/*==============================================================*/
create table t_browser_user_role
(
   id                   int(11)                        NOT NULL AUTO_INCREMENT COMMENT 'id',
   user_id              int(11)                        NOT NULL COMMENT '用户编号',
   role_id              int(11)                        NOT NULL COMMENT '角色编号',
   create_time          datetime(3)                    NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='浏览器用户角色信息表';


drop table if exists t_browser_role_permission;

/*==============================================================*/
/* Table: t_browser_role_permission                             */
/*==============================================================*/
create table t_browser_role_permission
(
   id                   int(11)                        NOT NULL AUTO_INCREMENT COMMENT 'id',
   role_id              int(11)                        NOT NULL COMMENT '角色编号',
   permission_id        int(11)                        NOT NULL COMMENT '权限编号',
   create_time          datetime(3)                    NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建日期',
   PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='浏览器角色权限信息表';


drop table if exists t_browser_remember_me;

/*==============================================================*/
/* Table: t_browser_remember_me                             */
/*==============================================================*/
create table t_browser_remember_me
(
   series            varchar(64)                    NOT NULL COMMENT '序号',
   username          varchar(64)                    NOT NULL COMMENT '用户名称',
   token             varchar(64)                    NOT NULL COMMENT 'token值',
   last_user_time    datetime(3)                    NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '最后用户登录时间',
   PRIMARY KEY (`series`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='浏览器账号记录表';
