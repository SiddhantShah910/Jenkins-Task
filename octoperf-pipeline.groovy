#!/usr/bin/env groovy
node {

    stage('Initialise') {
        /* Checkout the scripts */
        checkout scm: [
                $class: 'GitSCM',
                userRemoteConfigs: [
                        [
                                url: "https://github.com/SiddhantShah910/Jenkins-Task.git",
                                credentialsId: "SiddhantShah910"
                        ]
                ],
                branches: [[name: "main"]]
        ], poll: false
    }

    stage('Complete any setup steps') {
        echo "Complete set-up steps"
        echo "${octoperf_test_value}"
    }

    stage('Execute Performance Tests') {
        dir("${WORKSPACE}/scripts") {
            bat "C:\Jmeter\apache-jmeter-5.4.3\bin\jmeter.bat -n -t Test05.jmx -l Shift-Left.jtl"
        }
    }

    stage('Analyse Results') {
        echo "Analyse results"
    }
}
