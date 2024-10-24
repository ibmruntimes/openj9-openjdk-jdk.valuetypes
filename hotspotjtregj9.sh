#!/bin/bash

JTREGHOME="/Users/theresamammarella/jtreg"
EXTENSIONSBASEDIR=$(pwd)
TEST_JDK_HOME=$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/images/jdk
TEST_IMAGE=$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/images/test

# https://github.com/eclipse-openj9/openj9/issues/20386
# Add --patch-module java.base=$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/jdk/lib/valueclasses/java.base-valueclasses.jar

# run-test-prebuilt runs tests without recompiling the jdk
make run-test-prebuilt \
    TEST="hotspot_valhalla" \
    JTREG_EXTRA_PROBLEM_LISTS="$EXTENSIONSBASEDIR/ProblemList-hotspotjtreg.txt" \
    JTREG_JAVA_OPTIONS="-XX:ValueTypeFlatteningThreshold=99999 -XX:+EnableArrayFlattening" \
    BOOT_JDK=$TEST_JDK_HOME \
    JT_HOME=$JTREGHOME \
    JDK_IMAGE_DIR=$TEST_JDK_HOME \
    TEST_IMAGE_DIR=$TEST_IMAGE
