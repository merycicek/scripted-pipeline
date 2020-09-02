node  {
    withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-ssh', keyFileVariable: 'SSHKEY', passphraseVariable: '', usernameVariable: 'SSHUSERNAME')]) {
        stage ( 'Init') { 
            sh 'ssh -o  StrictHostKeyChecking=no -i $SSHKEY root@68.183.142.184 yum install epel-release -y'
        }    
    }  
}


