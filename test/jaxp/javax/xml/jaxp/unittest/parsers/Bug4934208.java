/*
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates. All rights reserved.
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

package parsers;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import util.DraconianErrorHandler;

/*
 * @test
 * @bug 4934208
 * @library /javax/xml/jaxp/libs /javax/xml/jaxp/unittest
 * @run testng/othervm parsers.Bug4934208
 * @summary Test SAXParser can parse keyref constraint with a selector that is a union xpath expression selecting a node and its child.
 */
public class Bug4934208 {
    @Test
    public void test1() throws Exception {
        parse(new InputSource(Bug4934208.class.getResourceAsStream("test1.xml")));
    }

    @Test
    public void test2() throws Exception {
        try {
            parse(new InputSource(Bug4934208.class.getResourceAsStream("test2.xml")));
        } catch (SAXException e) {
            Assert.assertTrue(e.getMessage().startsWith("cvc-complex-type.2.4.a"));
        }
    }

    private void parse(InputSource is) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(true);
        SAXParser parser = spf.newSAXParser();

        parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource", Bug4934208.class.getResourceAsStream("test.xsd"));

        XMLReader r = parser.getXMLReader();

        r.setErrorHandler(new DraconianErrorHandler());
        r.parse(is);
    }
}
