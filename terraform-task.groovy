node {
    stage( " Pull Repo") {
       git branch: 'solution', url: 'https://github.com/ikambarov/terraform-task.git'
    }
        stage( " Pull Repo") {
        ssh '''
        cd 	sandbox/
        terraform init
        '''
    }
        stage( " Terraform Apply") {
        ssh 'echo "terraform apply" '
    }
}