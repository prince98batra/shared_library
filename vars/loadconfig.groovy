def call() {
    def config = loadConfig()

    if (config.KEEP_APPROVAL_STAGE)
 {
        echo "Skipping approval as per config!"
    }
 else {
        pipeline {
            stages {
                stage('User Approval')
 {
                    steps {
                        input message: "Proceed with deployment?", ok: 'Approve'
                    }
                }
            }
        }
    }
}
