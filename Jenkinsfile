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
                    withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_HUB_USR', passwordVariable: 'DOCKER_HUB_PSW')]) {
                        echo "Username: ${DOCKER_HUB_USR}"
                        echo "Password: ${DOCKER_HUB_PSW}" // Print a placeholder instead of the actual password
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
