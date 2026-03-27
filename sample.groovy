pipeline {
    agent any

    tools {
        nodejs 'node-18'
    }
   
    environment {
        STAGE='dev'
    }

    stages {

        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/abhilash007/jenkins-node.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'npm install'
            }
        }

        stage('Test') {
            steps {
                sh 'npm test'
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