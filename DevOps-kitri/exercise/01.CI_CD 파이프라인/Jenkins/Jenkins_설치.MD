# AWS EC2 에 젠킨스 설치

### 사전 준비
1. EC2 Instance 
   - 아마존 리눅스 프리티어 사용
   - Security Group - `8080` 포트 허용
   - pem 파일 획득
1. ssh 접속
   - ssh -i pem경로 ec2-user@PUBLIC-IP
1. Java 11 설치  

### 터미널 주요 명령어
1. sudo su -
1. pwd
1. java -version
1. service jenkins status


## Jenkins 설치
 1. https://www.jenkins.io/doc/book/installing/linux/#red-hat-centos 에서 최신버전 확인하고 설치
   ```sh
   sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
sudo yum upgrade
# Add required dependencies for the jenkins package
sudo yum install java-11-openjdk
sudo yum install jenkins
sudo systemctl daemon-reload
   ```

   ### Jenkins 서버 시작하기
   ```sh
   # Start jenkins service
   service jenkins start

   # Setup Jenkins to start at boot,
   chkconfig jenkins on
   ```

   ### Jenkins 서버에 접속하기
   `8080` 기본 포트
   ```sh
   http://YOUR-SERVER-PUBLIC-IP:8080
   ```
  #### Jenkins 설정하기
- 디폴트 사용자명  `admin`
- 초기 Password 경로:`/var/lib/jenkins/secrets/initialAdminPassword`
- 플러그인 설치 `Skip` - 차후 설정
- 어드민 패스워드 변경
   - `Admin` > `Configure` > `Password`
- `java` 경로 설정
  - `Manage Jenkins` > `Global Tool Configuration` > `JDK`  
- 어드민 사용자 아이디 추가

### Jenkins 잡 테스트
1. “new item”
1. 아이템 명 – `My-First-Project`
   - `Freestyle` 프로젝트 선택
1. 빌드 섹션에서
	Execute shell:
   ```sh
   echo "Welcome to Jenkins Demo"
   uptime
   ``` 

1. 잡 저장 
1. Build job
1. "console output" 확인
