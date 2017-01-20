#!/usr/bin/env groovy

import groovy.time.TimeCategory 
import groovy.time.TimeDuration

def printTiming(Closure body) {
    steps.echo "Starting step"
    def start = new Date()
    body()
    def stop = new Date()
    TimeDuration td = TimeCategory.minus( stop, start )
    steps.echo "Finishing step (took ${td})"
}

// The steps variable is an object defining steps for the pipeline.
// You can override echo here, then call steps.echo to call the original (vs. )
def echo(def valueToEcho) {
    printTiming {
        steps.echo "Hello World " + valueToEcho
    }
}

def sh(def testExecution) {
    printTiming {
        steps.sh testExecution
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
tests['A'] = { node { sh 'echo Hello from Test A'} } 
tests['B'] = { node { sh 'echo Hello from Test B'} }
tests['C'] = { node { sh 'echo Hello from Test C'} }
stage ('Test Execution') {
    parallel tests
}
