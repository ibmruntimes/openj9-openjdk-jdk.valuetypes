/*
 * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;

public class MixedValues {
    static Point staticPoint = Point.makePoint(10, 10);
    static Line.ref staticLine;   // null static field of non-flattened type
    static ValueOptional staticValue;
    Point p;
    Line l;
    MutablePath mutablePath;
    List<String> list;
    Point.ref nfp;
    ValueOptional voptional;

    public MixedValues(Point p, Line l, MutablePath path, String... names) {
        this.p = p;
        this.l = l;
        this.mutablePath = path;
        this.list = List.of(names);
        this.nfp = p;
        this.voptional = new ValueOptional(p);
    }
}
