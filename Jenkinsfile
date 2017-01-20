#!/usr/bin/env groovy

def printTiming(Closure body) {
    echo "Starting step"
    def start = new Date()
    body()
    def stop = new Date()
    TimeDuration td = TimeCategory.minus( stop, start )
    echo "Finishing step (took ${td})"
}

// The steps variable is an object defining steps for the pipeline.
// You can override echo here, then call steps.echo to call the original (vs. )
def echo(def valueToEcho) {
    printTiming {
        steps.echo "Hello World " + valueToEcho
    }
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
tests['A'] = { node { bat 'echo Hello from Test A'} } 
tests['B'] = { node { bat 'echo Hello from Test B'} }
tests['C'] = { node { bat 'echo Hello from Test C'} }
stage ('Test Execution') {
    parallel tests
}
