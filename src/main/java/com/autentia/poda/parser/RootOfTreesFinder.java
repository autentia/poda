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
package com.autentia.poda.parser;

import com.autentia.poda.FileMetadata;
import com.autentia.poda.FilesCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RootOfTreesFinder implements FileParser {

    private final List<FileMetadata> roots = new ArrayList<>();

    public RootOfTreesFinder(FilesCollection filesToInspect) {
        roots.addAll(filesToInspect.getAll());
    }

    @Override
    public void beforeParsingFile(FileMetadata fileToParse) {
    }

    @Override
    public void afterParsingFile(FileMetadata parsedFile) {
        roots.removeAll(parsedFile.references());
    }

    public List<FileMetadata> rootOfTrees() {
        return Collections.unmodifiableList(roots);
    }

}
