pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "mvn clean compile"
            }
        }
       
   		
        stage('Build') { 
            steps {

                sh "mvn clean install"
            }
        }
		
		
         stage('BDD reports') {
            steps{
        			cucumber buildStatus: 'UNSTABLE',
                		reportTitle: 'My Cucumber Report',
                		fileIncludePattern: '**/*.json',
               			trendsLimit: 10,
                		classifications: [
                    		[
                        		'key': 'Browser',
                        		'value': 'Firefox'
                    		]
                		]
                  }
			}
           

    }
}

