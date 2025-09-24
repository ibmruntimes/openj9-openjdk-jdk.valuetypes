#!/bin/bash

JTREGHOME="/Users/theresamammarella/jtreg"
EXTENSIONSBASEDIR=$(pwd)
TEST_JDK_HOME=$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/images/jdk
TEST_IMAGE=$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/images/test

# run-test-prebuilt runs tests without recompiling the jdk
make run-test-prebuilt \
    TEST="hotspot_valhalla" \
    JTREG_EXTRA_PROBLEM_LISTS="$EXTENSIONSBASEDIR/ProblemList-hotspotjtreg.txt" \
    JTREG_JAVA_OPTIONS="--enable-preview -XX:ValueTypeFlatteningThreshold=99999 -XX:+EnableArrayFlattening -Djdk.debug=release --patch-module java.base=$EXTENSIONSBASEDIR/build/macosx-aarch64-server-release/jdk/lib/valueclasses/java.base-valueclasses.jar" \
    BOOT_JDK=$TEST_JDK_HOME \
    JT_HOME=$JTREGHOME \
    JDK_IMAGE_DIR=$TEST_JDK_HOME \
    TEST_IMAGE_DIR=$TEST_IMAGE
