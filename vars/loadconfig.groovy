def call() {
   def config = readYaml file: 'resources/config.yml'
    return config
}
