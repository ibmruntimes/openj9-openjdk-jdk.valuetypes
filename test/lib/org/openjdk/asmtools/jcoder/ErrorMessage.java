/*
<<<<<<<< HEAD:test/lib/org/openjdk/asmtools/jcoder/ErrorMessage.java
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
========
 * Copyright (c) 1999, 2023, Oracle and/or its affiliates. All rights reserved.
>>>>>>>> d04974410fa8de945586663016667fc7bb89c054:test/jdk/javax/swing/JTable/bug4243159.java
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
package org.openjdk.asmtools.jcoder;

<<<<<<<< HEAD:test/lib/org/openjdk/asmtools/jcoder/ErrorMessage.java
/**
 * A sorted list of error messages
 */
final class ErrorMessage {

    int where;
    String message;
    ErrorMessage next;

    /**
     * Constructor
     */
    ErrorMessage(int where, String message) {
        this.where = where;
        this.message = message;
========
/*
   @test
   @bug 4243159
   @summary Tests that JTable() do not throw ArrayIndexOutOfBoundsException
*/

import javax.swing.JTable;

public class bug4243159 {

    /* Looks boring, but tests the no-args constructor works */
    public static void main(String[] argv) {
        JTable table = new JTable();
>>>>>>>> d04974410fa8de945586663016667fc7bb89c054:test/jdk/javax/swing/JTable/bug4243159.java
    }
}
