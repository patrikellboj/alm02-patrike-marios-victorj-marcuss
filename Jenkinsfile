 pipeline{
    agent {
        docker{ image 'rasilva1986/java-maven:alm' }
    }

    stages{
        stage('Build'){
            steps{
                echo 'building...'
                sh 'mvn clean compile'
            }
        }

        stage('Test'){
            steps{
                echo 'testing...'
                sh 'mvn test'
            }
        }
    }
}
