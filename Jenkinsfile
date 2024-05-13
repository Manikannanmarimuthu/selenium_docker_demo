pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                bat 'docker build -t=mani958/seleniumdemo .'
            }
        }
        stage('Push Image') {
            environment {
                DOCKER_HUB = credentials('docker')
            }
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_HUB_USR', passwordVariable: 'DOCKER_HUB_PSW')]) {
                    bat 'docker login -u $DOCKER_HUB_USR -p $DOCKER_HUB_PSW'
                    bat 'docker push mani958/seleniumdemo'
                }
            }
        }
    }
    post {
        always {
            bat 'docker logout'
        }
    }
}
