pipeline {
    agent any
    stages{
        stage('code checkout') {
            steps {
                git branch: 'dev', url: 'https://github.com/bhavesh7777/deployment-aws-assignment.git'
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv(installationName: 'sonarqube-server') {
                    sh 'mvn clean verify sonar:sonar'
                    sleep 60;
                }
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage("build") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('publish over ssh') {
            steps([$class: 'BapSshPromotionPublisherPlugin']) {
                sshPublisher(
                    continueOnError: false, failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName:"dev1",
                            verbose: true,
                            transfers:[
                                sshTransfer(
                                    sourceFiles:"**/*.jar",
                                    remoteDirectory:"",
                                    execCommand:"java -jar target/*.jar "
                                )
                            ]
                        )
                    ]
                )
            }
        }
    }
}