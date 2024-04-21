pipeline {
    agent any
    stages {

        stage('Build Interface') {
            steps {
                build job: 'jogayjoga-group', wait: true
            }
        }

        stage('Build') { 
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Image') {
            steps {
                script {
                    group = docker.build("eriksoaress/group:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }
        }

        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credential') {
                        group.push("${env.BUILD_ID}")
                        group.push("latest")
                    }
                }
            }
        }
    }
}