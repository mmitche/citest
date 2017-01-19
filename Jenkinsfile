#!/usr/bin/env groovy

@NonCPS
def printParams() {
  env.getEnvironment().each { name, value -> println "Name: $name -> Value $value" }
}
printParams()

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
