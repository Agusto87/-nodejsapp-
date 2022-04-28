job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/Agusto87/-nodejsapp-.git', 'master') { node ->
            node / gitConfigName('aureliosanchezfuentes')
            node / gitConfigEmail('aureliosanchezfuentes@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('NodeJs')
    }
    steps {
        shell("npm install")
    }
    publishers {
	slackNotifier {
            notifyAborted(true)
            notifyEveryFailure(true)
            notifyNotBuilt(false)
            notifyUnstable(false)
            notifyBackToNormal(true)
            notifySuccess(true)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            customMessage(null)
            sendAs(null)
            commitInfoChoice('NONE')
            teamDomain(null)
            authToken(null)
        }
    }
}
