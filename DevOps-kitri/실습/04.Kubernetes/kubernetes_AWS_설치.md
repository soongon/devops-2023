# Amazon EKS 에서 쿠버네티스 설정

EKS 공식문서 확인

[Amazon EKS 시작하기 – eksctl](https://docs.aws.amazon.com/ko_kr/eks/latest/userguide/getting-started-eksctl.html)   

#### 사전 준비: 
  - EC2 Instance 
  - AWSCLI 최신버전 설치

1. kubectl 설치 
   
   a. kubectl 최신버전 다운로드
   b. kubectl 실행 권한 부여   
   c. /usr/local/bin 로 이동   
   d. kubectl 설치 확인    

   ```sh 
   chmod +x ./kubectl

   mv ./kubectl /usr/local/bin 
   
   kubectl version
   ```
1. eksctl 설치   
   a. 최신버전 다운로드 압축 해제   
   b. /usr/local/bin 로 압축해제된 파일 이동   
   c. 설치 확인   

   ```sh
   curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp | tar xz -C /tmp

   sudo mv /tmp/eksctl /usr/local/bin
   
   eksctl version
   ```
  
3. IAM Role 생성하여 EC2 instance 에 추가
      
   IAM 사용자 필수 권한   
      - IAM, EC2, CloudFormation  
   [Minimum IAM policies](https://eksctl.io/usage/minimum-iam-policies/)
   
4. 클러스터와 노드 생성 
   ```sh
   eksctl create cluster --name cluster-name  \
   --region region-name \
   --node-type instance-type \
   --nodes-min 2 \
   --nodes-max 2 \ 
   --zones <AZ-1>,<AZ-2>
   
   # example:
   eksctl create cluster --name kitri  \
   --region ap-northeast-2 \
   --node-type t2.small \
    ```

5. EKS 클러스터 삭제 
   ```sh 
   eksctl delete cluster kitri --region ap-northeast-2
   ```
   
6. 클러스터 생성 확인 
   ```sh 
   kubectl get nodes
   kubectl run tomcat --image=tomcat 
   ```
   
### 쿠버네티스에 Nginx pod 디플로이

1. Nginx 컨테이너 디플로이
    ```sh
    kubectl create deployment  demo-nginx --image=nginx --replicas=2 --port=80
    
    kubectl get all
    
    kubectl get pod
   ```

1. 서비스로 등록하기. 로드밸런서 (ELB) 설정.
   ```sh
   kubectl expose deployment demo-nginx --port=80 --type=LoadBalancer

   kubectl get all (pod, service, deploy, replicaset) -o wide`
   ```
1. 디플로이먼트 삭제.
   ```sh
   kubectl delete deployment demo-nginx

   kubectl delete service demo-nginx
   ```

