
1. 도커 허브에서 도커 이미지 검색.
```sh
docker search httpd
```
2. 도커 허브에서 이미지 다운로드
```sh
docker image pull <image_name>:<image_version/tag>
```

3. 로컬에서 도커 이미지 목록 보기
```sh
docker image ls
```

4. 도커 이미지에서 컨테이너 생성/실행/시작 하기
```sh
docker run -d --name <container_Name> <image_name>:<image_version/tag>

d - 백그라운드로 컨테이너 실행 (detached)
```

5. 포트 외부로 노출
```sh
docker run -d  -p <host_port>:<container_port> --name <container_Name> <image_name>:<Image_version/tag>

docker run -d --name httpd_server -p 8080:80 httpd:2.2
```

6. 실행중인 컨테이너 목록 보기
```sh
docker ps
```

7. 모든 컨테이너 목록보기 (running, stpoed, terminated, 등등...)
```sh
docker ps -a
```

8. 인터렉트브 모드로 컨테이너 실행

```sh
docker run -i -t --name centos_server centos:latest
i - interactive
t - Terminal
```

9. 컨테이너 중지 
```sh
docker stop <container_id>
```

10. 컨테이너 시작

```sh
docker start <container_id>
```
11. 컨테이너 제거

```sh
docker rm <container_id>
```

12. 컨테이너에 로그인하기
```sh
docker exec -it <container_Name> /bin/bash
```
