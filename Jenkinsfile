 pipeline{
    agent any

    stages{
        stage('Build'){
            agent any
            steps{
                echo 'building...'
                sh 'mvn clean compile'
            }
        }

        stage('Test'){
            agent any
            steps{
                echo 'testing...'
                sh 'mvn test'
            }

        }

        stage('Deploy'){
            steps{
                echo 'Deploying..'
                sh 'mvn spring-boot:run'
            }

            post {
                always{
                    echo 'saving artifacts...'
                    archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
                }
            }
        }
    }
}