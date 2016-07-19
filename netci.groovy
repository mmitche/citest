// Import the utility functionality.

import jobs.generation.*;

def project = GithubProject
def branch = GithubBranchName

[true, false].each { isPR ->
    ['A', 'B', 'C', 'D', 'E', 'F'].each { letter ->
        def newJob = job(Utilities.getFullJobName(project, "innerloop_${letter}", isPR)) {
            steps {
                batchFile("echo https://www.google.com > links1.txt")
                batchFile("echo https://www.github.com >> links1.txt")
                batchFile("echo https://www.microsoft.com >> links1.txt")
                
                batchFile("echo https://www.bing.com > links2.txt")
                batchFile("echo https://www.reddit.com >> links2.txt")
                batchFile("echo https://www.facebook.com >> links2.txt")
            }
        }
        
        // Emit summaries
        SummaryBuilder summaries = new SummaryBuilder()
        summaries.addLinksSummaryFromFile('Crash dumps from this run', 'links1.txt')
        summaries.addLinksSummaryFromFile('Uncrash dumps from this run', 'links2.txt')
        summaries.emit(newJob)
        
        Utilities.setMachineAffinity(newJob, 'Windows_NT', 'latest-or-auto')
        Utilities.standardJobSetup(newJob, project, isPR, "*/${branch}")
        if (isPR) {
            Utilities.addGithubPRTriggerForBranch(newJob, branch, "Say Hello${letter}")
        }
        else {
            Utilities.addGithubPushTrigger(newJob)
        }
    }
}