pipeline {
    agent any
    stages {




        stage('Build') {
            steps {
                echo "start"
                //
            }
        }

         stage('Checkout external proj') {
        steps {
            git branch: 'main',

                url: 'https://github.com/shkna1368/KrdHr'


        }
    }


        stage('CLEAN-PACKAGE') {
            steps {
               bat "mvn clean package"
            }
        }

          stage('Buid docker image') {
            steps {
               bat "docker build --tag=krd-hr:latest ."
                        echo " docker end"
            }
        }

          stage('run docker image') {
            steps {
               bat " docker run -d -p8090:8090 krd-hr:latest"
                        echo " docker end"
            }
        }
    }
    }