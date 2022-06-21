# Ansible 설치

Ansible 은 오픈소스 자동화 플랫폼이다. 매우 심플하고 강력한 것이 특징이다. 

### 사전 준비

1. AWS EC2 인스턴스 (컨트롤 노드로 사용)

### 설치 절차:
#### Amazon EC2 인스턴스에 설치
   
1. ansadmin 유저 생성 (컨트롤 노드에서 사용)  
   ```sh
   useradd ansadmin

   passwd ansadmin
   ```
1. ansadmin 유저에게 sudo 권한 부여. "visudo" 명령어 사용 권장. (컨트롤 노드와 호스트에서 사용)
   ```sh
   echo "ansadmin ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
   ```
1. ansadmin 유저 패스워드 로그인 활성화
   ```sh
   vi /etc/ssh/sshd_config
   # /Password 로 검색
   # PasswordAuthentication yes 의 주석을 해제

   service sshd reload

   # 새로운 세션에서 접속 시도
   ssh ansdmin@<HOST_IP>
   ```
1. ansadmin 유저로 로그인 후 ssh key 생성 (Control 노드)
   ```sh 
   sudo su - ansadmin

   ssh-keygen
   ```

1. Ansible 서버 설치. 
   ```sh
   yum install ansible
   
   # 설치 확인 
   python --version

   ansible --version
   ```

## 도커호스트에 설정할 내용
1. ansamdin 유저 생성
   ```sh
   useradd ansadmin

   passwd ansadmin
   ```
1. ansadmin 유저 sudoers 파일에 추가
   ```sh
   visudo
   ```
1. 패스워드 기반 로그인 활성화
   ```sh
   vi /etc/ssh/sshd_config
   # /Password 로 검색
   # PasswordAuthentication yes 의 주석을 해제

   service sshd reload

   # 새로운 세션에서 접속 시도
   ssh ansdmin@<HOST_IP>
   ```

## Ansible 컨트롤 노드에 설정할 내용

1. /etc/ansible 디렉토리에, "hosts" 라는 인벤토리 파일 생성, managed hosts IP addresses 추가. 

1. 생성한 키를 ansible managed host(도커 호스트)에 복사
   ```sh 
   ssh-copy-id ansadmin@<target-server>
   ```

### 연결 테스트

1. ansadmin 유저로 ansible 명령 실행.
   ```sh 
   ansible all -m ping
   ansible all -m command -a uptime
   ```
