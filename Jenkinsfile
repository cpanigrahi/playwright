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
                 sh "mvn -D clean package"
            }

        }
    }
}