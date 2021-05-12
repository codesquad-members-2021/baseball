package com.codesquad.coco.utils;

const val FIND_USER_BY_GITHUB_ID: String = """
select u.id,u.github_id,u.login,u.html_url,u.location,u.followers,u.following,u.access_token,u.refresh_token
from users.u 
where github_id = :github_id;
"""


const val CHEK_NEW_USER_BY_GITHUB_ID: String = """
select count(*) as count
from users u 
where u.github_id = :github_id;
"""

const val CREATE_USER: String = """
insert into users (github_id,login,html_url,location,followers,following,access_token,refresh_token)
values (:github_id,:login,:html_url,:location,:followers,:following,:access_token,:refresh_token)
"""

const val UPDATE_USER: String = """
update users set  
login = :login,html_url = :html_url,location = :location ,followers = :followers,following = :following,access_token = :access_token,refresh_token = :refresh_token
where github_id = :github_id
"""

const val FIND_REFRESH_TOKEN_BY_GITHUB_ID: String = """
select u.refresh_token
from users u 
where u.github_id = :github_id;
"""

const val UPDATE_TOKEN_BY_GITHUB_ID: String = """
update users 
set refresh_token = :refresh_token, access_token = :access_token
where github_id = :github_id
"""






