#!/usr/bin/env groovy

def echo(def valueToEcho) {
    super.echo "Hello World " + valueToEcho
}

echo env.JOB_NAME

stage ('Product Build') {
    echo 'Hello from Product Build'
}
stage ('Test Build') {
    echo 'Hello from Test Build'
}
def tests = [:]
tests['A'] = {echo 'Hello from Test A'} 
tests['B'] = {echo 'Hello from Test B'} 
tests['C'] = {echo 'Hello from Test C'} 
stage ('Test Execution') {
    parallel tests
}
