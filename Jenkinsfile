 pipeline{
    agent {
        docker{ image 'rasilva1986/java-maven:alm' }
    }

    stages {
        stage('Build'){
            steps {
                echo 'building...'
                sh 'mvn clean install'
            }
        }

        stage('Create and publish test reports') {
            steps {
            echo 'Publishing test reports'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/surefire-reports',
                        reportFiles: 'index.html',
                        reportName: 'Unit tests',
                        reportTitles: 'Unit tests'
                    ])

                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/jacoco',
                        reportFiles: 'index.html',
                        reportName: 'Test coverage',
                        reportTitles: 'Test coverage'
                    ])
                }

                // Om det tidigare lyckades. Spara undan .jar filen
                success {
                    archive 'target/*.jar'
                }
            }
        }

//         stage('Test') {
//             steps{
//                 echo 'testing...'
//                 sh 'mvn test'
//             }
//         }
    }
}
