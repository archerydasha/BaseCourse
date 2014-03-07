package com.basecourse.actions;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.io.ByteStreams;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by dshcherbyna on 03.03.14.
 */
public class ZipUnpacker {
    public void unpackZipFile(InputStream zipStream, File rootDirectory){
        Preconditions.checkNotNull(rootDirectory);
        String rootDirectoryName = checkRootDirectory(rootDirectory);

        ZipInputStream feedZipStream = null;
        ZipEntry entry;
        try {
            try {
                feedZipStream = new ZipInputStream(zipStream);
                while ((entry = feedZipStream.getNextEntry()) != null) {
                    File destinationFile = new File(rootDirectoryName, entry.getName());
                    unpackEntry(destinationFile, feedZipStream);
                }
            } finally {
                if (feedZipStream != null) {
                    feedZipStream.close();
                }
            }
        } catch (Exception e) {
            Throwables.propagate(e);
        }
    }

    private String checkRootDirectory(File rootDirectory) {
        if (rootDirectory == null || (rootDirectory.exists() && !rootDirectory.isDirectory())) {
            throw new IllegalArgumentException(rootDirectory + " is not a valid directory");
        }
        if (!rootDirectory.exists()) {
            rootDirectory.mkdirs();
        }
        return rootDirectory.getPath();
    }

    private void unpackEntry(File destinationFile, ZipInputStream feedZipStream) throws IOException {
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(destinationFile));
            for (int c = feedZipStream.read(); c != -1; c = feedZipStream.read()) {
                outputStream.write(c);
            }
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
