node ('master') {
    stage ( 'Init') { 
        sh 'ssh -i /root/jenkins-master_rsa root@68.183.142.184 yum install epel-release -y'
}