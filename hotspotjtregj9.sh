#!/bin/bash

JTREGHOME="/Users/theresamammarella/jtreg"
EXTENSIONSBASEDIR=$(pwd)
TEST_JDK_HOME=$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/images/jdk

# run-test-prebuilt runs tests without recompiling the jdk
make run-test-prebuilt TEST="hotspot_valhalla" BOOT_JDK=$TEST_JDK_HOME JT_HOME=$JTREGHOME JDK_IMAGE_DIR=$TEST_JDK_HOME TEST_IMAGE_DIR="$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/images/test" JTREG_EXTRA_PROBLEM_LISTS="$EXTENSIONSBASEDIR/ProblemList-J9Valhalla.txt" JTREG_JAVA_OPTIONS="-XX:ValueTypeFlatteningThreshold=99999 -XX:+EnableArrayFlattening"
