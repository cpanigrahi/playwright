pipeline 
{
    agent any

    stages 
    {
        stage('Build') 
        {
            steps
            {
                 sh "mvn -D clean test"
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