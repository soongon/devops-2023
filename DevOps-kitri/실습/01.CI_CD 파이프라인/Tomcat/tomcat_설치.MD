# EC2 인스턴스에 톰캣 설치

### 사전 작업
1. EC2 인스턴스 생성과 Java 11 설치
   - ssh -i <PEM_FILE> ec2-user@<PUBLIC_IP>
   - amazon-linux-extras install java-openjdk11
### Apache Tomcat 설치
1. 톰캣 다운로드  https://tomcat.apache.org/download-10.cgi
1. /opt 디렉토리에 설치
   
   ```sh 
   # Create tomcat directory
   cd /opt
   wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.21/bin/apache-tomcat-10.0.21.tar.gz
   tar -xvzf /opt/apache-tomcat-<version>.tar.gz
   ```
1. /bin 디렉토리에 있는 startup.sh 과 shutdown.sh 의 권한을 추가. 
   ```sh
   chmod +x /opt/apache-tomcat-<version>/bin/startup.sh 
   chmod +x /opt/apache-tomcat-<version>/bin/shutdown.sh
   ```
   > Note: 자바를 설치하지 않으면 아래와 같은 에러가 발생한다.   
   `Neither the JAVA_HOME nor the JRE_HOME environment variable is defined At least one of these environment variable is needed to run this program`
1. startup.sh 과 shutdown.sh 에 대한 링크파일를 작성
   ```sh
   ln -s /opt/apache-tomcat-<version>/bin/startup.sh /usr/local/bin/tomcatup
   ln -s /opt/apache-tomcat-<version>/bin/shutdown.sh /usr/local/bin/tomcatdown
   tomcatup
   ```
  #### 체크 사항 :
8080 포트에서 톰캣서버 접속  
 - http://<Public_IP>:8080

  톰캣 홈 디렉토리 아래 conf/server.xml 파일에서 톰캣 서비스 포트를 변경 가능
   ```sh
 cd /opt/apache-tomcat-<version>/conf
# update port number in the "connecter port" field in server.xml
# restart tomcat after configuration update
tomcatdown
tomcatup
   ```

#### 체크 사항 :
8090 포트에서 접속  
 - AWS EC2 보안그룹에서 포트를 열어준다.
 - http://<Public_IP>:8090

1. context.xml 파일을 수정하여 브라우저에서 로그인이 가능하게 한다.
   ```sh
   #search for context.xml
   find / -name context.xml
   ```
1. 아래 두개의 파일에 `Value ClassName` 항목을 찾아 주석 처리한 후 톰캣을 리스타트 한다. 
   ```sh 
   /opt/tomcat/webapps/host-manager/META-INF/context.xml
   /opt/tomcat/webapps/manager/META-INF/context.xml
   
   # Restart tomcat services
   tomcatdown  
   tomcatup
   ```
1. 사용자 정보 수정을 위해 conf/tomcat-users.xml 파일 수정
   ```sh
	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<role rolename="manager-jmx"/>
	<role rolename="manager-status"/>
	<user username="admin" password="admin" roles="manager-gui, manager-script, manager-jmx, manager-status"/>
	<user username="deployer" password="deployer" roles="manager-script"/>
	<user username="tomcat" password="s3cret" roles="manager-gui"/>
   ```
1. 서비스 재 시작 후 로그인 

