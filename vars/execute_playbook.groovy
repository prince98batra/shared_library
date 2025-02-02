def call() {
    def config = loadConfig()    echo "Executing Playbook..."   
 script {
        sh " cd /home/prometheus && ansible-playbook -i /home/prometheus/tests/inventory /home/prometheus/tests/test.yml"
    }
}
