#!/bin/bash
/usr/lib/jvm/java-13-openjdk-amd64/bin/java -agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:42747 -Dfile.encoding=UTF-8 @/tmp/cp_72cfmr6arkgv7ccrs1t3g63he.argfile gytar.Main
