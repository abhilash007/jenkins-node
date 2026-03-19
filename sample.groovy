pipeline {
    agent any

    tools {
        nodejs 'node-18'
    }
   

    stages {

        stage('Clone Repo') {
            steps {
                git branch: 'main', url: 'https://github.com/abhilash007/jenkins-node.git'
            }
        }

        stage('Load Env from YAML') {
            steps {
                script {
                    def config = readYaml file: 'config/stage-variables.yml'

                    def envVars = config['dev']['EnvVariables']

                    env.STAGE = envVars.STAGE
                    env.DB_USER_NAME = envVars.DB_USER_NAME
                    env.DB_PASSWORD = envVars.DB_PASSWORD

                    echo "Loaded ENV for dev"
                }
            }
        }

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