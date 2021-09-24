def call(){
    pipeline {
        agent any
        tools{
            maven "maven"
        }
        stages {   

            stage ('Git Fetch Stage') {
                steps{
                    echo "Git Stage"
                    git branch: 'main', url: 'https://github.com/AmanTen11/Jenkins-Maven-Pipeline.git'
                }
            }

            stage("Compile") {
                steps {
                    sh "mvn clean compile"
                }
            }
            stage("Unit Tests") {
                steps {
                    sh "mvn test"
                }
            }
            stage("Integration Tests") {
                steps {
                    sh "mvn verify"
                }
            }
            stage("Package") {
                steps {
                    sh "mvn package -DskipTests=true"
                }
            }
        }
    }    
}
