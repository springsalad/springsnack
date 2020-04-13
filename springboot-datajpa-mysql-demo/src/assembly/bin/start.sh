#!/bin/bash

### app directory layout
# <apphome>/bin
# <apphome>/conf
# <apphome>/lib
###########


#userdir
BINDIR=$(cd $(dirname $0) ; pwd)
echo current path:$BINDIR

#
PIDFILE="./start.pid"
if [ -f $PIDFILE ]; then
    if kill -0 `cat $PIDFILE` > /dev/null 2>&1; then
        echo server already running as process `cat $PIDFILE`. 
        exit 0
    fi
fi




# exec
nohup java $CUSTOM_JAVA_OPTS $JAVA_OPTS -XX:+UseG1GC -classpath $BINDIR/../conf/:$BINDIR/../lib/*   person.flowerpowder.demo.springboot.db.mysql.basic.MySqlBasicDemoApp &

# wirte pid to file
if [ $? -eq 0 ] 
then
    if /bin/echo -n $! > "$PIDFILE"
    then
        sleep 1
        echo STARTED SUCCESS
    else
        echo FAILED TO WRITE PID
        exit 1
    fi
#    tail -100f $LOGFILE
else
    echo SERVER DID NOT START
    exit 1
fi
