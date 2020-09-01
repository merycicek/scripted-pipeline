node {
  stage("Building"){
    echo 'Building..'
  }
  stage("Testing"){
    echo 'Testing..'
  }
  stage ('input'){
      input 'Do you want to continue?'
  }
  stage("Deploying "){
    echo 'Deploying....'
  }
}