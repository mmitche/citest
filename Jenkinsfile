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

// Stuff to go in libraries

// def startVSTSBuild() {
//   Starts VSTS build and returns immediately
//   Could send telemtry info along in this function if provided as parameters
// }

// def waitForVSTSBuild() {
//   Waits for the VSTS build to finish and returns results
//   Could send telemtry info along in this function if provided as parameters
// }

// def sendReportingInfo() {
//   Should probably be broken into multiple functions depending on what info needs to come out
//   We should enforce its use by ensuring that we have associated data before we launch workloads that require that.  For instance,
//   if a user should call "tell EventHub I'm starting a build" once at the start of the pipeline, then we can enforce that by updating state during
//   the pipeline, and overriden steps (like bat or vstsBuild or whatnot) will check flags.
//
//    For instance, we can instantiate an object associated with the pipeline which describes overall state
//    utilized by generic telemetry functionality.
// }

// Corefx orchestrated build

// This data comes from the build inputs, either automatically generated based on "tracked repo" or from whatever plugin is launching the build and setting
// these input parameters.  Augment as necessary
// 
// Repository = repository
// User = user that launched it/submitted PR/etc.
// Branch = branch that we're running, or hash if detached.  
// Hash = hash that we're running, empty if head.
//      There are some odd things about hashes, since a hash can belong to more than one branch.  For purposes of reporting, we have 3 categories to worry

// Import shared library containing basic commands with telemetry
// Import library at specific branch

// We run the build and test for each platform.
// pseudocode
// (in parallel) {
//     Build platform (builds product + tests and submits to helix)
// }
// Publish Packages to Feeds - Release
// Publish Packages to Drop - Debug

