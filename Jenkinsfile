 pipeline{
    agent {
        docker{ image 'rasilva1986/java-maven:alm' }
    }

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
    }
}