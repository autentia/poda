/**
 * Poda by Autentia Real Business Solution S.L.
 * Copyright (C) 2012 Autentia Real Business Solution S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.autentia.poda;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.autentia.poda.TestEnvironment.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class TextGraphTest {

    private static final Logger logger = LoggerFactory.getLogger(TextGraphTest.class);

    private static final String EXPECTED_GRAPH =
            "1 - " + SRC_TEST_RESOURCES + "com/autentia/main.txt[0]\n" +
            "2 -     " + SRC_TEST_RESOURCES + "com/autentia/Utils.txt[2]\n" +
            "3 -         " + SRC_TEST_RESOURCES + "com/autentia/model/Negocio.txt[2]\n" +
            "4 -             " + SRC_TEST_RESOURCES + "com/autentia/Utils.txt[2] --> 2\n" +
            "5 -             " + SRC_TEST_RESOURCES + "com/autentia/resources/prohibidos-monos-lagartos-150x150.gif[1](B)\n" +
            "6 -     " + SRC_TEST_RESOURCES + "com/autentia/model/Negocio.txt[2] --> 3\n" +
            "7 - " + SRC_TEST_RESOURCES + "com/autentia/notReferenced.txt[0]\n" +
            "8 - " + SRC_TEST_RESOURCES + "com/autentia/resources/autentia.png[0](B)\n" +
            "9 - " + SRC_TEST_RESOURCES + "notReferenced.txt[0]\n" +
            "10 -     " + SRC_TEST_RESOURCES + "com/autentia/resources/alejandropgarci.jpg[1](B)\n";

    private static final String DEEP_LEVEL_2_EXPECTED_GRAPH =
            "1 - " + SRC_TEST_RESOURCES + "com/autentia/main.txt[0]\n" +
            "2 -     " + SRC_TEST_RESOURCES + "com/autentia/Utils.txt[2]\n" +
            "3 -         +\n" +
            "4 -     " + SRC_TEST_RESOURCES + "com/autentia/model/Negocio.txt[2]\n" +
            "5 -         +\n" +
            "6 - " + SRC_TEST_RESOURCES + "com/autentia/notReferenced.txt[0]\n" +
            "7 - " + SRC_TEST_RESOURCES + "com/autentia/resources/autentia.png[0](B)\n" +
            "8 - " + SRC_TEST_RESOURCES + "notReferenced.txt[0]\n" +
            "9 -     " + SRC_TEST_RESOURCES + "com/autentia/resources/alejandropgarci.jpg[1](B)\n";

    @Test
    public void graphAsString() throws Exception {
        TextGraph textGraph = new TextGraph(ROOT_OF_TREES_FINDER.rootOfTrees(), Integer.MAX_VALUE);
        logger.debug("\n{}", textGraph);

        assertThat(textGraph.toString(), equalTo(EXPECTED_GRAPH));
    }

    @Test
    public void deepLevel2GraphAsString() throws Exception {
        TextGraph textGraph = new TextGraph(ROOT_OF_TREES_FINDER.rootOfTrees(), 2);
        logger.debug("\n{}", textGraph);

        assertThat(textGraph.toString(), equalTo(DEEP_LEVEL_2_EXPECTED_GRAPH));
    }

}
