import groovy.time.TimeCategory 
import groovy.time.TimeDuration

def call(Closure body) {
    echo "Starting step"
    def start = new Date()
    body()
    def stop = new Date()
    TimeDuration td = TimeCategory.minus( stop, start )
    echo "Finishing step (took ${td})"
}