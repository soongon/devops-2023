## Docker Hub - 도커 이미지 중앙 저장소

##### Ref URL : https://docs.docker.com/docker-hub/

1. docker hub 계정 생성 https://hub.docker.com/

1. Pull 도커 이미지 

   ```sh 
   docker pull ubuntu
   ```

1. 예전 버너 이미지 풀

   ```sh
   docker pull ubuntu:16.04
   ```

1. 도커 허브에 로그인 
   ```sh
   docker login
   docker push soongon/tomcat:demo
   ```

### 테스트 

1. 도커 서버의 모든 이미지 삭제 
   ```sh 
   docker image rm -f <Image_id>
   ```

1. 도커 이미지 풀
   ```sh
   docker pull soongon/tomcat:demo
   ```

