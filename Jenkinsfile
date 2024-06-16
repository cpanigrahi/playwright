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
                 sh "mvn -D clean package"
            }
            post {                
                success {
                   publishHTML([
                       allowMissing: false, 
                       alwaysLinkToLastBuild: false, 
                       keepAll: false, 
                       reportDir: 'target/surefire-reports/', 
                       reportFiles: 'emailable-report.html', 
                       reportName: 'HTML Report', 
                       reportTitles: '', 
                       useWrapperFileDirectly: true])
                }
            }
        }
    }
           
 }