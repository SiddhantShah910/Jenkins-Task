#!/usr/bin/env groovy
node {

    stage('Initialise') {
        /* Checkout the scripts */
        checkout scm: [
                $class: 'GitSCM',
                userRemoteConfigs: [
                        [
                                url: "https://github.com/SiddhantShah910/Jenkins-Task.git",
                                credentialsId: "573b7e91-ef72-4426-9a34-cd91b632b78d"
                        ]
                ],
                branches: [[name: "main"]]
        ], poll: false
    }

    stage('Complete any setup steps') {
        echo "Complete set-up steps"
    }

    stage('Execute Performance Tests') {
        dir("${WORKSPACE}") {
            bat "C:\\Jmeter\\apache-jmeter-5.4.3\\bin\\jmeter.bat -n -t Test05.jmx -l Shift-Left.jtl"
            bat "git push origin HEAD:main --force"
        }
    }

    stage('Analyse Results') {
        echo "Analyse results"
    }
}
