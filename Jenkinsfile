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
            steps {
                script {
                    withCredentials([string(credentialsId: 'docker', variable: 'DOCKER_HUB_USR'), string(credentialsId: 'docker', variable: 'DOCKER_HUB_PSW')]) {
                        echo "Username: ${DOCKER_HUB_USR}"
                        echo "Password: ********" // Print a placeholder instead of the actual password
                        bat "docker login -u ${DOCKER_HUB_USR} -p ${DOCKER_HUB_PSW}"
                        bat 'docker push mani958/seleniumdemo'
                    }
                }
            }
        }
    }
    post {
        always {
            script {
                bat 'docker logout'
            }
        }
    }
}
