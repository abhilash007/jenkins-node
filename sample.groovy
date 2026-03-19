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
                    def config = readYaml file: 'app/config/stage-variables.yml'

                    def envVars = config['dev']['EnvVariables']
                    envVars.each { key, value ->
                        echo "${key} = ${value}"
                        env[key] = value.toString()
                    }

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