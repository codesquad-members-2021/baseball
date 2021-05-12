package com.codesquad.coco.utils;

const val FIND_USER_BY_GITHUB_ID: String = """
select u.id,u.github_id,u.login,u.htmlUrl,u.location,u.followers,u.following,u.accessToken,u.refreshToken
from users.u 
where github_id = :github_id;
"""


const val CHEK_NEW_USER_BY_GITHUB_ID: String = """
select count(*) as count
from users u 
where u.github_id = :github_id;
"""








