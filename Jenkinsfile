  
pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning Workspace...'
                bat "mvn help:effective-settings help:effective-pom -U clean -X"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                bat "mvn clean install -X"
            }
        }
    }
}
