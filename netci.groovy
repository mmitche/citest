// Import the utility functionality.

import jobs.generation.*;
import hudson.EnvVars;
import hudson.model.Executor;

def project = GithubProject
def branch = GithubBranchName
def projectFolder = Utilities.getFolderName(project) + '/' + Utilities.getFolderName(branch)

[true,false].each { isPR ->
    ['A'].each { letter ->
        def newJob = job(Utilities.getFullJobName(project, "innerloop_${letter}", isPR)) {
            steps {
                shell("echo Hello World")
            }
        }
        
        Utilities.setMachineAffinity(newJob, 'Ubuntu14.04', 'latest-or-auto')
        Utilities.standardJobSetup(newJob, project, isPR, "*/${branch}")
        if (isPR) {
            TriggerBuilder builder = TriggerBuilder.triggerOnPullRequest()
            builder.triggerByDefault()
            builder.setGithubContext("Hello World Job")
            builder.triggerForBranch(branch)
            builder.emitTrigger(newJob)
        }
    }
}