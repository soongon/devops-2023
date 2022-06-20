#  젠킨스에 메이븐 빌드 툴 설치 및 설정

### 사전 작업
1. Jenkins server

### 메이븐 설치
1. 메이븐 다운로드 후 젠킨스 서버에 설치. 설치 디렉토리는 /opt/maven
 - Link : https://maven.apache.org/download.cgi
    ```sh
     # Creating maven directory under /opt
     cd /opt
     # downloading maven version 3.x.x
     wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz
     tar -xvzf apache-maven-3.8.5-bin.tar.gz
     # rename to maven
     mv apache-maven-3.8.5 maven
     ```
	
1. 환경변수 JAVA_HOME, M2_HOME 과 M2 설정.
  - find / -name java-11* 로 자바 설치 경로 찾기
   ```sh
   vi ~/.bash_profile
   JAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.13.0.8-1.amzn2.0.3.x86_64
   M2_HOME=/opt/maven
   M2=$M2_HOME/bin
   PATH=<Existing_PATH>:$JAVA_HOME:$M2_HOME:$M2
   ```
### 확인사항 
1. 메이븐 버전 확인
  
    ```sh
    source .bash_profile
    mvn --version
    ``` 

### 젠킨스 콘솔에서 메이븐 설정
1. 메이븐 플러그인 설정 -> 재시작 없이 설정  
  - `Manage Jenkins` > `Jenkins Plugins` > `available` > `Maven Integration`

2. 자바와 메이븐 경로 지정
  - `Manage Jenkins` > `Global Tool Configuration` > `Maven`

