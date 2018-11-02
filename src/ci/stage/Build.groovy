package ci

def call(displayTestResults, failBuildOnMissingResults, displayCoverage, updateDependencies){
    stage ("Build") {
        command = "gradlew clean build" + (updateDependencies ? "--update-dependencies" : "")
        bat command
        
        if(displayTestResults){
            junit testResults: "/build/test-results/**/*.xml", allowEmptyResults: !failBuildOnMissingResults
        }

        if(displayCoverage){
            step( [ $class: 'JacocoPublisher' ] )
        }
    }
}
