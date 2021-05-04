# 테크니컬 첼린지 포인트
## Oauth 구현하기
  - github 페이지와 ouath인증 진행하기
  - Spring security는 사용하지 않는다.
  - 어려운 경우 >> Oauth를 별도 라이브러리로 구현하고 baseball 프로젝트에 통합 적용해 본다.

## admin tool 제작
  - 게임 운영에 필요한 도구들을 모아놓은 admin tool을 별도 웹으로 구현한다.
  - admin 도구는 프론트 및 백엔드 모두 백엔드에서 직접 구현한다. 
  - admin 사용자 인증은 hard coding으로 최대한 간단히 구현한다. admin email 주소를 설정에 포함할 것
  - 내생각
    - admin@dong.com / javaking  >> 요런느낌으로 가자
    - 게임 운영에 필요한 도구들
      - 모든 데이터베이스 조회
      - 프론엔드 백엔드 다 구현해버리기

## VPC 학습
  - 웹서버와 데이터베이스는 다른컴퓨터로 쓰기!!
    - EC2 두대로 각각 웹서버와, DB서버 두대 돌려 생성
    - 혹은 데이터베이스는 RDS로 쓰고, 웹서버 EC2 쓰는 구조
  - 22,80 포트 제외하고 다 닫기
    - 3306이나 8080은 포트 열려있는거 자체가 보안 취약점이니까 꼭 닫아놓기
    - 엔진엑스랑 연결되는거니까 다음항목을 봐라

## Nginx
  - 프론트 배포는 NginX를 설정해서 사용한다. 프론트는 80포트에서 동작
  - NginX와 tomcat을 연동하고 80포트만 외부에 개방
  - 8080 포트는 외부에 개방하지마라
    - 그러니까 쉽게말해서 프론트사이드 


## 커밋 메시지 규칙
> 원문 : http://karma-runner.github.io/5.0/dev/git-commit-msg.html

- feat (new feature for the user, not a new feature for build script)
- fix (bug fix for the user, not a fix to a build script)
- docs (changes to the documentation)
- style (formatting, missing semi colons, etc; no production code change)
- refactor (refactoring production code, eg. renaming a variable)
- test (adding missing tests, refactoring tests; no production code change)
- chore (updating grunt tasks etc; no production code change)
