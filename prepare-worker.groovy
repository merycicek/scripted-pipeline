node  {
    withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-ssh', keyFileVariable: 'SSHKEY', passphraseVariable: '', usernameVariable: 'SSHUSERNAME')]) {
        
        
        stage ( 'Init') { 
            sh 'ssh -o  StrictHostKeyChecking=no -i $SSHKEY root@68.183.142.184 yum install epel-release -y'
        }    
    
        stage("Install git"){
            sh 'ssh -o  StrictHostKeyChecking=no -i $SSHKEY root@68.183.142.184 yum install git -y'
        }
        stage("install Java"){
            sh 'ssh -o  StrictHostKeyChecking=no -i $SSHKEY root@68.183.142.184 yum install java-1.8.0-openjdk-devel -y'
        }        
    }
}
