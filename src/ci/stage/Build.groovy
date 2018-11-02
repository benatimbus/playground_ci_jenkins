package ci

def build(){
    stage ("Build") {
        bat "gradlew clean assemble"
    }
}
