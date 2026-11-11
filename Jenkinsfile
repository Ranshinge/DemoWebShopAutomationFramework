pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

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

            publishHTML(target: [
                reportName: 'TestNG Reports',
                reportDir: 'target/surefire-reports',
                reportFiles: 'index.html',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
        }

        success {
            echo 'Build and Test Execution Passed'
        }

        failure {
            echo 'Build or Test Execution Failed'
        }
    }
}