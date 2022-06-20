# 젠킨스로 도커 호스트에 디플로이 하기 

### 사전 준비

1. Jenkins server 
1. Docker-host Server 

### 젠킨스에 도커 호스트 연동

"publish Over SSH" 플러그인 설치
 - `Manage Jenkins` > `Manage Plugins` > `Available` > `Publish over SSH`

젠킨스와 도커 호스트 간 연결 가능하게 하기

- `Manage Jenkins` > `Configure System` > `Publish Over SSH` > `SSH Servers` 

	- SSH Servers:
    - Name: `docker-host`
		- Hostname:`<ServerIP>`
		- username: `dockeradmin`
               
       -  `Advanced` > chose `Use password authentication, or use a different key`
		 - password: `*******`
 
### 도커 호스트로 디플로이 잡 에서 주의사항
   
 - *Post-build Actions*
   - Send build artifacts over SSH
     - *SSH Publishers*
      - SSH Server Name: `docker-host`
       - `Transfers` >  `Transfer set`
            - Source files: `target/*.war`
	       - Remove prefix: `target`
	       - Remote directory: `//home//dockeradmin` 또는 `.`
	 
