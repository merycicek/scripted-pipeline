node ('master') {
    withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-ssh', keyFileVariable: 'SSHKEY', passphraseVariable: '', usernameVariable: 'SSHUSERNAME')]) {
        stage ( 'Init') { 
            sh 'ssh -i $SSHKEY root@68.183.142.184 yum install epel-release -y'
        }    
    }  
}


