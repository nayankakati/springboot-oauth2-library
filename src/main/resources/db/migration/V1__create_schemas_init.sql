CREATE TABLE `users` (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(255)  NOT NULL ,
  email varchar(255)  NOT NULL ,
  password varchar(128) NOT NULL,
  version bigint(20) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT username_unique UNIQUE (username),
  CONSTRAINT email_unique UNIQUE (email),
  INDEX user_ind (id)
) AUTO_INCREMENT=1;

CREATE TABLE `security_role` (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  version bigint(20) NOT NULL,
  authority varchar(255) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT authority_unique UNIQUE (authority),
  INDEX security_role_id (id)
) AUTO_INCREMENT=1;

CREATE TABLE `user_security_role` (
    security_role_id  bigint(20) NOT NULL,
    user_id bigint(20) NOT NULL,
    PRIMARY KEY (security_role_id, user_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (security_role_id) REFERENCES security_role(id)
);

CREATE TABLE `oauth_access_token`(
    token_id VARCHAR(256),
    token BINARY(255),
    authentication_id VARCHAR(256),
    user_name VARCHAR(256),
    client_id VARCHAR(256),
    authentication BINARY(255),
    refresh_token VARCHAR(256)
);

CREATE TABLE `oauth_approvals` (
  userid VARCHAR(256),
  clientid VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresat TIMESTAMP,
  lastmodifiedat TIMESTAMP
);

CREATE TABLE `oauth_client_details` (
  client_id VARCHAR(256) NOT NULL,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INT,
  refresh_token_validity INT,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256),
  PRIMARY KEY (client_id)
);

CREATE TABLE `oauth_client_token` (
  token_id VARCHAR(256),
  token BINARY(255),
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

CREATE TABLE `oauth_code` (
  code VARCHAR(256),
  authentication BINARY(255)
);

CREATE TABLE `oauth_refresh_token` (
  token_id VARCHAR(256),
  token BINARY(255),
  authentication BINARY(255)
);

INSERT INTO `oauth_client_details`(client_id, resource_ids, client_secret, scope, authorized_grant_types,web_server_redirect_uri, authorities, access_token_validity,refresh_token_validity, additional_information, autoapprove)
values ("demo-client", "demo", 123456, "read,write", "password,refresh_token,client_credentials", "", "ROLE_CLIENT,ROLE_GUES", 43200, 2592000,"", false);