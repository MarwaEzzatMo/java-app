def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-creden', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t marwaezzat/java-app .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push marwaezzat/java-app'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this

