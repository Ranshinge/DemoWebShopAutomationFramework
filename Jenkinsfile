
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Ranshinge/DemoWebShopAutomationFramework.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Automation Pipeline Execution Completed'
        }
        success {
            echo 'Build and Test Execution Passed'
        }
        failure {
            echo 'Build or Test Execution Failed'
        }
    }
}
