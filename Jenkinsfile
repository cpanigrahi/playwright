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
            post {                
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
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