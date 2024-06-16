pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                 git 'https://github.com/cpanigrahi/playwright.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }
}
