# Amazon Linux server 에 도커 설치

### 사전작업
1. Amazon Linux EC2 Instance

## 도커 설치

1. 도커 설치 및  서비스 시작
   ```sh 
   yum install docker -y
   docker --version 
   
   # start docker services
   service docker start
   service docker status
   ```

### 도커 설치 후 톰캣 컨테이너 설치
1. 도커 레지스트리에서 톰캣 이미지 pull 후 컨테이너 생성
   ```sh
   docker pull tomcat
   docker images
   
   docker run -d --name tomcat-conatainer -p 8090:8080 tomcat

   docker ps -a
   ```

1. 톰캣 컨테이너 이슈 수정
   ```sh
   # 톰캣 컨테이너로 로그인
   docker ps

   docker exec -it tomcat-container /bin/bash

   # webapps.dist 의 모든 내용을 webapps 로 복사
   cd /usr/local/tomcat/webapps.dist
   
   cp -R * ../webapps/

   exit
   ```

### 젠킨스와 도커 호스트 연동을 위한 계정 생성

1. dockeradmin 유저 생성
   ```sh
   useradd dockeradmin
   passwd dockeradmin
   ```
1. docker 그룹에 사용자 추가 
   ```sh
   usermod -aG docker dockeradmin
   ```
1. dockeradmin 사용자 패스워드로 접속 허가
   ```sh
   vi /etc/ssh/sshd_config
   # /Password 로 검색
   # PasswordAuthentication yes 의 주석을 해제

   service sshd reload

   # 새로운 세션에서 접속 시도
   ssh dockeradmin@<HOST_IP>
   ```