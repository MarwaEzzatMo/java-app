#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script { 
                    def dockerCmd = 'sudo docker run -p 3080:3080 -d marwaezzat/javaapp:1.0'
                   sshagent(['my-ec2-cred']) {
                    sh "ssh -o StrictHostKeyChecking=no ubuntu@52.91.176.83 ${dockerCmd}"
                   }
                }
            }
        }
    }
}

