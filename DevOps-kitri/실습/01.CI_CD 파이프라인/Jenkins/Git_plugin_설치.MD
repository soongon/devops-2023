# Jenkins 에 Git 플러그인 설치


### 사전작업
1. Jenkins server 

### Jenkins 서버에 Git 설치
1. git 패키지 설치
   ```sh
   yum install git -y
   ```

### 젠킨스 콘솔 에서 git 설정
- 재시동 없이 플러그인 설치  
  - `Manage Jenkins` > `Jenkins Plugins` > `available` > `github`

- git 경로 설정
  - `Manage Jenkins` > `Global Tool Configuration` > `git`

### 빌드결과 확인
- /var/lib/jenkins/workspace