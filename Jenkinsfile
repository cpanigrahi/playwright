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
                 sh "mvn -Dmaven.test.failure.ignore=true clean package"
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