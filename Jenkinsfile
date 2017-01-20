#!/usr/bin/env groovy

// The steps variable is an object defining steps for the pipeline.
// You can override echo here, then call steps.echo to call the original (vs. )
def echo(def valueToEcho) {
    steps.echo "Hello World " + valueToEcho
}

def bat(def testExecution) {
    printTiming {
        steps.bat testExecution
    }
}

echo env.JOB_NAME

stage ('Product Build') {
    echo 'Hello from Product Build'
}
stage ('Test Build') {
    echo 'Hello from Test Build'
}
def tests = [:]
tests['A'] = { node { echo 'Hello from Test A'} } 
tests['B'] = { node { echo 'Hello from Test B'} }
tests['C'] = { node { echo 'Hello from Test C'} }
stage ('Test Execution') {
    parallel tests
}
