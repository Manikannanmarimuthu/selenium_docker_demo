/*
    Note:
    
    Windows users use "bat" instead of "sh"
    For ex: bat 'docker build -t=vinsdocker/selenium .'
    
    Do not use "vinsdocker" to push. Use your dockerhub account
*/
pipeline{
    agent any
    stages{
        stage('Build Jar'){
            steps{
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image'){
            steps{
                bat 'docker build -t=manikannanmarimuthu/seleniumdemo .'
            }
        }
        stage('Push Image'){
            environment{
                DOCKER_HUB = credentials('doc_office')
            }
            steps{
                bat 'docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}'
                bat 'docker push manikannanmarimuthu/seleniumdemo'
            }
        }

    }

    post {
        always {
            bat 'docker logout'
        }
    }

}