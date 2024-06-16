pipeline 
{
    agent any
    
    tools{
    	maven 'mvn2'
        }

    stages 
    {
        stage('Build') 
        {
            steps
            {
                 git 'https://github.com/cpanigrahi/playwright.git'
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            post 
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
    }
}