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
                 bat “mvn -Dmaven.test.failure.ignore=true clean package”
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