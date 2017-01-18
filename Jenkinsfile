#!/usr/bin/env groovy

stage ('Product Build') {
    echo 'Hello from Product Build'
}
stage ('Test Build') {
    echo 'Hello from Test Build'
}
def tests = [:]
tests['A'] = {echo 'Hello from Test A'} 
tests['B'] = {echo 'Hello from Test B'} 
stage ('Test Execution') {
    parallel tests
}