properties([
    parameters([
        string(defaultValue: '', description: 'Please enter VM IP', name: 'nodeIP', trim: true)
        ])
    ])

if (nodeIP?.trim()) {
    node {
        withCredentials([sshUserPrivateKey(credentialsId: 'jenkins-master-ssh-key', keyFileVariable: 'SSHKEY', passphraseVariable: '', usernameVariable: 'SSHUSERNAME')]) {
            stage('Pull Repo') {
                git branch: 'release-1.0', changelog: false, poll: false, url: 'https://github.com/ikambarov/melodi.git'
            }
            stage("Install Apache"){
                sh 'ssh -o StrictHostKeyChecking=no -i $SSHKEY $SSHUSERNAME@${nodeIP} yum install httpd -y'
            }
           
            stage("Install git") {
                sh 'scp -r -o StrictHostKeyChecking=no -i $SSHKEY $SSHUSERNAME@${nodeIP} * /var/www/html/'
            }
            stage("Change Ownership"){
                sh 'ssh -o StrictHostKeyChecking=no -i $SSHKEY $SSHUSERNAME@${nodeIP} chown -R apache:apache /var/www/html/'
            }
            stage("Start Apache"){
                sh 'ssh -o StrictHostKeyChecking=no -i $SSHKEY $SSHUSERNAME@${nodeIP} systemctl start httpd && systemctl enable httpd'
            }

           
        }
    }
}
else {
    error 'Please enter valid IP address'
}
