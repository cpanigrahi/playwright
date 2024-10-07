pipeline {
    agent any
    
    tools{
    	maven 'mvn2'
        }
 
    stages {
        stage('Test') {
            steps {
            
                 git branch: 'main', 
                 url: 'https://github.com/cpanigrahi/playwright'
                 bat "mvn -D clean test"
            }

        }
    }
}