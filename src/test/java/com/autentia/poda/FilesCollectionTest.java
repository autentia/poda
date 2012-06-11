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

import java.io.File;
import java.util.Collection;

import static com.autentia.poda.TestCommons.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class FilesCollectionTest {

    @Test
    public void scanAllFiles() throws Exception {
        assertFilesMetadata(files.getAll(), FILES);
    }

    @Test
    public void getByPath() throws Exception {
        FileMetadata fileByPath = files.getByPath(SRC_TEST_RESOURCES + "com/autentia/notReferenced.txt");
        assertThat(fileByPath.getFile(), equalTo(new File(SRC_TEST_RESOURCES + "com/autentia/notReferenced.txt")));
    }

    @Test
    public void getByName() throws Exception {
        Collection<FileMetadata> filesWithSameName = files.getByName("notReferenced.txt");
        assertFilesMetadata(filesWithSameName, FILES_WITH_SAME_NAME);
    }

    private void assertFilesMetadata(Collection<FileMetadata> actualFilesMetadata, File[] expectedFiles) {
        assertThat(actualFilesMetadata, hasSize(expectedFiles.length));
        for (FileMetadata actualFileMetadata : actualFilesMetadata) {
            assertThat(actualFileMetadata.getFile(), isIn(expectedFiles));
        }
    }
}