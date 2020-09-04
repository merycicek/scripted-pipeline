node {
    stage( " Pull Repo") {
       git branch: 'solution', changelog: false, poll: false, url: 'https://github.com/ikambarov/terraform-task.git'
    }
    stage( " Terraform Init") {
        sh '''
            terraform-0.13 version
            terraform-0.13 init
           ''' 
    }
    stage( " Terraform Apply") {
        sh 'echo "terraform apply" '
    }
}