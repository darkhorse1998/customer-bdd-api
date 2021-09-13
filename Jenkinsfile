pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "cd customer-supermarket-app; mvn clean compile"
            }
        }
       
		stage('Junit5 Test') { 
            steps {

                sh "cd customer-supermarket-app; mvn test"
            }
        }
        

		stage('Jacoco Coverage Report') {
        	steps{
            		jacoco()
			}
		}
        
        stage('SonarQube'){
			steps {
				sh "cd customer-supermarket-app; mvn sonar:sonar -Dsonar.host.url=http://3.232.89.40:9003 -Dsonar.login=f5149ebc08b1d5b00b3449d7f0cf24e19bee340f"
		         
		     }
   		}
   		
        stage('Build') { 
            steps {

                sh "mvn clean install"
            }
        }
		
		
         stage('Generate HTML report') {
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
           
 		stage('Build Docker image'){
            steps {
                   sh 'cd customer-supermarket-app; docker build -t  customer_management_service:1.0 .'
            }
        }
        

        stage('Push Docker Image'){
        	steps{
        		script{
        			docker.withRegistry("https://304040140783.dkr.ecr.us-east-1.amazonaws.com", "ecr:us-east-1:aws.credentials") {
					  docker.image("customer_management_service:1.0").push()
						}
        			}
        		}
        	}
    }
}

