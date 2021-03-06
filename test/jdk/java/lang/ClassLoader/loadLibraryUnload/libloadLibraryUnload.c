/*
 * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2021, BELLSOFT. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

#include <stdio.h>
#include "jni.h"

static volatile jobject ref = NULL;

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved)
{
    JNIEnv *env;

    printf("Native library loaded.\n");
    fflush(stdout);

    if ((*vm)->GetEnv(vm, (void**) &env, JNI_VERSION_1_2) != JNI_OK) {
        return JNI_EVERSION; /* JNI version not supported */
    }

    return JNI_VERSION_1_2;
}

JNIEXPORT void JNICALL Java_p_Class1_setRef(JNIEnv *env, jobject this, jobject obj) {
    if (ref == NULL) {
        // Only create a single GlobalRef
        ref = (*env)->NewGlobalRef(env, obj);
        printf("GlobalRef created\n");
    }
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *vm, void *reserved) {

    if (ref != NULL) {
        JNIEnv *env = NULL;
        if ((*vm)->GetEnv(vm, (void**) &env, JNI_VERSION_1_2) != JNI_OK) {
            return; /* JNI version not supported */
        }
        (*env)->DeleteGlobalRef(env, ref);
        printf("GlobalRef deleted\n");
    }
    printf("Native library unloaded.\n");
    fflush(stdout);
}

