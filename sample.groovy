pipeline {
    agent {
        node {
            customWorkspace '/Users/abhilashkv/MyProjects/rd/jenkins-node'
        }
    }

    tools {
        nodejs 'node-18'
    }

    stages {

        stage('Install Dependencies') {
            steps {
                sh 'npm install'
            }
        }

        stage('Build') {
            steps {
                sh 'npm run build'
            }
        }

        stage('Run App') {
            steps {
                sh 'npm start'
            }
        }
    }
}