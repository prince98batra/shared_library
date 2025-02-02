def call(String repoUrl) {
    script {
        def config = loadconfig()  // Load config.yml
        def branch = config.ENVIRONMENT ?: "main"  // Default to "main" if ENVIRONMENT is null        echo "Cloning repository from branch: ${branch}"        sh '''
            if [ -d "shared_library" ]; then
                echo ":white_tick: Repository already cloned. Pulling latest changes..."
                cd shared_library
                git reset --hard
                git clean -fd
                git pull origin ''' + branch + '''
            else
                echo ":inbox_tray: Cloning fresh repository..."
                rm -rf shared_library
                git clone -b ''' + branch + ''' ''' + repoUrl + '''
            fi
        '''
    }
}
