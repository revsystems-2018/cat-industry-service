pipeline{
    agent any
    stages{
        stage("Clone Service Repository"){
            agent { label 'master' }
            steps{
                git 'https://github.com/revsystems-2018/cat-industry-service.git'
                sh "echo Service Cloned!"
            }
        }
        stage("Build Service"){
            agent{
                docker 'maven:3-alpine'
            }
            steps{
			    sh 'mvn --version'
                sh "mvn -q clean package -Dmaven.test.skip=true"
            }
        }
        stage("Package"){
            agent { label ' master' }
            steps{
				sh "echo Local project ${pwd}"
                sh "docker build -t cat-industry-service ."
                sh "docker save -o cat-industry-service.tar cat-industry-service"
                stash name: "stash-artifact", includes: "cat-industry-service.tar"
                archiveArtifacts 'target/*jar'
            }
        }
        stage("Archive artifact"){
            agent {label 'master'}
            steps{
                archiveArtifacts 'target/*jar'
            }
        }
        stage("Deployment QA"){
            agent { label 'master' }
            steps{
                sh "docker rm cat-service -f || true"
                sh "docker run -d -p 8090:8090 --name cat-service cat-industry-service"
            }
        }
        stage("Clone Automation Repository"){
            agent { label "master"}
            steps {
               git 'https://github.com/revsystems-2018/cat-industry-service.git'
            }
        }
        stage("Run Automation tests"){
            agent { label "master"}
			steps {
                script {
                    try {
                        sh "mvn clean compile package"
                    } finally {
                        sh "mvn -q clean package -Dmaven.test.skip=true"
                    }
                }
            }
        }
        stage("Deployment PROD"){
            agent{label 'PROD'}
            steps{
                 unstash "stash-artifact"
				 sh "ansible-playbook -i playbook.yml"
                 sh "docker load -i cat-industry-service.tar"
                 sh "docker rm cat-service -f || true"
                 sh "docker run -d -p 8090:8090 --name cat-service cat-industry-service"
            }
        }
    }
}
